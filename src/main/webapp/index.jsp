<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page import="java.util.List"%>
<%@ page import="edu.mum.asd.project.fw.spot.Parking"%>

<%@ include file="header.jsp" %>
<div class="row">
    <div class="col-4">
        <div class="list-group" id="parkingList" role="tablist">
            <c:forEach items="${requestScope.parkings}" var="parking">
                <a class="list-group-item list-group-item-action parkingBtns" id="list-home-list" data-toggle="list" href="#${parking.id}" role="tab" aria-controls="home">${parking.id}. ${parking.name}</a>
            </c:forEach>
        </div>
    </div>
    <div class="col-8">
        <div class="tab-content" id="nav-tabContent">
    	   <div class="tab-pane fade show active" role="tabpanel" aria-labelledby="list-home-list">

                <div  id="viewSpots" class="row">
                    <div class="alert alert-warning" role="alert">choose park</div>
                </div>

            </div>
        </div>
    </div>
</div>
<div id="templatecheckin" class="d-none">
    <div class="card bg-light bg-primary mb-3" style="max-width: 10rem;">
        <div class="card-header spotrowcol">1-2</div>
        <div class="card-body">
            <button type="button" class="badge badge-primary btn btn-outline-primary spotsize1 checkindata" data-toggle="modal" data-target="#spotModalCheckIn">check-in</button>
        </div>
    </div>    
</div>
<div id="templatecheckout" class="d-none">
    <div class="card bg-light bg-primary mb-3" style="max-width: 10rem;">
        <div class="card-header spotrowcol">1-2</div>
        <div class="card-body">
            <button type="button" class="badge badge-primary btn btn-outline-primary spotsize1 washdata" data-toggle="modal" data-target="#spotModalWash" data-recordid="1">wash</button>
            <button type="button" class="badge badge-primary btn btn-outline-primary spotsize1 checkoutdata" data-toggle="modal" data-target="#spotModalCheckOut" data-recordid="1">check-out</button>
        </div>
    </div>    
</div>
<script type="text/javascript">
    function callSpotsByParking(pId) {
        var contextRoot = "/" + window.location.pathname.split('/')[1];
        $("#viewSpots").empty();
        $.ajax({
            type: "GET",
            url: contextRoot + "/api/spotsdata",
            data: {
                pId: pId
            },
            success: function (result) {
                $.each(result, function (index, data) {
                	console.log("DAATA " , data);
                	$("#templatecheckin").addClass("asd");
                    $("#templatecheckin").find(".spotrowcol").html(data.row + '-' + data.col);
                        var spotTypeName = "(REGULAR)";
                        if (data.spotTypeId == 2){
                            spotTypeName = "(LARGE)";
                        }
                        $("#templatecheckin").find(".spotrowcol").html(data.row + '-' + data.col + ' ' + spotTypeName);
                    $("#templatecheckin").find(".checkindata").attr('data-spotid', data.spotId).attr('data-parkingid', data.parkingId).attr('data-spottypeid', data.spotTypeId);

                    
                    $("#templatecheckout").find(".spotrowcol").html(data.row + '-' + data.col);
                        $("#templatecheckout").find(".spotrowcol").html(data.row + '-' + data.col + ' ' + spotTypeName);
                    $("#templatecheckout").find(".washdata").prop('disabled', false).attr('data-recordid', data.recordId).attr('data-parkingid', data.parkingId);
                	$("#templatecheckout").find(".washdata").css("border-color", "#007bff").css("color", "#fff").css("background-color", "#007bff");

                    $("#templatecheckout").find(".checkoutdata").attr('data-recordid', data.recordId).attr('data-parkingid', data.parkingId);
                    var tmpHtml = $("#templatecheckin").html();
                    if(data.spotTypeId == 2) {
         				console.log("BBBIIIIIIIG", data);
                		$("#templatecheckout .card").css({"width": "200px"});
                		$("#templatecheckin .card").css({"width": "200px"});
                	}
                    else {
                    	$("#templatecheckout .card").css({"width": "130px"});
                		$("#templatecheckin .card").css({"width": "130px"});
                    }
                    if (data.recordId != 0) {
                            if (data.washed == true) {
                            $("#templatecheckout").find(".washdata").prop('disabled', true).css("border-color", "orange").css("color", "orange").css("background","#fff");
                        }
                        else if (data.washed == false && data.washRequested == true) {
                            $("#templatecheckout").find(".washdata").prop('disabled', true);                        	
                        }

                        tmpHtml = $("#templatecheckout").html();
                    } else {
                    }
                    $("#viewSpots").append(tmpHtml)
                });
                let btn = $("<button/>").attr("id", "washpark").addClass("btn btn-primary btn-sm mb-2 container").text("Wash All")
                            .click(function () {
               	 $.ajax({
                        type: "POST",
                        url: contextRoot + "/api/parkWash",
                        data: {
                       	 pId: pId
                        },
                        success: function (response) {
                            callSpotsByParking(pId);
                        },
                        error: function (e) {
                            console.log('error', e);
                            alert('Error: ' + e);
                        }
                    });
                });
                $("#viewSpots").prepend(btn);
            }
        });
    }
    $('a[data-toggle="list"]').on('shown.bs.tab', function (e) {
        e.target // newly activated tab
        e.relatedTarget // previous active tab
        let
        pId = $(this).attr('href');
        pId = pId.substr(1, pId.length);
        callSpotsByParking(pId);
    }
    );
    $(document).on('show.bs.modal', '#spotModalCheckIn', function (event) {
        var button = $(event.relatedTarget)
        $(this).find('.sId').val(button.data('spotid'))
        $(this).find('.pId').val(button.data('parkingid'))
        $(this).find('#spotType').val(button.data('spottypeid'))
        if ($("#spotType").val() == 2) {
            $("#carType").html("").append('<option value="">Choose...</option><option value="1">REGULAR</option><option value="2">LARGE</option>');
        } else {
            $("#carType").html("").append('<option value="">Choose...</option><option value="1">REGULAR</option>');
        }
        $(this).find('#spotType').val(button.data('spottypeid'))
    });

    $(document).on('submit', '#spotModalCheckIn', function (event) {
        event.preventDefault()
        var contextRoot = "/" + window.location.pathname.split('/')[1];
        var pid = $("#spotCheckInForm").find(".pId").val();
        $.ajax({
            type: "POST",
            url: contextRoot + "/api/spotCheckIn",
            data: $("#spotCheckInForm").serialize(),
            success: function (response) {
                $("#spotModalCheckIn .closeBtn").click();
                callSpotsByParking(pid);
//                alert('SUCCESS check in');
            },
            error: function (e) {
                console.log('error', e);
                alert('Error: ' + e);
            }
        });
    });
    /* wash */
    $(document).on('show.bs.modal', '#spotModalWash', function (event) {
        var button = $(event.relatedTarget)
        $(this).find('.rId').val(button.data('recordid'))
        $(this).find('.pId').val(button.data('parkingid'))
    });
    $(document).on('submit', '#spotModalWash', function (event) {
        event.preventDefault()
        var contextRoot = "/" + window.location.pathname.split('/')[1];
        var pid = $("#spotWashForm").find(".pId").val();
        $.ajax({
            type: "POST",
            url: contextRoot + "/api/spotWash",
            data: $("#spotWashForm").serialize(),
            success: function (response) {
                $("#spotModalWash .closeBtn").click();
                callSpotsByParking(pid);
//                alert('SUCCESS wash request');
            },
            error: function (e) {
                console.log('error', e);
                alert('Error: ' + e);
            }
        });
    });
    /* check out */
    $(document).on('show.bs.modal', '#spotModalCheckOut', function (event) {
        var button = $(event.relatedTarget)
        var rId = button.data('recordid');
        $(this).find('.rId').val(rId)
        $(this).find('.pId').val(button.data('parkingid'))
        var contextRoot = "/" + window.location.pathname.split('/')[1];
        $.ajax({
            type: "GET",
            url: contextRoot + "/api/spotCheckOut",
            data: {
                rId: rId
            },
            success: function (response) {
                $("#spotModalCheckOut").find('#pricespan').html(response);
            },
            error: function (e) {
                console.log('error', e);
                alert('Error: ' + e);
            }
    });
    });

    $(document).on('submit', '#spotModalCheckOut', function (event) {
        event.preventDefault()
        var contextRoot = "/" + window.location.pathname.split('/')[1];
        var pid = $("#spotCheckOutForm").find(".pId").val();
        $.ajax({
            type: "POST",
            url: contextRoot + "/api/spotCheckOut",
            data: $("#spotCheckOutForm").serialize(),
            success: function (response) {
                $("#spotModalCheckOut .closeBtn").click();
                callSpotsByParking(pid);
//                alert('SUCCESS check out');
            },
            error: function (e) {
                console.log('error', e);
                alert('Error: ' + e);
            }
        });
    });
</script>

<div class="modal fade" id="spotModalCheckIn" tabindex="-1" role="dialog" aria-labelledby="spotModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="spotModalLabel">Check in</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="form-row">
                <div class="modal-body">
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <label class="input-group-text" for="inputGroupSelect02">Spot Type *</label>
                        </div>
                        <select class="custom-select form-control" id="spotType" disabled>
                            <option value="">Choose...</option>
                            <option value="1">REGULAR</option>
                            <option value="2">LARGE</option>
                        </select>
                    </div>
                </div>
            </div>
            <form id="spotCheckInForm">
                <div class="modal-body">
                    <div class="input-group">
                        <div class="input-group-prepend">
                            <label class="input-group-text" for="inputGroupSelect01">Customer</label>
                        </div>
                        <select class="custom-select" id="inputGroupSelect01" name="cusId">
                            <option value="">Choose...</option>
                            <c:forEach items="${requestScope.members}" var="member">
                                <option value="${member.id}">${member.id}. ${member.firstName} ${member.lastName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <div class="form-row">
                    <div class="modal-body">
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <label class="input-group-text" for="inputGroupSelect02">Car Type *</label>
                            </div>
                            <select class="custom-select form-control" id="carType" name="carTypeId" required></select>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="hidden" name="sId" class="sId" value="">
                    <input type="hidden" name="pId" class="pId" value="">
                    <button type="button" class="btn btn-secondary closeBtn" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary" id="checkInBtn">Send request</button>
                </div>
            </form>
        </div>
    </div>
</div>
<div class="modal fade" id="spotModalWash" tabindex="-1" role="dialog" aria-labelledby="spotModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="spotModalLabel">Wash</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>Do you want to wash this car?</p>
            </div>
            <form id="spotWashForm">
                <div class="modal-footer">
                    <input type="hidden" name="rId" class="rId" value="">
                    <input type="hidden" name="pId" class="pId" value="">
                    <button type="button" class="btn btn-secondary closeBtn" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary" id="washBtn">Send request</button>
                </div>
            </form>
        </div>
    </div>
</div>
<div class="modal fade" id="spotModalCheckOut" tabindex="-1" role="dialog" aria-labelledby="spotModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="spotModalLabel">Checkout</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form id="spotCheckOutForm">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="recipient-name" class="col-form-label">Price</label>
                        <span class="input-group-text" id="pricespan">price</span>
                    </div>
                </div>
                <div class="modal-footer">
                    <input type="hidden" name="rId" class="rId" value="">
                    <input type="hidden" name="pId" class="pId" value="">
                    <button type="button" class="btn btn-secondary closeBtn" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary" id="checkOutBtn">Send request</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>

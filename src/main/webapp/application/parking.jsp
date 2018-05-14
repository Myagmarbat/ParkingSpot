
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page import="java.util.List"%>
<%@ page import="edu.mum.asd.project.fw.customer.Member"%>


<%@ include file="../header.jsp" %>
<div class="mb-2">
<a class="btn btn-primary" href="index.jsp" role="button">back</a>
<button class="btn btn-primary" id="addCustomerBtn" type="button"
        data-toggle="modal" data-target="#parkForm">Add parking</button>
</div>

<table class="table table-striped">
    <thead>
        <tr>
            <th scope="col">Park name</th>
            <th scope="col">Capacity</th>
            <th scope="col">Truck lot number</th>
            <th scope="col">Car lot number</th>
        </tr>
    </thead>
    <tbody>
 
    <c:forEach items="${requestScope.parkings}" var="park">
   <tr>
	<td>
    	${park.parkName }
    	</td>
    	<td>
    	${park.capacity }
    	</td>
    	<td>
    	${park.truck }
    	</td>
    	<td>
    	${park.regular }
    	</td>
   </tr>

    </c:forEach>
    </tbody>
</table>

<div class="modal fade" id="parkForm" tabindex="-1" role="dialog"
     aria-labelledby="parkForm" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="parkForm">New Parking</h5>
                <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form method="POST" id="newParkForm">
                <div class="modal-body">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <input type="text" class="form-control" name="name"
                                   placeholder="Name">
                        </div>
                    </div>

                    <div class="parkingList">
                    <div class="form-group"> 
                        <button class="btn btn-outline-secondary form-control" id="addParkingField" type="button">Add row</button>
                    </div>
                        <div class="form-group" id="inputBudget">
                            <div class="input-group">
                                <input type="text" class="form-control" name="qty" placeholder="Quantity"> 
                                <select class="custom-select"
                                        name="qtyType" id="qtyType">
                                    <option selected>Choose...</option>
                                    <option value="1">Regular</option>
                                    <option value="2">Large</option>
                                </select>
                                <button class="btn btn-outline-secondary deleteBtn" disabled type="button">Delete</button>
                            </div>
                        </div>
                        <div id="test" class="input-group"></div>

                    </div>


                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary"
                                data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-primary">Sign in</button>
                    </div>
            </form>
        </div>
    </div>
</div>
<script type="text/javascript">
    $("#addParkingField").click(function () {
        $("#test").append('<div class="input-group"><input type="text" class="form-control" name="qty" placeholder="Quantity"> <select class="custom-select" name="qtyType" id="qtyType"> <option selected>Choose...</option> <option value="1">Regular</option> <option value="2">Large</option> </select><button class="btn btn-outline-secondary deleteBtn" type="button">Delete</button></div>');
    });
    $(document).on('click', '.deleteBtn', function () {
        $(this).parent().remove();
    });

</script>
</body>
</html>
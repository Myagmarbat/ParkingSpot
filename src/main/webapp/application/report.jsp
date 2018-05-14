<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ include file="../header.jsp" %>

<a href="download" class="btn btn-primary mb-2">Excel</a>
<form class="form-inline mb-2" action="report" method="get" >
	<div class="form-group" >
		<input class="form-control" type="text" name="searchWord" value="" placeHolder="customer name or parking" />
	</div>
	<input class="btn btn-primary" type="submit" value="search" />
</form>
	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Customer name</th>
				<th scope="col">Parking ID info</th>
				<th scope="col">Start time</th>
				<th scope="col">End time</th>
				<th scope="col">Duration</th>
				<th scope="col">Washed</th>
				<th scope="col">Price</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${requestScope.reports}" var="report" varStatus="loop">
			<tr>
				<th scope="row">${loop.index + 1 }</th>
				<td>${report.customerName }</td>
				<td>${report.parkingName }-${report.row }-${report.col }</td>
				<td>${report.checkinDate }</td>
				<td>${report.checkoutDate }</td>
				<td>${report.duration }</td>
				<td>${report.washed }</td>
				<td>${report.price }</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>

	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ page import="java.util.List"%>
<%@ page import="edu.mum.asd.project.fw.customer.Member"%>

<title>Customer</title>

	<%@ include file="../header.jsp" %>
	<div class="mb-2">
		<a class="btn btn-primary" href="index.jsp" role="button">back</a>
		<button class="btn btn-primary" id="addCustomerBtn" type="button"
			data-toggle="modal" data-target="#customerForm">Add Customer</button>
	</div>



	<table class="table table-striped">
		<thead>
			<tr>
				<th scope="col">First name</th>
				<th scope="col">Last name</th>
				<th scope="col">Email</th>
				<th scope="col">Customer type</th>
				<th scope="col">Address</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${requestScope.members}" var="member">
				<tr>
					<td>${member.firstName}</td>
					<td>${member.lastName}</td>
					<td>${member.email }</td>
					<td>${member.customerType.name }</td>
					<td>${member.address }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<div class="modal fade" id="customerForm" tabindex="-1" role="dialog"
		aria-labelledby="customerForm" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="customerForm">New Customer</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form action="customer" method="POST" id="form">
					<div class="modal-body">
						<div class="form-row">
							<div class="form-group col-md-6">
								<input type="text" class="form-control" name="lastname"
									placeholder="Last name">
							</div>
							<div class="form-group col-md-6">
								<input type="text" class="form-control" name="firstname"
									placeholder="First name">

							</div>
						</div>
						<div class="form-group">
							<input type="datetime" class="form-control" name="birthday"
								placeholder="Birthday">
						</div>
						<div class="form-group">
							<input type="email" class="form-control" name="email"
								placeholder="Email">
						</div>
						<div class="form-group">
							<select name="type" class="form-control">
								<option selected>Choose customer type</option>
								<option value="1">Gold</option>
								<option value="2">Silver</option>
								<option value="3">Bronze</option>
							</select>
						</div>
						<div class="form-group">
							<input type="text" class="form-control" name="street"
								placeholder="Street Apt. #">
						</div>
						<div class="form-group">
							<input type="text" class="form-control" name="city"
								placeholder="City">
						</div>
						<div class="form-group">
							<input type="text" class="form-control" name="state"
								placeholder="State">
						</div>
						<div class="form-group">
							<input type="text" class="form-control" name="zip"
								placeholder="Zipcode">
						</div>
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
</body>
<script>
$("#form").submit(function(ev) {
	ev.preventDefault();
	console.log("HELLLOO ", ev);
})
</script>
</html>
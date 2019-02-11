
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>User List</h1>
<table border="2" width="70%" cellpadding="2">
	<tr>
		<th>userName</th>
		<th>userId</th>
		<th>phone</th>
		<th>location</th>
		<th>wallet</th>
	</tr>
	<c:forEach var="user" items="${list}">
		<tr>
			<td>${user.userName}</td>
			<td>${user.userId}</td>
			<td>${user.phone}</td>
			<td>${user.location}</td>
			<td>${user.wallet}</td>
			<td><a
				href="deleteUser/?userName=${user.userName}&userId=${user.userId}&phone=${user.phone}&location=${user.location}&wallet=${user.wallet}">Delete</a></td>
			<td><a
				href="bookCab/?userName=${user.userName}&userId=${user.userId}&phone=${user.phone}&location=${user.location}&wallet=${user.wallet}">Book
					Cab</a></td>

			<td><a
				href="cabCancel/?userName=${user.userName}&userId=${user.userId}&phone=${user.phone}&location=${user.location}&wallet=${user.wallet}">Cab
					Cancel</a></td>


		</tr>
	</c:forEach>
</table>
<br />
<a href="registrationUser">Add New User</a>
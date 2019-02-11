
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Employees List</h1>
<table border="2"  width="70%" cellpadding="2">
	<tr>
		<th>cabName</th>
		<th>cabNumber</th>
		<th>driverName</th>
		<th>phone</th>
		<th>city</th>
		<th>available</th>
	</tr>
	<c:forEach var="cab" items="${list}">
		<tr>
			<td>${cab.cabName}</td>
			<td>${cab.cabNumber}</td>
			<td>${cab.driverName}</td>
			<td>${cab.phone}</td>
			<td>${cab.city}</td>
			<td>${cab.available}</td>
			<td><a
				href="deleteCab/?cabName=${cab.cabName}&cabNumber=${cab.cabNumber}&driverName=${cab.driverName}&phone=${cab.phone}&city=${cab.city}&available=${cab.available}">Delete</a></td>

			<%--  <td><a href="editemp/${emp.id}">Edit</a></td>
     --%>
		</tr>
	</c:forEach>
</table>
<br />
<a href="registrationCab">Add New Cab</a>
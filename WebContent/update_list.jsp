<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>

<html>

<head>
	<title>Update Student</title>
	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-student-style.css">	
</head>

<body>

<div id="wrapper">
	<div id="header">
	<h2>Santa Clara University</h2>
	</div>
</div>

<div id="container">
	
	<h3>Update Student</h3>
	<br/>
	<form action="StudentControlServlet" method="get">
		<input type="hidden" name="command" value="UPDATE" />
		<input type="hidden" name="studentID" value="${THE_STUDENT.id}" />
		
		<table>
			<tbody>
				<tr>
				<td><label>First Name:</label></td>
				<td><input type="text" name="firstName" value="${THE_STUDENT.firstName}" /></td>
				</tr>
				<tr>
				<td><label>Last Name:</label></td>
				<td><input type="text" name="lastName" value="${THE_STUDENT.lastName}" /></td>
				</tr>
				<tr>
				<td><label>Email:</label></td>
				<td><input type="text" name="email" value="${THE_STUDENT.email}" /></td>
				</tr>
				<tr>
				<td><label>Graduate Student:</label></td>
				<td><select name="grad">
						<c:choose>
 							 <c:when test="${THE_STUDENT.grad}">
 						 	<option selected = "selected">Yes</option>
							<option>No</option></c:when>
						<c:when test="${not THE_STUDENT.grad}">
 						 	<option>Yes</option>
							<option selected = "selected">No</option></c:when>				
						</c:choose>
					</select></td>
				</tr>
				<tr>
				<td><label></label></td>
				<td><input type="submit" value="Save" class="save" /></td>
				</tr>
				
			</tbody>
		</table>
	</form>
	
	<div style="clear: both;"></div>
	<p>
	<a href="StudentControlServlet">Back to list</a>
	</p>
</div>


</body>
</html>
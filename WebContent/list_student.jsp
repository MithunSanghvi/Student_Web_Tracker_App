<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>


<!DOCTYPE html>
<html>

<head>
<title>Student Tracker App</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>


<%-- Automatically retrieved by jstl <% List<Student> theStudent = (List<Student>) request.getAttribute("STUDENT-LIST"); %> --%>

<div id="wrapper">
	<div id="header">
	<h2>Santa Clara University</h2>
	</div>
</div>


<div id="container">
	<div id="content">
	
	<input type="button" value="Add Student" onclick="window.location.href='add-student-form.jsp; return false'"
	class="add-student-button" />
		<table border="1">
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email ID</th>
			<th>Graduate</th>
			<th>Action</th>			
		</tr>
		
		<c:forEach  var="temp" items="${STUDENT_LIST}">
		
		<!-- Creating a Link to send student ID to ServletController -->
		<c:url var="updateLink" value="StudentControlServlet">
			<c:param name="command" value="LOAD" />
			<c:param name="studentID" value="${temp.id}" />			
		</c:url>
		
		<c:url var="deleteLink" value="StudentControlServlet">
			<c:param name="command" value="DELETE" />
			<c:param name="studentID" value="${temp.id}" />			
		</c:url>
		
		
		<tr>
			<td> ${temp.firstName} </td>
 			<td> ${temp.lastName} </td> 
 			<td> ${temp.email} </td> 
 			<td> <c:if test="${temp.grad}"> Yes</c:if> <c:if test="${not temp.grad}">No</c:if> </td>
 			<!-- Redirecting to the link created that has command and ID -->
 			<td><a href="${updateLink}">Update</a> | 
 			<a href="${deleteLink}" onclick = "if(!(confirm('Are you sure you want to Delete this student entry?'))) return false">
 			Delete</a>
		</tr>
	
		</c:forEach>
		</table>

	</div>
</div>


</body>
</html>
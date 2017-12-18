<!DOCTYPE html>

<html>

<head>
	<title>Add Student</title>
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
	
	<h3>Add Student</h3>
	<br/>
	<form action="StudentControlServlet" method="get">
		<input type="hidden" name="command" value="ADD" />
		
		<table>
			<tbody>
				<tr>
				<td><label>First Name:</label></td>
				<td><input type="text" name="firstName" /></td>
				</tr>
				<tr>
				<td><label>Last Name:</label></td>
				<td><input type="text" name="lastName" /></td>
				</tr>
				<tr>
				<td><label>Email:</label></td>
				<td><input type="text" name="email" /></td>
				</tr>
				<tr>
				<td><label>Graduate Student:</label></td>
				<td><select name="grad">
					<option>Yes</option>
					<option>No</option>
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
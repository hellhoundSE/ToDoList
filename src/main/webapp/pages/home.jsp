<!DOCTYPE HTML>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
	<title>To Do List</title>
</head>
<body>
	<h3>To Do List</h3>
	<hr>	
	<table border="1">
		<thead>
			<tr>
				<th>Content</th>
				<th>Start Date</th>
				<th>Finish Date</th>
			</tr>
		</thead>
		<tbody>
			<tr th:each="tempTask : ${list}">
				<td th:text="${tempTask.content}" />	
				<td th:text="${tempTask.startDate}" />	
				<td th:text="${tempTask.finishDate}" />	
			</tr>
		</tbody>		
	</table>
</body>
</html>
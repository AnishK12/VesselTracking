<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"
	xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
	layout:decorate="~{fragments/main_layout}">
<head>
<title>Index Page</title>
</head>
<body>

	<div layout:fragment="content" class="container mySpace">
		<div class="card">
			<div class="card card-body">
				<table>
				    <thead>
				        <tr>
				            <th> Ship Name </th>
				            <th> Origin Port </th>
				        </tr>
				    </thead>
				    <tbody>
				        <tr th:if="${shipss.empty}">
            				<td colspan="2"> No Books Available </td>
        				</tr>
				        <tr th:each="ship : ${shipss}">
				            <td><span th:text="${ship.propertiesname}"> Ship Name </span></td>
				            <td><span th:text="${ship.propertiesstartportPortName}"> Origin Port </span></td>
				        </tr>
				    </tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border= "1">
		<tr>
			
			<th>
			
				<form action="CarController">
				
					<input type = "submit" name = "btn_new" value = "New"/>
				</form>
			 </th>
			 <th>Id</th>
			 <th>Brand</th>
			 <th>Model</th>
			 <th>Capacity</th>
			 
			  
			
		</tr>
		
		<c:forEach var="car" items="${cars}">
		
		<tr>
			<td>
				<form action= "CarController">
					<input type = "hidden" name = "id" value= "${car.id}">
					<input type = "submit" name= "btn_edit" value= "Edit" />
					<input type = "submit" name= "btn_delete" value= "Delete">
				</form>
			</td>
			<td> ${car.id}</td>
			<td> ${car.brand}</td>
			<td> ${car.model}</td>
			<td> ${car.capacity}</td>
			
		</tr>
		
		</c:forEach>
		
	
	</table>

<form action="CarReport">
				
					<input type = "submit" name = "btn_reporte" value = "Generar Reporte"/>
				</form>
</body>
</html>
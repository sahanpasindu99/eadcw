<%@page import="eadproject.entity.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="../resources/index.js"></script>
<title>Manage Employees</title>
<link href="style.css" rel="stylesheet" type="text/css">

</head>
<body>



	<div class="emp-container">
		<table class="">
		  <thead class="">
		    <tr>
		      <th scope="col" class="emp-block">NIC</th>
		      <th scope="col" class="emp-block">Name</th>
		      <th scope="col" class="emp-block">Department</th>
		      <th scope="col" class="emp-block">Designation</th>
		      <th scope="col" class="emp-block">Joined</th>
		      <th scope="col" class="emp-block">Take Action</th>
		    </tr>
		  </thead>
		  <tbody>
		  
<% 
	ArrayList<Employee> list = (ArrayList<Employee>) request.getAttribute("userList");
	for(int i=0; i <list.size() ; i++){	
		
		int id = list.get(i).getId();
		String nic = list.get(i).getNic();
		String name = list.get(i).getName();
		String department = list.get(i).getDepartment();
		String designation = list.get(i).getDesignation();
		String joinedDate = list.get(i).getJoinedDate();

%>


		    <tr>
		      <th class=""><%= nic %></th>
		      <td class=""><%= name %></td>
		      <td class=""><%= department %></td>
		      <td class=""><%= designation %></td>
		      <td class=""><%= joinedDate %></td>
		      <td class="">
		 
		      <form action="employee/update-page" method="GET">
		      <input type="hidden" name="id" value="<%= id %>">
		      	<button class="emp-btn">Edit</button>
		      
		      </form>
		      	<button onClick="handleDelete('<%= id %>')" class="emp-btn" >Delete</button>

		      </td>
		    </tr>
<%	
	}
%>

		  </tbody>
	</table>
	</div>
	
	<a href="/Eadproject">
		HOME
	</a>
	
	<script >
	async function handleDelete(id){
		const result = await fetch("http://localhost:8080/Eadproject/employee/delete/?id="+id , {method: 'delete'} )
		window.location.reload();
	}
	

	</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="resources/index.js"></script>
<title>Manage Employees</title>
<link href="style.css" rel="stylesheet" type="text/css">

</head>
<body>
	<h1 class="">Employee Management</h1>
	<div class="index-container">
		<form action="reg-employee" method="POST" class="">
			<div class="index-inputs">
				<div class="index-input">
					<label class="" for="nic">NIC</label>
					<input class="index-txt" id="nic" name="nic"  type="text"/>
				</div>
				<div class="index-input ">
					<label class="" for="name">Name</label>
					<input class="index-txt" id="name" name="name"  type="text"/>
				</div>
				<div class="index-input">
					<label class="">Department</label>
					<input class="" id="department" name="department"  type="text"/>
				</div>
				<div class="index-input">
					<label class="">Designation</label>
					<input class="" id="designation" name="designation"  type="text"/>
				</div>
			</div>
			<div class="index-btn-add">
				<button class="index-btn">Add New Employee</button>
			</div>
		</form>
		
		
	</div>
	
	<form action="fetch" method="GET">
				<div class="index-btn-view">
	
		<button class="index-btn" type="Submit"> View All</button>
		</div>
	</form>

</body>
</html>
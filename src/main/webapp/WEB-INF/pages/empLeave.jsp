<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="postLeave" method="post">
	<label>employeeId:</label><input type="number" name="empId">
	<label>leaveDate</label><input type="date" name="leaveDate">
	<label>leaveTime</label><input type="time" name="leaveTime">
	<input type="text" name="leaveReason">
	<button type="submit">提交</button>
</form>
<%@ page import="java.util.*,tw.marc.model.Leave,tw.marc.model.*" %>
<% List<Leave> ls  = (List<Leave>)request.getAttribute("leaves"); 
	for( Leave l : ls){%>
		<%=l.getEmployee().getEmployee_name() %><%=l.getLeave_datetime() %>
	<%}
%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ page import="java.util.*,tw.marc.model.Leave,tw.marc.model.Employee" %>
<% List<Leave> ls  = (List<Leave>)request.getAttribute("leaves"); 
	for( Leave l : ls){%>
		<%=l.getEmployee().getEmployee_name() %><%=l.getLeave_datetime() %>
	<%}
%>
</body>
</html>
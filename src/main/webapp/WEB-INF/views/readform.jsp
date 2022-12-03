<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@page import="com.example.dao.BoardDAO, com.example.vo.BoardVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Form</title>
</head>
<body>
<h1>Read Form</h1>
<form:form modelAttribute="boardVO" method="POST">
<form:hidden path="seq"/>
<table id="edit">
	<tr><td>Category:</td><td><form:input  path="category" readonly="true"/></td></tr>
<tr><td>Title:</td><td><form:input path="title" readonly="true"/></td></tr>
<tr><td>Writer:</td><td><form:input  path="writer" readonly="true"/></td></tr>
<tr><td>Content:</td><td><form:textarea cols="50" rows="5" path="content" readonly="true"/></td></tr>
<tr><td colspan="2"><input type="button" onclick="location.href='../editform/${boardVO.getSeq()}'" value="Edit"/>
<input type="button" value="Cancel" onclick="history.back()"/></td></tr>
</table>
</form:form>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <base href="<%=request.getContextPath() %>/"> --%>
<base href="<%=request.getScheme() %>://<%=request.getServerName() %>:<%=request.getServerPort()%><%=request.getContextPath() %>/">
<script type="text/javascript" src="static/script/jquery-1.7.2.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
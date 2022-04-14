<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="cc.shinbi.shindan.model.Result" %>

<%
	String name = (String)request.getAttribute("name");
	Result result = (Result)request.getAttribute("result");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>診断結果</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<h1>ポケモン御三家診断 診断結果</h1>
<p><%= name %> さんの診断結果は</p>
<p><span id="result"><%= result.getName() %></span>です。</p>
<p><%= result.getDescription() %></p>
[<a href="${pageContext.request.contextPath}/top">戻る</a>]
</body>
</html>
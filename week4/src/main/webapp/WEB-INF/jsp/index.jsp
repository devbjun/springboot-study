<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>4주차 과제</title>
</head>
<body>
  <c:forEach var="item" items="${list}" varStatus="idx"> 
    ${item.number} ${item.name}
  </c:forEach>
</body>
</html>
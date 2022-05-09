<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1">
  <tr>
                    <th>등록 번호</th>
                    <th>게임 코드</th>
                     <th>게임 이름</th>
                    <th>게임 개발사</th>
                     <th>게임 출시일</th>
                    <th>게임 가격</th>
                    <th>게임 평균</th>
                    <th>게임 소개</th>
                    <th>관리자 번호</th>
                 </tr>
             <c:forEach var="g" items="${game }" >         
        
                    <tr>
                       <td>${g.gNum }</td>
                       <td>${g.gCode }</td>
                       <td>
                       <a href="<c:url value='/art/${g.gNum }'/>">${g.gName }</a></td>
                       <td>${g.gDev }</td>
                       <td>${g.gDate }</td>
                       <td>${g.gPrice }</td>
                       <td>${g.gAvg }</td>
                       <td>${g.gContent }</td>
                        <td>${g.adNum }</td>
                       </tr>
                 </c:forEach>
                      
              </table>


</body>
</html>
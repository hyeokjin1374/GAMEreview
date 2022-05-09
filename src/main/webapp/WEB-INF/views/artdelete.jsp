<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게임리뷰 삭제</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/back.css">

</head>
<body>


	<h2>게임리뷰 삭제</h2>
	
	       <h3>내가 작성한 리뷰 글</h3>	
	        <form method="post">	
			   <c:forEach var="d" items="${delete }">
			<table class="table table-bordered border border-primary table table-hover ">
		      
			    <tr>
			      <td style="text-align:center ;"width="200">리뷰 번호</td>
			    <td width="300">  ${d.aNum}</td>
			</tr>
			
			    <tr>
			      <td style="text-align:center ;">맴버 번호</td>
			    <td width="300">  ${d.mNum}</td>
			</tr>
			
			    <tr>
			      <td style="text-align:center ;">게임 번호</td>
			    <td width="300">  ${d.gNum}</td>
			</tr>
			
			    <tr>
			      <td style="text-align:center ;">리뷰 게시일</td>
			    <td width="300">  ${d.aRegdate}</td>
			</tr>
			
			
			
				    <tr>
			      <td style="text-align:center ;">리뷰 내용</td>
			    <td width="300" height="200">  ${d.aContent}</td>
			</tr>
			
					    <tr>
			      <td style="text-align:center ;">리뷰 점수</td>
			    <td width="300">  ${d.aScore}</td>
			</tr>
			</table>
 <h4>리뷰를 삭제하겠습니까?</h4>
<input type="submit" class="btn btn-warning" value="리뷰 삭제" />
			
   </c:forEach>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
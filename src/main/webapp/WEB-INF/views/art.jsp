<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/back.css"> <!-- bootstrap watch 참고 -->
<meta charset="UTF-8">
<title>게임리뷰 등록</title>
<style>
.star {
    position: relative;
    font-size: 2rem;
    color: #ddd;
  }
  
  .star input {
    width: 100%;
    height: 100%;
    position: absolute;
    left: 0;
    opacity: 0;
    cursor: pointer;
  }
  
  .star span {
    width: 0;
    position: absolute; 
    left: 0;
    color: yellow;
    overflow: hidden;
    pointer-events: none;
  }


</style>

</head>
 <body>

	<h2>게임리뷰 등록</h2>

	<form:form commandName="artData"  method="POST">
	
	<!-- CKEDITOR -->
	<script src="${pageContext.request.contextPath }/resources/ckeditor1/ckeditor.js"></script>
	<textarea id="ck1" name="aContent"></textarea>

		<script>
			
					CKEDITOR.replace('ck1',  {
						width:800,
						height:400,
						filebrowserUploadUrl : '${pageContext.request.contextPath}/imageUpload'	});
				</script>
	
			
			<h3>리뷰 점수</h3>
<!--  별   -->
			<div class=".container">
			
			<span class="star"> ★★★★★ <span>   ★★★★★ </span>
            <input type="range" name="aScore" oninput="drawStar(this)" value="1" step="1" min="0" max="10">
            </span>
			</div>
				
			<script>
			 const drawStar = (target) => {
		    	 console.log(target.value);
		    	    document.querySelector(`.star span`).style.width = target.value * 10+"%";
		    	  }
			 </script>
			
<br>
		 <input type="submit" class="btn btn-success" value="리뷰정보 등록" />
		
      <br>  <br>  <br>

			</form:form>
			
			   <c:forEach var="a" items="${art }">
			<table class="table table-bordered border border-primary table table-hover ">
			
		      
			    <tr>
			    <td style="text-align:center ;" width="100" class="fw-bold table-primary">1</td>
			      <td style="text-align:center ;" width="250" class="fw-bold table-primary" >리뷰 번호</td>
			    <td width="300" class="fw-bold table-primary" >  ${a.aNum}</td>
			</tr>
			
			    <tr>
			    <td style="text-align:center ;" class="fw-bold">2</td>
			      <td style="text-align:center ;">맴버 번호</td>
			    <td width="300">  ${a.mNum}</td>
			</tr>
			
			    <tr>
			    <td style="text-align:center ;" class="fw-bold">3</td>
			      <td style="text-align:center ;">게임 번호</td>
			    <td width="300">  ${a.gNum}</td>
			</tr>
			
			    <tr>
			    <td style="text-align:center ;" class="fw-bold">4</td>
			      <td style="text-align:center ;">리뷰 게시일</td>
			    <td width="300">  ${a.aRegdate}</td>
			</tr>
			
			
			
				    <tr>
				    <td style="text-align:center ;" class="fw-bold">5</td>
			      <td style="text-align:center ;" >리뷰 내용</td>
			    <td width="400" height="200">  ${a.aContent}</td>
			</tr>
			
					    <tr>
					    <td style="text-align:center ;" class="fw-bold">6</td>
			      <td style="text-align:center ;">리뷰 점수</td>
			    <td width="300">  ${a.aScore}</td>
			</tr>
			

			     
		    <tr>
		    <td style="text-align:center ;" class="fw-bold">7</td>
			      <td style="text-align:center ;">좋아요♥</td>
<td style="margin-right:1px;">


    <!-- ajax 사용 -->
	<button id="bt" name = "bt" type="button" class="btn btn-danger" onclick="updateLike(${a.aNum}, ${a.gNum }, ${a.mNum })">추천 ${a.aLike}</button>
			
</td>
			</table>
			
 <span>			
<button type="button" class="btn btn-primary" class="butt" onclick="location.href='/review/rep/${a.aNum}'">댓글달기(${a.repcount})</button> 
	</span>
	
		<span >			
<button type="button" class="btn btn-info" onclick="location.href='/review/artupdate/${a.gNum}/${a.aNum}'">리뷰 수정하기</button> 
	</span>
	
			<span >			
<button type="button" class="btn btn-warning" onclick="location.href='/review/artdelete/${a.gNum}/${a.aNum}'">리뷰 삭제하기</button> 
	</span>
         	<br>
			<br>
		</c:forEach>
		
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		
		   <script>
		     		     
		     function updateLike(aNum1, gNum1, mNum1){
		    	 var aNum = aNum1;
		    	 var gNum = gNum1;
			     var mNum = mNum1;
			    /*  alert(mNum); */
		    	$.ajax({
		    	  type : "POST",
		    	  url : "/review/updateLike",
		    	  dataType : "json",
		    	  data : {'gNum' : gNum, 'mNum' : mNum, 'aNum' : aNum},
		     	
		    	  success : function(likeCheck) {
		    		  console.log("likeCheck:" + likeCheck);
		    		  if(likeCheck == 0) {
		    			  alert("추천완료.");
		    			  location.reload();
		    		  }
		    		  else if(likeCheck == 1){
		    			  alert("추천취소");
		    			  location.reload();
		    		  }else  {
		    			  alert("통신에러");
		    		  }
		   
		    	  },
	    	  
 	  		    	}) ;
		       }	
		   </script>		

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
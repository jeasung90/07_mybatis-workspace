<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DDack 따까리 게시판 상세보기</title>
</head>
<body>
	<jsp:include page="../common/menubar.jsp"/>

    <div class="outer" align="center">
        <br>
        <h1 align="center">게시판 상세조회</h1>

        <table align="center" border="1">
            <tr>
                <th width="100">글번호</th>
                <td width="500">${b.boardNo}</td>
            </tr>
            <tr>
                <th>제목</th>
                <td>${b.boardTitle }</td>
            </tr>
            <tr>
                <th>작성자</th>
                <td>${b.boardWriter }</td>
            </tr>
            <tr>
                <th>조회수</th>
                <td>${b.count }</td>
            </tr>
            <tr>
                <th>작성일</th>
                <td>${b.createDate }</td>
            </tr>
            <tr>
                <th>내용</th>
                <td height="100">${b.boardContent }</td>
            </tr>
            
        </table>

        <div>
            <a href="list.bo?cpage=1" class="btn btn-sm btn-secondary">목록가기</a>
            <c:if test="${not empty loginMember and loginMember.userId eq b.boardWriter }">
                <a class="btn btn-sm btn-warning">수정하기</a>
                <a href="deleteBoard.bo?bno=${b.boardNo }" class="btn btn-sm btn-danger">삭제하기</a>
            </c:if>
        </div>

        <br>

        <table align="center" border="1">
            <tr>
                <th width="10">댇글작성</th>
                <th width="400"><textarea cols="50" rows="3" style="resize: none;"></textarea></th>
                <th width="100"><button>등록</button></th>
            </tr>
            <tr>
                <td colspan="3"><b>댇글(${list.size()})</b></td><!-- fn:length(list) 도 가능 -->
            </tr>
	        <c:forEach var="list" items="${list }">
	            <tr>
	                <td>${list.replyWriter }</td>
	                <td>${list.replyContent }</td>
	                <td>${list.createDate }</td>
	            </tr>
            </c:forEach>
        </table>
        <br><br>
    </div>







</body>
</html>
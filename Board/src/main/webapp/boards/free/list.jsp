<%@ page import="com.ebrain.board.vo.Board" %><%--
  User: Heum
  Date: 2023-02-07
  Time: 오후 10:29
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <%-- 공통헤더 --%>
    <%@include file="/common/header.jsp" %>

    <%-- CSS --%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/list.css">

    <%-- JS --%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/list.js"></script>
    <title>List</title>
</head>

<body>
<%
    Board b = new Board();
    b.testMsg();
    b.testMsg();
    System.out.println("이거되니..?");
%>
<div class="container mt-5">
    <h4 class="mb-4 mt-3">자유 게시판 - 목록</h4>
    <%-- 상단 검색 --%>
    <form class="row search-wrap justify-content-between" action="/boards/free/search" method="GET">
        <div class="col-auto">
            <label for="startDate" class="col-form-label me-2">등록일</label>
            <input type="date" class="form-control form-control-sm" id="startDate">
            <label for="endDate" class="col-form-label">~</label>
            <input type="date" class="form-control form-control-sm" id="endDate">
            <select class="form-select form-select-sm ms-5 me-2" name="searchCategory">
                <option value="0">전체 카테고리</option>
                <option value="1">JAVA</option>
                <option value="2">Javascript</option>
            </select>
            <input type="text" class="form-control form-control-sm me-2" name="searchContent"
                   placeholder="검색어를 입력해주세요. (제목+작성자+내용)">
            <input type="submit" class="btn btn-primary" value="검색">
        </div>
    </form>
    <%-- 게시물 총 건수 --%>
    <p class="mt-2">총 ${boardCount}건</p>
    <table class="table table-hover table-striped">
        <thead>
        <tr class="border-top table-head">
            <th>카테고리</th>
            <th></th>
            <th>제목</th>
            <th>작성자</th>
            <th>조회수</th>
            <th>등록 일시</th>
            <th>수정 일시</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>JAVA</td>
            <td><i class="bi bi-paperclip"></i></td>
            <td class="board-title">
                <a href="${pageContext.request.contextPath}/boards/free/view.jsp?boardNo=1">
                    OKKY 3월 세미나 서비스 개발자로 커리어 전환하기 by 와이즐...
                </a>

            </td>
            <td>윤상진</td>
            <td>12</td>
            <td>2022.04.04 16:32</td>
            <td>2022.04.08 16:32</td>
        </tr>
        <tr>
            <td>JAVA</td>
            <td></td>
            <td class="board-title">OKKY 3월 세미나 서비스 개발자로 커리어 전환하기 by 와이즐...</td>
            <td>윤상진</td>
            <td>12</td>
            <td>2022.04.04 16:32</td>
            <td>2022.04.08 16:32</td>
        </tr>
        </tbody>
    </table>

    <%-- 하단 페이징 --%>
    <ul class="pagination pagination-sm justify-content-center ">
        <li class="page-item">
            <a class="page-link" href="#" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
            </a>
        </li>
        <li class="page-item"><a class="page-link" href="#">1</a></li>
        <li class="page-item"><a class="page-link" href="#">2</a></li>
        <li class="page-item"><a class="page-link" href="#">3</a></li>
        <li class="page-item">
            <a class="page-link" href="#" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
            </a>
        </li>
    </ul>

    <%--  글쓰기--%>
    <div class="text-end mb-3">
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/boards/free/writeForm.jsp">등록</a>
    </div>

</div>
</body>
</html>

<%--
  User: Heum
  Date: 2023-02-11
  Time: 오후 10:23
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%-- 공통헤더 --%>
    <%@include file="/common/header.jsp" %>

    <%-- CSS --%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/write-form.css">
    <%-- JS --%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/write-form.js"></script>

    <title>WriteForm</title>
</head>
<body>
<div class="container mt-5">
    <h4 class="mb-3 mt-3">게시판 - 등록</h4>

    <%-- 내용 --%>
    <div class="row content-wrap mb-3">
        <%--  왼쪽 label --%>
        <div class="col-3 content-left">
            <div class="row row-40">
                <label for="selectCategory" class="col-form-label">카테고리</label>
            </div>
            <div class="row row-40">
                <label for="writer" class="col-form-label">작성자</label>
            </div>
            <div class="row row-40">
                <label for="password" class="col-form-label">비밀번호</label>
            </div>
            <div class="row row-40">
                <label for="title" class="col-form-label">제목</label>
            </div>
            <div class="row row-160 align-items-center">
                <label for="content" class="col-form-label">내용</label>
            </div>
            <div class="row file-padding-40">
                <label for="attachFile1" class="col-form-label">파일 첨부</label>
            </div>
        </div>
        <%-- 오른쪽 form --%>
        <div class="col-9 content-right">
            <form action="${pageContext.request.contextPath}/boards/free/write" method="POST" id="boardForm">
                <div class="row row-40 align-items-center">
                    <select class="form-select form-select-sm" name="selectCategory" id="selectCategory" required>
                        <option value="">카테고리 선택</option>
                        <option value="1">JAVA</option>
                        <option value="2">Javascript</option>
                    </select>
                </div>
                <div class="row row-40 align-items-center">
                    <input type="text" class="form-control form-control-sm" id="writer" name="writer" required>
                </div>
                <div class="row row-40 password-wrap align-items-center">
                    <input type="password" class="form-control form-control-sm me-2" id="password" name="password"
                           placeholder="비밀번호" required>
                    <input type="password" class="form-control form-control-sm" id="passwordCheck" name="passwordCheck"
                           placeholder="비밀번호 확인" required>
                </div>
                <div class="row row-40 align-items-center">
                    <input type="text" class="form-control form-control-sm" id="title" name="title" required>
                </div>
                <div class="row row-160 align-items-center">
                    <textarea class="form-control" id="content" name="content" required></textarea>
                </div>
                <div class="row">
                    <input type="file" class="form-control form-control-sm mt-2 mb-1" id="attachFile1"
                           name="attachFile1">
                    <input type="file" class="form-control form-control-sm mb-1" id="attachFile2" name="attachFile2">
                    <input type="file" class="form-control form-control-sm" id="attachFile3" name="attachFile3">
                </div>
            </form>
        </div>

        <div class="mt-3 btn-submit">
            <a class="btn btn-secondary" href="${pageContext.request.contextPath}/boards/free/list">취소</a>
            <button type="submit" class="btn btn-primary" form="boardForm">저장</button>
        </div>
    </div>


</div>
</body>
</html>

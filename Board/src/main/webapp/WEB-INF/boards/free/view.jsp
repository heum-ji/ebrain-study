<%--
  User: Heum
  Date: 2023-02-11
  Time: 오후 1:59
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%-- 공통헤더 --%>
    <%@include file="/common/header.jsp" %>
    <%-- CSS --%>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/view.css">
    <%-- JS --%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/view.js"></script>
    <title>View</title>
</head>
<body>
<div class="container mt-5">
    <h4 class="mb-4 mt-3">게시판 - 보기</h4>
    <input type="hidden" value="${param.boardNo}" name="boardNo">

    <%-- 등록정보 --%>
    <div class="row">
        <div class="col-6">
            <input type="text" class="form-control-plaintext" value="백지흠" readonly>
        </div>
        <div class="col-3 text-end">
            <label for="registerDate" class="col-form-label">등록일시</label>
            <input type="text" class="form-control-plaintext" id="registerDate" value="2023.02.11 12:32" readonly>
        </div>
        <div class="col-3 text-end">
            <label for="modifyDate" class="col-form-label">수정일시</label>
            <input type="text" class="form-control-plaintext text-end" id="modifyDate" value="2023.02.11 12:32"
                   readonly>
        </div>
    </div>

    <%-- 게시글 제목 --%>
    <div class="row board-info">
        <div class="col-1">
            <input type="text" class="form-control-plaintext" id="category" value="[JAVA]" readonly>
        </div>
        <div class="col-10">
            <input type="text" class="form-control-plaintext" id="title" value="제목이 출력됩니다." readonly>
        </div>
        <div class="col-1">
            <input type="text" class="form-control-plaintext text-end" id="viewCount" value="조회수: 13" readonly>
        </div>
    </div>

    <%-- 게시글 내용 --%>
    <div class="row mt-3">
        <textarea class="form-control" readonly></textarea>
    </div>

    <%-- 첨부파일 --%>
    <div class="row mt-3">
        <div class="col-auto">
            <i class="bi bi-download"></i>
            <a href="${pageContext.request.contextPath}/fileDownBoard?fileNo=${file.fileNo}">첨부파일1.hwp</a>
        </div>
    </div>

    <%--  댓글 --%>
    <div class="row mt-3 comment-wrap">
        <div class="comment">
            <input type="text" class="form-control-plaintext" value="2023.02.11 12:32" readonly>
            <textarea class="form-control-plaintext" name="comment" readonly>댓글이 출력됩니다.</textarea>
        </div>

        <div class="comment">
            <input type="text" class="form-control-plaintext" value="2023.02.09 14:32" readonly>
            <textarea class="form-control-plaintext" name="comment" readonly>댓글이 출력됩니다. 댓글이 출력됩니다. 댓글이 출력됩니다. 댓글이 출력됩니다.
            댓글이 출력됩니다. 댓글이 출력됩니다.</textarea>
        </div>

        <div class="mt-3">
            <form class="row"
                  action="${pageContext.request.contextPath}/WEB-INF/boards/free/comment.jsp?boardNo=${param.boardNo}"
                  method="POST">
                <textarea class="form-control me-3 col-10" name="comment-frm" placeholder="댓글을 입력해 주세요."></textarea>
                <input type="submit" class="ms-3 col-2 btn btn-primary" id="commentWrite" value="등록">
            </form>
        </div>
    </div>

    <%-- 하단 버튼 --%>
    <div class="mt-3 mb-3 text-center">
        <a class="btn btn-secondary" href="${pageContext.request.contextPath}/boards/free/list?reqPage=${reqPage}">목록</a>
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/boards/free/modifyForm?boardNo=${boardNo}">수정</a>
        <a class="btn btn-danger" href="${pageContext.request.contextPath}/boards/free/delete?boardNo=${boardNo}">삭제</a>
    </div>
</div>
</body>
</html>

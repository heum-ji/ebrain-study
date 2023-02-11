<%--
  User: Heum
  Date: 2023-02-11
  Time: 오후 11:39
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Msg</title>
</head>
<body>
<%-- Alert 메시지 + Page 이동 --%>
<script>
    alert(${param.msg});
    location.href = "${param.loc}";
</script>
</body>
</html>

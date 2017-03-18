<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>E_STORE</title>

    <link href="/content/css/bootstrap.min.css" rel="stylesheet">
    <link href="/content/font-awesome/css/font-awesome.css" rel="stylesheet">

    <link href="/content/css/animate.css" rel="stylesheet">
    <link href="/content/css/style.css" rel="stylesheet">

</head>

<body class="gray-bg">

    <jsp:include page="/WEB-INF/pages/${view}.jsp"></jsp:include>    

    <!-- Mainly scripts -->
    <script src="/content/js/jquery-2.1.1.js"></script>
    <script src="/content/js/bootstrap.min.js"></script>

</body>

</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
 
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>E-STORE</title>
    <link href="/content/icons/logo.ico" rel="icon"/>
    <link href="/content/css/bootstrap.min.css" rel="stylesheet">
    <link href="/content/font-awesome/css/font-awesome.css" rel="stylesheet">

    <!-- Morris -->
    <link href="/content/css/plugins/morris/morris-0.4.3.min.css" rel="stylesheet">

    <!-- Gritter -->
    <link href="/content/js/plugins/gritter/jquery.gritter.css" rel="stylesheet">

    <link href="/content/css/animate.css" rel="stylesheet">
    <link href="/content/css/style.css" rel="stylesheet">
</head>
<body>
<div id="wrapper">
        <nav class="navbar-default navbar-static-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="side-menu">
                    
                    <li class="nav-header">
                        <div class="dropdown profile-element"> 
                            <span>
                                <img alt="image" class="img-circle" src="/content/img/logo.png" />
                            </span>                            
                        </div>                        
                    </li>
                    <li>
                        <a href="/store/home"><i class="fa fa-th-large"></i> <span class="nav-label">Bosh sahifa</span> </a>
                    </li>
                    <li>
                        <a href="/store/product"><i class="fa fa-flask"></i> <span class="nav-label">Mahsulotlarni kiritish</span> </a>
                    </li>
                    
                </ul>

            </div>
        </nav>

        <div id="page-wrapper" class="gray-bg dashbard-1">
        <div class="row border-bottom">
        <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">

            <ul class="nav navbar-top-links navbar-right">
                <li>
                    <span class="m-r-sm text-muted welcome-message">${owner}</span>
                </li>
                
                <li>
                    <a href="/auth/out">
                        <i class="fa fa-sign-out"></i> Chiqish
                    </a>
                </li>
            </ul>

        </nav>
        </div>
        <div class="row  border-bottom white-bg dashboard-header">

                <jsp:include page="/WEB-INF/pages/${view}.jsp"></jsp:include>
        
        </div>
        

        </div>
    </div>

    <!-- Mainly scripts -->
    <script src="/content/js/jquery-2.1.1.js"></script>
    <script src="/content/js/bootstrap.min.js"></script>
    <script src="/content/js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script src="/content/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

    <!-- Flot -->
    <script src="/content/js/plugins/flot/jquery.flot.js"></script>
    <script src="/content/js/plugins/flot/jquery.flot.tooltip.min.js"></script>
    <script src="/content/js/plugins/flot/jquery.flot.spline.js"></script>
    <script src="/content/js/plugins/flot/jquery.flot.resize.js"></script>
    <script src="/content/js/plugins/flot/jquery.flot.pie.js"></script>

    <!-- Peity -->
    <script src="/content/js/plugins/peity/jquery.peity.min.js"></script>
    <script src="/content/js/demo/peity-demo.js"></script>

    <!-- Custom and plugin javascript -->
    <script src="/content/js/inspinia.js"></script>
    <script src="/content/js/plugins/pace/pace.min.js"></script>

    <!-- jQuery UI -->
    <script src="/content/js/plugins/jquery-ui/jquery-ui.min.js"></script>

    <!-- GITTER -->
    <script src="/content/js/plugins/gritter/jquery.gritter.min.js"></script>

    <!-- EayPIE -->
    <script src="/content/js/plugins/easypiechart/jquery.easypiechart.js"></script>

    <!-- Sparkline -->
    <script src="/content/js/plugins/sparkline/jquery.sparkline.min.js"></script>

    <!-- Sparkline demo data  -->
    <script src="/content/js/demo/sparkline-demo.js"></script>

    <!-- ChartJS-->
    <script src="/content/js/plugins/chartJs/Chart.min.js"></script>



</body>
</html>

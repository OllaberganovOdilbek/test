<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<c:if test="${msg!=''}">
    <div class="alert alert-danger text-center">
        ${msg}
    </div>    
</c:if>

<div class="middle-box text-center loginscreen  animated fadeInDown">
    <form class="m-t" role="form" action="/auth/in" method="POST">
        <div class="form-group">
            <input type="input" name="login" class="form-control" placeholder="Foydalanuvchi" required="">
        </div>
        <div class="form-group">
            <input type="password" name="password" class="form-control" placeholder="Parol" required="">
        </div>
        <button type="submit" class="btn btn-primary block full-width m-b">Kirish</button>

        <a href="#"><small>Parolni esdan chiqardingizmi?</small></a>                
        <br>
        <br>
        <a class="btn btn-sm btn-white btn-block" href="/auth/signup">Registratsiya</a>
    </form> 
</div>

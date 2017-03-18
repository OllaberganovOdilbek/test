<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<script>
    
     function check(){         
         var ret=true;
         
         var fio = $("#fio").val();
         if(fio==''){
             ret=false;
             $("#fio_d").attr("class", "form-group has-error");
             $("#fio_p").css("display", "block");
        } else {
            $("#fio_d").attr("class", "form-group");
            $("#fio_p").css("display", "none");
        }
         
         var login = $("#login").val();
         if(login==''){
             ret=false;
             $("#login_d").attr("class", "form-group has-error");
            $("#login_p").css("display", "block");
        } else {
            $("#login_d").attr("class", "form-group");
            $("#login_p").css("display", "none");
        }

        var password = $("#password").val();
        if (password == '') {
            ret = false;
            $("#password_d").attr("class", "form-group has-error");
            $("#password_p").css("display", "block");
        } else {
            $("#password_d").attr("class", "form-group");
            $("#password_p").css("display", "none");
        }

        var confirm_password = $("#confirm_password").val();
        if (confirm_password == '') {
            ret = false;
            $("#confirm_password_d").attr("class", "form-group has-error");
            $("#confirm_password_p").css("display", "block");
            $("#confirm_password_pch").css("display", "none");
        } else {
            if (confirm_password == password) {
                $("#confirm_password_d").attr("class", "form-group");
                $("#confirm_password_p").css("display", "none");
                $("#confirm_password_pch").css("display", "none");
            } else {
                $("#confirm_password_d").attr("class", "form-group has-error");
                $("#confirm_password_p").css("display", "none");
                $("#confirm_password_pch").css("display", "block");
                ret = false;
            }

        }
        if (ret) {
            return true;
        } else {
            return false;
        }
    }

</script>

<c:if test="${msg!=''}">
    <c:if test="${success==1}">
        <div class="alert alert-success text-center">
            ${msg}
        </div>
    </c:if>
    <c:if test="${success==0}">
        <div class="alert alert-danger text-center">
            ${msg}
        </div>
    </c:if>
</c:if>


<div class="middle-box text-center loginscreen  animated fadeInDown">
    
    <form class="m-t" role="form" action="/auth/signup" method="POST" onsubmit="return check();">
        <div id="fio_d" class="form-group">
            <input type="input" id="fio" class="form-control" placeholder="FIO" name="fio">       
            <p id="fio_p" class="help-block help-block-error" style="display: none;">«FIO»ni kiriting.</p>
        </div>
        <div id="login_d" class="form-group">
            <input type="input" id="login" class="form-control" placeholder="Foydalanuvchi nomi" name="login">
            <p id="login_p" class="help-block help-block-error" style="display: none;">«Foydalanuvchi nomi»ni kiriting.</p>
        </div>
        <div id="password_d" class="form-group">
            <input type="password" id="password" class="form-control" placeholder="Parol" name="password">
            <p id="password_p" class="help-block help-block-error" style="display: none;">«Parol»ni kiriting.</p>
        </div>
        <div id="confirm_password_d" class="form-group">
            <input type="password" id="confirm_password" class="form-control" placeholder="Takroran parol">
            <p id="confirm_password_p" class="help-block help-block-error" style="display: none;">«Takroran parol»ni kiriting.</p>
            <p id="confirm_password_pch" class="help-block help-block-error" style="display: none;">«Takroran parol» «Parol» bilan bir xil emas.</p>
        </div>    
        <button type="submit" class="btn btn-primary block full-width m-b">Registratsiya</button>
    </form> 
    
    <a class="btn btn-sm btn-white btn-block" href="/auth/in">Kirish</a>
    
</div>




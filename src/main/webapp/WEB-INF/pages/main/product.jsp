<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:if test="${data!=''}">
    <div class="alert alert-success text-center">
        ${data}
    </div>
</c:if>

<form method="post" class="form-horizontal" action="/store/product">
    <div class="form-group">
        <label class="col-sm-2 control-label">Mahsulot nomi</label>
        <div class="col-sm-10"><input class="form-control" type="text" name="name"></div>
    </div>
    
    <div class="form-group">
        <label class="col-sm-2 control-label">Mahsulot miqdori</label>
        <div class="col-sm-10"><input class="form-control" type="text" name="count"></div>
    </div>
    
    <div class="hr-line-dashed"></div>
    
    
    <div class="col-sm-4 col-sm-offset-2">
<!--        <button class="btn btn-white" type="submit">Cancel</button>-->
        <button class="btn btn-primary" type="submit">Saqlash</button>
    </div>
</form>
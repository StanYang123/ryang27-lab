<%-- 
    Document   : customer
    Created on : Sep 10, 2023, 11:23:27 AM
    Author     : sas
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create a Customer</title>
    </head>
    <body>
        <h1>Create A Zoo</h1>


        
        <form method="post" action="/add">
            <div>
                <label for="name"> name</label>
                <input type="text" id="name" name="name" value="${name}"  />
            </div>
            <div>
                <label for="type"> date</label>
                <input type="date" id="date" name="date" value="${date}"  />
            </div>
            <div>
                <label for="type"> type</label>
                <input type="text" id="type" name="type" value="${type}"  />
            </div>
            <div>
                <label for="remark">remark</label>
                <input type="text" id="remark" name="remark" value="${remark}" />
            </div>

            <button type="submit">Create Zoo</button>
            
        </form>
        <input style="width: 600px" type="text" id="error" name="error" value="${error}" />
    </body>
</html>

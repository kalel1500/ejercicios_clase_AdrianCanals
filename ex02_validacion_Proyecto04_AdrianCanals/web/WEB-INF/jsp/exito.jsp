<%-- 
    Document   : exito
    Created on : 08-abr-2019, 16:18:21
    Author     : Usuario
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%--<c:if test="${sessionScope.us == null}">
    <% response.sendRedirect("index"); %>
</c:if>--%>
    
<% String title = (String) request.getAttribute("title"); %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>${title}</title>
        <link rel="icon" type="image/png" href="img/otros/logo.jpeg"/>
        
        <!--Librerias bootstrap-->
        <script src="https://code.jquery.com/jquery-3.2.1.min.js" ></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        
        <!--Librerias letas-->
        <link href="https://fonts.googleapis.com/css?family=Roboto:400,700" rel="stylesheet">
        
        <!--css y js propios-->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/estilos.css" type="text/css" media="all" />
        <script src="${pageContext.request.contextPath}/js/js.js"></script>
    </head>

    <body>
        
        <jsp:include page="/WEB-INF/jsp/proc/nav.jsp" />
        
        <section>
            <div class="container">
                <div class="centrado-automatico">
                    <a href="listarAdministrador">Lista de administradores</a><br>
                    <a href="insertarAdministrador">Crear administrador</a><br>
                    <a href="logout">Cerrar sesion</a><br>
                </div>
            </div>
    
            <footer>

            </footer>
        </section>
    </body>
</html>
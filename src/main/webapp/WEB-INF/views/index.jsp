<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Listado de Correos Electrónicos</title>
    <!-- Enlaza el CSS para dar estilos -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/styles.css">
    <!-- Enlaza el archivo JS si se requieren validaciones adicionales -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/validation.js"></script>
  </head>
  <body>
    <div class="container">
      <h1>Listado de Correos Electrónicos</h1>
      
      <!-- Botones de acciones generales -->
      <div class="actions">
        <a href="${pageContext.request.contextPath}/nuevo" class="btn">Nuevo Registro</a>
        <a href="${pageContext.request.contextPath}/reporte" class="btn">Descargar Reporte</a>
      </div>
      
      <!-- Tabla para listar los correos -->
      <table class="table">
        <thead>
          <tr>
            <th>Nombre</th>
            <th>Correo</th>
            <th>Tipo de Correo</th>
            <th>Acciones</th>
          </tr>
        </thead>
        <tbody>
          <!-- Se espera que el controlador agregue una lista de correos con nombre "listaCorreos" -->
          <c:forEach var="correo" items="${listaCorreos}">
            <tr>
              <td>${correo.sNombre}</td>
              <td>${correo.sCorreo}</td>
              <td>${correo.sTipoCorreo}</td>
              <td>
                <a href="${pageContext.request.contextPath}/editar?id=${correo.nId}" class="btn">Modificar</a>
                <!-- La acción eliminar solicita confirmación mediante JavaScript -->
                <a href="${pageContext.request.contextPath}/eliminar?id=${correo.nId}" class="btn" 
                   onclick="return confirm('¿Está seguro de eliminar este registro?');">Borrar</a>
              </td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
  </body>
</html>

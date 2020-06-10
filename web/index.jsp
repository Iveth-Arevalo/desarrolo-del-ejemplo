<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registro de Persona</h1>
        
        <form action="recibir.do" method="POST">
            Dui:<input type="text" name="txtDui" value="" /><br></br>
            Apellidos: <input type="text" name="txtapellidos" value="" /><br></br>
            Nombres: <input type="text" name="txtnombres" value="" /><br></br>
            <br><input type="submit" value="Registrar Nueva Persona"/>
        </form>
    </body>
</html>

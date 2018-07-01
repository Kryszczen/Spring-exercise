<%@ page contentType = "text/html; charset = UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
   <head>
      <title>Dodaj/Aktualizuj użytkownika</title>
   </head>

   <body>
        <form:form method="POST" action="/app/saveUser" modelAttribute="user">
        <input type="hidden" name="index" value="${index}"/>
            <table>
                   <tr>
                       <td><form:label path="name">Nazwa</form:label></td>
                       <td><form:input path="name"/></td>
                       <td><form:errors path="name"/></td>
                   </tr>
                   <tr>
                       <td><form:label path="age">Wiek</form:label></td>
                       <td><form:input path="age"/></td>
                       <td><form:errors path="age"/></td>
                   </tr>
                   <tr>
                       <td><input type="submit" value="Zapisz"/></td>
                   </tr>
            </table>
        </form:form>
   </body>
</html>
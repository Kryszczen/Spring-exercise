<%@ page contentType = "text/html; charset = UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
   <head>
      <title>Lista użytkowników</title>
   </head>

   <body>
      <table>
          <tr>
              <th>Imię</th>
              <th>Wiek</th>
          </tr>
          <c:forEach items="${users}" var="user" >
              <tr>
                  <td>${user.name}</td>
                  <td>${user.age}</td>
              </tr>
          </c:forEach>
      </table>
   </body>
</html>
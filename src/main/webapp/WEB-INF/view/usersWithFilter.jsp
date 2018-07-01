<%@ page contentType = "text/html; charset = UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
   <head>
      <title>Lista użytkowników z możliwością filtrowania</title>
   </head>

   <body>
   <form method="get" action="searchUsers">
      <div>
        <input type="text" id ="txt" name="name" >
        <button id="button-id" type="submit">Wyszukaj użytkowników</button>
      </div>
      <table>
          <tr>
              <th>Imię</th>
              <th>Wiek</th>
          </tr>
          <c:forEach items="${users}" var="user" varStatus="loop" >
              <tr>
                  <td>${user.name}</td>
                  <td>${user.age}</td>
                  <td>
                    <a href="user/${loop.index}/update"> Aktualizuj użytkownika</a>
                  </td>
              </tr>
          </c:forEach>
      </table>
      </form>
   </body>
</html>
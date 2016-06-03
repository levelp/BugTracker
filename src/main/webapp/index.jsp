<%--
  Created by IntelliJ IDEA.
  User: p.bevad.spb
  Date: 03.06.2016
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>

  </head>
  <body>
  <H1>  Hello, Word lalala</H1>

  ${1+1}

  <% for (int i=1; i<=10; i++) {
  %>
  <%=i%> <sup> 2</sup> = <%=i*i%> |
  <% }
  %>
  </body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 24. 9. 24.
  Time: 오후 5:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AIS Message Display</title>
</head>
<body>
<h1>Received AIS Message</h1>
<pre>
        <%= request.getAttribute("aisMessage") %>
</pre>
</body>
</html>

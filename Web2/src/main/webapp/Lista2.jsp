<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<ol>

  <% 
for (char  i='a'; i<='z'; i++) {
%>

 <li>
 <% out.println(i); %>
</li>
<%
}
%>
</ol>
</body>
</html>
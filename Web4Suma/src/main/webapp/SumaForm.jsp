<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 

double num1 = Double.parseDouble(request.getParameter("numero1"));

double num2 = Double.parseDouble(request.getParameter("numero2"));


String operacion = request.getParameter("operacion");
double resultado=0;
if (operacion.equals("+")){
	resultado=num1+num2;
}else if (operacion.equals("-")){
	resultado=num1-num2;
}else if (operacion.equals("*")){
	resultado=num1*num2;
} else {
	resultado=num1/num2;
	
}
	out.print(num1+""+operacion+""+num2+"="+resultado);
%>




</body>
</html>
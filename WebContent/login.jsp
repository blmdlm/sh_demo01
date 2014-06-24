<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<title>login</title>
</head>
<body color="#CCCCFF">
<s:form action="login" method="post">
	<table border="1" align="center" bgcolor="#AABBCCDD">
		<tr>
			<td><s:textfield name="userName" label="用户名" size="16"> </s:textfield></td>
		</tr>
		<tr>
			<td><s:password name="password" label="用户密码" size="16"> </s:password></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<s:submit value="login"></s:submit>
			</td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<s:a href="register.jsp">register</s:a>
			</td>
		</tr>
	
	</table>

</s:form>
</body>
</html>
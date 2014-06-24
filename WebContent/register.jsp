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
<title>register</title>
</head>
<body color="#CCCCFF">
<s:form action="register" method="post">
	<table border="1" align="center" bgcolor="#AABBCCDD">
		<tr>
			<td><s:textfield name="userName" label="用户名" size="16"> </s:textfield></td>
		</tr>
		<tr>
			<td><s:password name="password1" label="用户密码" size="16"> </s:password></td>
		</tr>
		<tr>
			<td><s:password name="password2" label="再次输入密码" size="16"> </s:password></td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<s:submit value="register"></s:submit>
			</td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<s:reset value="reset"></s:reset>
			</td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<s:a href="login.jsp">login</s:a>
			</td>
		</tr>
	
	</table>

</s:form>
</body>
</html>
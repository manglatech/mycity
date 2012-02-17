<%--
 | (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 | Source code generated by Celerio, a Jaxio product
 | Want to use Celerio within your company? email us at info@jaxio.com
 | Follow us on twitter: @springfuse
 | Template pack-mvc-3:src/main/webapp/WEB-INF/views/domain/show.e.vm.jsp
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="spring" uri="http://www.springframework.org/tags"
%><%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"
%><%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><head>
	<title><fmt:message key="photo" />: <fmt:message key="crud.functionalities.show" /></title>
</head>
<body>

	<a href="${pageContext.request.contextPath}/domain/photo/search" class="ajaxy button button-search"><fmt:message key="photo" /></a>
	<span class="ui-state-highlight button button-show"><fmt:message key="crud.show.button" /></span>
	<a href="${pageContext.request.contextPath}/domain/photo/update/${photo.primaryKey}" class="ajaxy button button-edit"><fmt:message key="crud.edit.button" /></a>
	<a href="${pageContext.request.contextPath}/domain/photo/delete/${photo.primaryKey}" class="modal button button-delete"><fmt:message key="crud.delete.button" /></a>

	<table class="show">
		<tbody>
			<tr>
				<th><fmt:message key="photo_name" /></th>
				<td><spring:eval expression="photo.name"/></td>
			</tr>
			<tr>
				<th><fmt:message key="photo_desc" /></th>
				<td><spring:eval expression="photo.desc"/></td>
			</tr>
			<tr>
				<th><fmt:message key="photo_location" /></th>
				<td><spring:eval expression="photo.location"/></td>
			</tr>
		</tbody>
	</table>
</body>
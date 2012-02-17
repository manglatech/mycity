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
	<title><fmt:message key="restaurent" />: <fmt:message key="crud.functionalities.show" /></title>
</head>
<body>

	<a href="${pageContext.request.contextPath}/domain/restaurent/search" class="ajaxy button button-search"><fmt:message key="restaurent" /></a>
	<span class="ui-state-highlight button button-show"><fmt:message key="crud.show.button" /></span>
	<a href="${pageContext.request.contextPath}/domain/restaurent/update/${restaurent.primaryKey}" class="ajaxy button button-edit"><fmt:message key="crud.edit.button" /></a>
	<a href="${pageContext.request.contextPath}/domain/restaurent/delete/${restaurent.primaryKey}" class="modal button button-delete"><fmt:message key="crud.delete.button" /></a>

	<table class="show">
		<tbody>
			<tr>
				<th><fmt:message key="restaurent_code" /></th>
				<td><spring:eval expression="restaurent.code"/></td>
			</tr>
			<tr>
				<th><fmt:message key="restaurent_name" /></th>
				<td><spring:eval expression="restaurent.name"/></td>
			</tr>
			<tr>
				<th><fmt:message key="restaurent_desc" /></th>
				<td><spring:eval expression="restaurent.desc"/></td>
			</tr>
			<tr>
				<th><fmt:message key="restaurent_photoId" /></th>
				<td>
					<c:if test="${restaurent.photo != null}">
						<spring:eval expression="restaurent.photo" />
						<a href="${pageContext.request.contextPath}/domain/photo/show/${restaurent.photo.primaryKey}" class="button button-show miniature"><fmt:message key="crud.show.button" /></a>
					</c:if>
				</td>
			</tr>
			<tr>
				<th><fmt:message key="restaurent_isActive" /></th>
				<td><spring:eval expression="restaurent.isActive"/></td>
			</tr>
			<tr>
				<th><fmt:message key="restaurent_createdDate" /></th>
				<td><spring:eval expression="restaurent.createdDate"/></td>
			</tr>
			<tr>
				<th><fmt:message key="restaurent_createdBy" /></th>
				<td><spring:eval expression="restaurent.createdBy"/></td>
			</tr>
			<tr>
				<th><fmt:message key="restaurent_modifiedBy" /></th>
				<td><spring:eval expression="restaurent.modifiedBy"/></td>
			</tr>
			<tr>
				<th><fmt:message key="restaurent_modifiedDate" /></th>
				<td><spring:eval expression="restaurent.modifiedDate"/></td>
			</tr>
			<tr>
				<th><fmt:message key="category" /></th>
				<td>
					<ul class="inline">
						<c:forEach items="${restaurent.categories}" var="category" varStatus="status">
							<li>
								<spring:eval expression="category" /><a href="${pageContext.request.contextPath}/domain/category/show/${category.primaryKey}" class="button button-show miniature"><fmt:message key="crud.show.button" /></a>
							</li>
						</c:forEach>
					</ul>
				</td>
			</tr>
		</tbody>
	</table>
</body>
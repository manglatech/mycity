<%--
 | (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 | Source code generated by Celerio, a Jaxio product
 | Want to use Celerio within your company? email us at info@jaxio.com
 | Follow us on twitter: @springfuse
 | Template pack-mvc-3:src/main/webapp/WEB-INF/views/domain/list.e.vm.jsp
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="tags" tagdir="/WEB-INF/tags"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="spring" uri="http://www.springframework.org/tags"
%><%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><head>
	<title><fmt:message key="role" />: <fmt:message key="crud.functionalities.list" /></title>
</head>
<body>
	<h2><fmt:message key="role" />: <fmt:message key="crud.functionalities.list" /></h2>
	<div id="result">
	<c:choose>
		<c:when test="${rolesCount == 0}">
			<fmt:message key="crud.search.empty.result" />
		</c:when>
		<c:otherwise>
			<table class="list">
				<thead>
					<tr>
						<th><tags:sort-header model="role" attribute="roleName" url="list"/></th>
						<th>&nbsp;</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${roles}" var="role" varStatus="_st">
						<tr>
							<td><spring:eval expression="role.roleName"/></td>
							<td>
								<a href="${pageContext.request.contextPath}/domain/role/show/${role.primaryKey}" class="button button-show miniature"><fmt:message key="crud.show.button"/></a>
								<a href="${pageContext.request.contextPath}/domain/role/update/${role.primaryKey}" class="button button-edit miniature"><fmt:message key="crud.edit.button"/></a>
								<a href="${pageContext.request.contextPath}/domain/role/delete/${role.primaryKey}" class="button button-delete modal miniature"><fmt:message key="crud.delete.button"/></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<th colspan="1">
							<tags:navigation totalSize="${rolesCount}" search="${roleSearchForm.sp}" url="list"/>
						</th>
						<th><fmt:message key="search.total"><fmt:param value="${rolesCount}"/></fmt:message></th>
					</tr>
				</tfoot>
			</table>
		</c:otherwise>
	</c:choose>
	</div>
</body>
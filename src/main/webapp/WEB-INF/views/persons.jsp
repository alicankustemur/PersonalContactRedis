<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="col-lg-3">
	<table class="table table-striped table-hover table-bordered">

		<thead>
		<thead>
			<th colspan="5">Kişi Listesi</th>
		</thead>
		<th>ID</th>
		<th>Ad</th>
		<th>Soyad</th>
		<th>Sil</th>
		<th>Güncelle</th>
		<c:if  test="${fn:length(persons) < 1}">
			<tr>
				<td colspan="5">
					<c:out value="Hiç kayıt bulunamadı."></c:out>
				</td>
			</tr>
		</c:if>
		
		<c:forEach items="${persons}" var="person" varStatus="i">
			<tr id="${person.id}">
				<td class="id">${person.id}</td>
				<td><c:out value="${person.name}"></c:out></td>
				<td><c:out value="${person.surname}"></c:out></td>
				<td><a class="btn btn-danger" onClick="deleteUser('${person.id}','${person.name}');">Sil</a></td>
				<td><a href="<c:url value='updatePerson?id=${person.id}' />" class="btn btn-success">Güncelle</a></td>
			</tr>
		</c:forEach>


	</table>
</div>
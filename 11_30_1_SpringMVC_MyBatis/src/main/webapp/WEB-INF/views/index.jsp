<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
	<table align="center" border="1" style="border-radius: 3px;">
		<form action="student.reg">
			<tr>
				<td>이름</td>
				<td><input name="s_name" placeholder="이름입력"></td>
			</tr>
			<tr>
				<td>별명</td>
				<td><input name="s_nickname" placeholder="별명입력"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><button>이동</button></td>
			</tr>
		</form>
	</table>
	<hr>
	<table align="center" border="1"
		style="margin-top: 30px; border-radius: 3px;">
		<c:forEach var="s1" items="${ students}">
			<tr>
				<td>이름 :</td>
				<td>${s1.s_name}</td>
			</tr>
			<tr>
				<td>닉네임 :</td>
				<td>${s1.s_nickname}</td>
			</tr>
		</c:forEach>
	</table>
	<hr>
	<table align="center" border="1"
		style="margin-top: 30px; border-radius: 3px;">
		<form action="test.reg">
			<tr>
				<td colspan="1">과목명</td>
				<td colspan="3"><input name="t_title" maxlength="20"
					placeholder="과목명입력"></td>
			</tr>
			<tr>
				<td>날짜 :</td>
				<td><select name="t_y">
						<c:forEach var="y" begin="2023" end="2024">
							<option>${y }</option>
						</c:forEach>
				</select></td>
				<td><select name="t_m">
						<c:forEach var="m" begin="1" end="12">
							<option>${m }</option>
						</c:forEach>
				</select></td>
				<td><select name="t_d">
						<c:forEach var="d" begin="1" end="31">
							<option>${d }</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td colspan="4" align="center">
					<button>등록</button>
				</td>
			</tr>
		</form>
	</table>
	<hr>
	<table align="center" border="1"
		style="margin-top: 30px; border-radius: 3px;">
		<c:if test="${r != null}">
			<c:forEach var="t" items="${ tests}">
				<tr>
					<td>과목명</td>
					<td><input name="t_title_res" readonly="readonly"
						value="${t.t_title}"></td>
				</tr>
				<tr>
					<td>날짜</td>
					<td><fmt:formatDate value="${t.t_when }" type="date" dateStyle="short"/></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	<hr>
	<c:if test="${r != null}">
		<h1>${r}</h1>
	</c:if>

</body>
</html>
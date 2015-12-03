<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

 

<div id = nav style="text-align:center">
	<ul>  
		<sec:authorize access="hasRole('ROLE_ADMIN')">	
				<a href='<c:url value="/physician/add"/>'> Add Physician |</a>		
		</sec:authorize>
		
		<sec:authorize access="hasRole('ROLE_USER')">		
			<sec:authentication property="principal" var ="user" />
			<p>Welcome <c:out value="${user.username}" /></p>
			<a href='<c:url value="/medicalController/"/>'><b> Home</b></a> |
			<a href='<c:url value="/medicalController/add"/>'><b> Add Patient & Medical History</b></a>  |			
			<a href='<c:url value="/medicalController/yearlyCheckUp"/>'><b> Annual Consultation</b></a> |
			<a href='<c:url value="/medicalController/add"/>'><b> Edit Patient Information & Medical History</b></a> |
		</sec:authorize>

		
			<a href="../logout"><b> Logout</b></a>			
			<form action ="logout" method="post">				
				<td><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/></td>
			</form>
	</ul>
</div>
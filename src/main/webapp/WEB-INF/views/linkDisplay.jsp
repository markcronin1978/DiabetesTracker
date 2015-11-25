<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

 

<div id = nav style="text-align:center">
	<ul>   <!-- here i am declaring that any view of link with /customer/ in the url has to be sent through the security checks in the spring-infrastructure.xml file -->
		<sec:authorize access="hasRole('ROLE_ADMIN')">	
				<a href='<c:url value="/physician/add"/>'> Add Physician |</a>		
		</sec:authorize>
		
		<sec:authorize access="hasRole('ROLE_USER')">		
			<sec:authentication property="principal" var ="user" />
			<p>Welcome <c:out value="${user.username}" /></p>
			<a href='<c:url value="/medicalController/"/>'> Home |</a>
			<a href='<c:url value="/medicalController/add"/>'> Add Patient |</a>			
			<a href='<c:url value="/medicalController/yearlyCheckUp"/>'> Annual Consultation |</a>
		</sec:authorize>

		
			<a href="../logout"> Logout</a>			
			<form action ="logout" method="post">				
				<td><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/></td>
			</form>
	</ul>
</div>
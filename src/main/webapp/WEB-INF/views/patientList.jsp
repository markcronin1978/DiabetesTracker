<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

			
	<jsp:include page="header.jsp" /> <!-- Include the header.jsp page on build -->
	
		<jsp:include page="linkDisplay.jsp" />
		
		<div id="content" style="text-align:center">
			
			<h2>Patient List:</h2>
			<p>To view a Patients' Medical history Click on Patients' Name.</p>
			
				<p style="color:red"><c:out value="${Error_msg}" /></p> 
				
				<table align="center">
				<tr>
					<td>  Name |</td><td>Address 1 |</td><td>Address 2 |</td><td>Address 3 |</td><td>Address 4 |</td><td>Date of Birth |</td><td>Telephone Number |</td><td>Regular Consultation |</td>
				</tr>
										
					<c:forEach var="pat" items="${patient}">
						<form:form method = "post" action = "regularCheckup/${pat.id}">
							<input type="hidden" name="_method" value="get">
							<tr>
								<td><a href = '<c:url value="history/${pat.id}/"/>'>${pat.name}</a></td><td>${pat.address1}</td><td>${pat.address2}</td><td>${pat.address3}</td><td>${pat.address4}</td><td>${pat.dateOfBirth}</td><td>${pat.phoneNumber}</td>
								<td><input name="Select" type="submit" value="Begin"/></td>
								<td><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/></td>
							</tr>
						</form:form>
					</c:forEach>   
				</table> 
			</div>

	<jsp:include page="footer.jsp" />
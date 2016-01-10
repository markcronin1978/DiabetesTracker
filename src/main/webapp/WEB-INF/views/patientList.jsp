<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

			
	<jsp:include page="header.jsp" /> <!-- Include the header.jsp page on build -->
	
		<jsp:include page="linkDisplay.jsp" />	<!-- Include the listDisplay.jsp page on build -->
		
		<div id="content" style="text-align:center">
		
		<!-- Search database for a specific patient -->
		
		<p style="color:red"><c:out value="${Error_msg1}" /></p>
			<c:url value="/medicalController/name" var="form_url"/>
				<form:form method="post" action="${form_url}">
				 	<table align="center">
						<tr>
							<td>Enter Patient Name to Search the Medical Database:</td><td><input name="name" path="sku" size="10" /></td><td><input type="submit" value="Search"/></td> 
						</tr> 
					</table>
				</form:form>
			
		<!-- Present list of patient for a specific doctor, also link to medical history -->	
			
			<h2>Patient List:</h2>
			<p>To view a Patients' Medical history Click on Patients' Name.</p>
			
				<p style="color:red"><c:out value="${Error_msg}" /></p> 
				
				<table align="center">
				<tr>
					<td><b>  Name |</b></td><td><b>Address 1 |</b></td><td><b>Address 2 |</b></td><td><b>Address 3 |</b></td><td><b>Address 4 |</b></td><td><b>Date of Birth |</b></td><td><b>Telephone Number |</b></td><td><b>Regular Consultation |</b></td>
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

	<jsp:include page="footer.jsp" />	<!-- Include the footer.jsp page on build -->
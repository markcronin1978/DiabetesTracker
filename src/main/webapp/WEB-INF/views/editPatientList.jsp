<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

			
	<jsp:include page="header.jsp" /> <!-- Include the header.jsp page on build -->
	
		<jsp:include page="linkDisplay.jsp" />
		
		<div id="content" style="text-align:center">
			
			<h2>Patient List:</h2>
			<p><b>To Edit Patients' Personal Information Click on Patients' Name.</b></p>
							
				<table align="center">
				<tr>
					<td><b>  Name |</b></td><td><b>Address 1 |</b></td><td><b>Address 2 |</b></td><td><b>Address 3 |</b></td><td><b>Address 4 |</b></td><td><b>Date of Birth |</b></td><td><b>Telephone Number |</b></td>
				</tr>
										
					<c:forEach var="pat" items="${patient}">
						<tr>
							<td><a href = '<c:url value="/patientController/${pat.id}/"/>'>${pat.name}</a></td><td>${pat.address1}</td><td>${pat.address2}</td><td>${pat.address3}</td><td>${pat.address4}</td><td>${pat.dateOfBirth}</td><td>${pat.phoneNumber}</td>
						</tr>
					</c:forEach>   
				</table> 
			</div>>
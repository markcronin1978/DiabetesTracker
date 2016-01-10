<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


	<jsp:include page="header.jsp" />    <!-- I am including the Header.jsp page -->
	
		<jsp:include page="linkDisplay.jsp" />	<!-- I am including the LinkDisplay.jsp page -->
			
		<div id="content" style="text-align:center">
		
												<!-- present end user with medical history form to take information about patient-->
		
			<h3>Patient Medical Information</h3>
				<c:url value="/medicalController/medicalHistory" var="form_url"/>    
					<form:form action="${form_url}" commandName="history">   
						<table align="center">
							<tr>
								<td>Is the Patient a Smoker: </td>
								<td><form:input path="smoker" size="5" /></td>
								<td><form:errors path="smoker" style="color:red" cssclass="error" ></form:errors></td>
							</tr>
							<tr>
								<td>Is the Patient Insulin Dependant:</td>
								<td><form:input path="insulinDependant" size="5" /></td>
								<td><form:errors path="insulinDependant" style="color:red" cssclass="error" ></form:errors></td>
							</tr>
							<tr>
								<td>Has the Patient Recieved the Pneumococcal Vaccine:</td>
								<td><form:input path="pneumococcalVaccine" size="5" /></td>
								<td><form:errors path="pneumococcalVaccine" style="color:red" cssclass="error" ></form:errors></td>							
							</tr>
							<tr>
								<td>Other relevant information:</td>
								<td><form:textarea path="comments" rows="4" cols="32" /></td>
								<td><form:errors path="comments" style="color:red" cssclass="error" ></form:errors></td>								
							</tr>
							<tr>						
								<td><form:hidden path="PatientId" /></td>
								<td><input type="submit" value="Save" /></td>
								<td><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/></td>
							</tr>
						</table>
					</form:form>
		</div>
				
	<jsp:include page="footer.jsp" />	<!-- I am including the footer.jsp page -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

			
	<jsp:include page="header.jsp" /> <!-- Include the header.jsp page on build -->
	
		<jsp:include page="linkDisplay.jsp" /> 	<!-- Include the linkDisplay.jsp page on build -->
			
			<div id="content" style="text-align:center">
				
				<h3>Edit Medical History Information</h3>
															<!-- present form to end user to input patient medical history -->
				<c:url value="/medicalController/medicalHistory" var="form_url"/>    
					<form:form action="${form_url}" commandName="history">    
						<table align="center">
							<tr>
								<td>Smoker: </td>
								<td><form:input path="smoker" size="30" /></td>
								<td><form:errors path="smoker" style="color:red" cssclass="error" ></form:errors></td>
							</tr>
							<tr>
								<td>insulinDependant:</td>
								<td><form:input path="insulinDependant" size="30" /></td>
								<td><form:errors path="insulinDependant" style="color:red" cssclass="error" ></form:errors></td>
							</tr>
							<tr>
								<td>pneumococcalVaccine:</td>
								<td><form:input path="pneumococcalVaccine" size="30" /></td>
								<td><form:errors path="pneumococcalVaccine" style="color:red" cssclass="error" ></form:errors></td>							
							</tr>
							<tr>
								<td>comments:</td>
								<td><form:textarea path="comments" rows="4" cols="32" /></td>
								<td><form:errors path="comments" style="color:red" cssclass="error" ></form:errors></td>							
							</tr>
							
							<tr>						
								<td><form:hidden path="patientId" /></td>
								<td><input type="submit" value="Save" /></td>
								<td><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/></td>
							</tr>
						</table>
					</form:form>
					
				</div>
					

	<jsp:include page="footer.jsp" />	<!-- Include the footer.jsp page on build -->
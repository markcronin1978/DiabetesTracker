<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


	<jsp:include page="header.jsp" />    <!-- I am including the Header.jsp page -->
	
		<jsp:include page="linkDisplay.jsp" />	<!-- I am including the LinkDisplay.jsp page -->
			
			<div id="content" style="text-align:center">
			
			<h3>Patient Name: <c:out value="${patient.name}" /></h3>
			
			<!-- present end user with form to obtain information about a specific patient during a yearly check up -->
			
			<h3>Add Patient Information</h3>
				<c:url value="/medicalController/saveYearlyCheckup" var="form_url"/>    
					<form:form action="${form_url}" commandName="yearlyCheckup">    
						<table align="center">
							<tr>
								<td>Is the Patient suffering from Eye Retinspathy: </td>
								<td><form:input path="eyeRetinspathy" size="30" /></td>
								<td><form:errors path="eyeRetinspathy" style="color:red" cssclass="error" ></form:errors></td>
							</tr>
							<tr>
								<td>Has the Patient received the Flu-Vaccine:</td>
								<td><form:input path="fluVaccineRecieved" size="30" /></td>
								<td><form:errors path="fluVaccineRecieved" style="color:red" cssclass="error" ></form:errors></td>
							</tr>
							<tr>
								<td>The date the Flu-Vaccine was received (YYYY-MM-DD):</td>
								<td><form:input path="dateFluVaccineRecieved" size="30" /></td>							
							</tr>
							<tr>
								<td>Has the Patient evidence of a foot infection:</td>
								<td><form:input path="footInfection" size="30" /></td>
								<td><form:errors path="footInfection" style="color:red" cssclass="error" ></form:errors></td>								
							</tr>
							<tr>
								<td>The Patients' foot pulse (Strong/Weak/Absent):</td>
								<td><form:input path="footPulse" size="30" /></td>
								<td><form:errors path="footPulse" style="color:red" cssclass="error" ></form:errors></td>								
							</tr>
							<tr>
								<td>The Patients' foot vibration sense (Normal/Abnormal):</td>
								<td><form:input path="footVibrationSense" size="30" /></td>
								<td><form:errors path="footVibrationSense" style="color:red" cssclass="error" ></form:errors></td>						
							</tr>
							<tr>
								<td>Evidence of foot corns (Yes/No):</td>
								<td><form:input path="footCorn" size="30" /></td>
								<td><form:errors path="footCorn" style="color:red" cssclass="error" ></form:errors></td>
														
							</tr>
							<tr>
								<td>Patients' abdominal circumference:</td>
								<td><form:input path="abdCircumference" size="30" /></td>
								<td><form:errors path="abdCircumference" style="color:red" cssclass="error" ></form:errors></td>						
							</tr>
							<tr>
								<td>General comments on the Patients' health (Max 500):</td>
								<td><form:textarea path="comment" rows="4" cols="32" /></td>
								<td><form:errors path="comment" style="color:red" cssclass="error" ></form:errors></td>					
							</tr>

							<tr>						
								<td><form:hidden path="patientId" /></td>
								<td><input type="submit" value="Save" /></td>
								<td><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/></td>
							</tr>
						</table>
					</form:form>
			</div>
					
	<jsp:include page="footer.jsp" />	<!-- I am including the footer.jsp page -->
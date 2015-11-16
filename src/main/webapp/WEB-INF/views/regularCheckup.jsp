<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


	<jsp:include page="header.jsp" />    <!-- I am including the Header.jsp page -->
	
		<jsp:include page="linkDisplay.jsp" />	<!-- I am including the LinkDisplay.jsp page -->
			
			<p>Add Patient Information</p>
				<c:url value="/medicalController/saveRegCheckup" var="form_url"/>    
					<form:form action="${form_url}" commandName="regularCheckUp">    
						<table align="center">
							<tr>
								<td>Patient Blood Pressure Level: </td>
								<td><form:input path="bloodPressureLevel" size="10" /></td>
								<td><form:errors path="bloodPressureLevel" style="color:red" cssclass="error" ></form:errors></td>
							</tr>
							<tr>
								<td>Patient Blood Sugar Level:</td>
								<td><form:input path="bloodSugarLevel" size="10" /></td>
								<td><form:errors path="bloodSugarLevel" style="color:red" cssclass="error" ></form:errors></td>
							</tr>
							<tr>
								<td>Patient Cholesterol Level:</td>
								<td><form:input path="cholesterolLevel" size="10" /></td>
								<td><form:errors path="cholesterolLevel" style="color:red" cssclass="error" ></form:errors></td>							
							</tr>
							<tr>
								<td>Patient eGFR Ratio:</td>
								<td><form:input path="eGFRRatio" size="10" /></td>
								<td><form:errors path="eGFRRatio" style="color:red" cssclass="error" ></form:errors></td>								
							</tr>
							<tr>
								<td>Patient hbA1C Level:</td>
								<td><form:input path="hbA1cLevel" size="10" /></td>
								<td><form:errors path="hbA1cLevel" style="color:red" cssclass="error" ></form:errors></td>								
							</tr>
							<tr>
								<td>Has the Patient had a Hyperglycaemia Episode (yes/no):</td>
								<td><form:input path="hyperEpisode" size="10" /></td>
								<td><form:errors path="hyperEpisode" style="color:red" cssclass="error" ></form:errors></td>						
							</tr>
							<tr>
								<td>Number of Episodes:</td>
								<td><form:input path="hyperNoOfTimes" size="10" /></td>
														
							</tr>
							<tr>
								<td>Has the Patient had a Hypoglycaemia Episode (yes/no):</td>
								<td><form:input path="hypoEpisode" size="10" /></td>
								<td><form:errors path="hypoEpisode" style="color:red" cssclass="error" ></form:errors></td>						
							</tr>
							<tr>
								<td>Number of Episodes:</td>
								<td><form:input path="hypoNoOfTimes" size="10" /></td>
												
							</tr>
							<tr>
								<td>Patient Urine Level:</td>
								<td><form:input path="urineLevel" size="10" /></td>
								<td><form:errors path="urineLevel" style="color:red" cssclass="error" ></form:errors></td>						
							</tr>
							<tr>
								<td>Patient Weight</td>
								<td><form:input path="weight" size="10" /></td>
								<td><form:errors path="weight" style="color:red" cssclass="error" ></form:errors></td>						
							</tr>
							<tr>
								<td>Patient BMI:</td>
								<td><form:input path="bmi" size="10" /></td>
								<td><form:errors path="bmi" style="color:red" cssclass="error" ></form:errors></td>						
							</tr>
							<tr>
								<td>General Comment on Patients' Health:</td>
								<td><form:textarea path="comment" rows="4" cols="50" /></td>				
							</tr>

							<tr>						
								<td><form:hidden path="patientId" /></td>
								<td><input type="submit" value="Save" /></td>
								<td><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/></td>
							</tr>
						</table>
					</form:form>
					
	<jsp:include page="footer.jsp" />	<!-- I am including the footer.jsp page -->
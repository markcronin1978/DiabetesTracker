<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


	<jsp:include page="header.jsp" />    <!-- I am including the Header.jsp page -->
	
		<jsp:include page="linkDisplay.jsp" />	<!-- I am including the LinkDisplay.jsp page -->
		
		<div id="content" style="text-align:center">
			
			<h3>Add Patient Information</h3>        <!-- present patient information to end user -->
				<c:url value="/patientController/savePatient" var="form_url"/>     
					<form:form action="${form_url}" commandName="patient">    <!-- This is the patient form.  -->
						<table align="center">
							<tr>
								<td>Name: </td>
								<td><form:input path="name" size="50" /></td>
								<td><form:errors path="name" style="color:red" cssclass="error" ></form:errors></td>
							</tr>
							<tr>
								<td>Address 1:</td>
								<td><form:input path="address1" size="50" /></td>
								<td><form:errors path="address1" style="color:red" cssclass="error" ></form:errors></td>
							</tr>
							<tr>
								<td>Address 2:</td>
								<td><form:input path="address2" size="50" /></td>
								<td><form:errors path="address2" style="color:red" cssclass="error" ></form:errors></td>							
							</tr>
							<tr>
								<td>Address 3:</td>
								<td><form:input path="address3" size="50" /></td>
								<td><form:errors path="address3" style="color:red" cssclass="error" ></form:errors></td>								
							</tr>
							<tr>
								<td>Address 4 (Optional):</td>
								<td><form:input path="address4" size="50" /></td>								
							</tr>
							<tr>
								<td>Telephone Number</td>
								<td><form:input path="phoneNumber" size="50" /></td>
								<td><form:errors path="phoneNumber" style="color:red" cssclass="error" ></form:errors></td>						
							</tr>
							<tr>
								<td>Date Of Birth (YYYY-MM-DD)</td>
								<td><form:input path="dateOfBirth" size="50" /></td>
								<td><form:errors path="dateOfBirth" style="color:red" cssclass="error" ></form:errors></td>						
							</tr>
							<tr>
								<td>Physician Name:</td>
								<td><form:input path="phyName" size="50" /></td>
								<td><form:errors path="phyName" style="color:red" cssclass="error" ></form:errors></td>	
							</tr>

							<tr>						
								<td><form:hidden path="id" /></td>
								<td><input type="submit" value="Save" /></td>
								<td><input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/></td>
							</tr>
						</table>
					</form:form>
			</div>
					
	<jsp:include page="footer.jsp" />	<!-- I am including the footer.jsp page -->
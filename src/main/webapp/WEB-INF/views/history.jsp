<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

			
	<jsp:include page="header.jsp" /> <!-- Include the header.jsp page on build -->
	
		<jsp:include page="linkDisplay.jsp" />	<!-- Include the linkDisplay.jsp page on build -->
		
		<div id="content" style="text-align:center">
			
			<h3>Patient Name: <c:out value="${patient.name}" /></h3>
			
			<h3><i>Patient Medical History:</i></h3>
					<table align="center">	
						<tr>					
							<th> Smoker |</th><th> Insulin Dependant |</th><th> Pneumoccal Vaccine |</th>
						</tr>
						<tr>
							<td> ${history.smoker} </td><td> ${history.insulinDependant} </td><td> ${history.pneumococcalVaccine} </td>
						</tr>
						<tr>
							<th colspan="3">Comments</th>			
						</tr>
						<tr>
							<td colspan="3">${history.comments}</td>
						</tr>
						 <tr>
						 	<td colspan="13">------------------------------------------------</td>
						 </tr>										
					</table>
				</br>
				<h3><i>Patient Yearly Consultation Results:</i></h3>
					<table align="center">
						<tr>
							<th> Date |</th><th> Eye-Retinspathy |</th><th> flu-vaccine Recieved |</th><th> Date of Flu-vaccine |</th><th> Foot Infection |</th><th> Foot Pulse |</th><th> Foot Vibration Sense |</th><th> Foot Corn |</th><th> abdonimal Circumference |</th>
						</tr>
			  				<c:forEach var="yearHist" items="${yearHist}">
			  					<tr>
			  						<td> ${yearHist.checkUpDate} </td><td> ${yearHist.eyeRetinspathy} </td><td> ${yearHist.fluVaccineRecieved} </td><td> ${yearHist.dateFluVaccineRecieved} </td><td> ${yearHist.footInfection} </td><td> ${yearHist.footPulse} </td><td> ${yearHist.footVibrationSense} </td><td> ${yearHist.footCorn} </td><td> ${yearHist.abdCircumference} </td>
						 		</tr>
						 		<tr>
						 			<th colspan="13"> Comments </th>
						 		</tr>
						 		<tr>
						 			<td colspan="13"> ${yearHist.comment} </td>
						 		</tr>
						 		<tr>
						 			<td colspan="13">------------------------------------------------</td>
						 		</tr>
							</c:forEach> 
					</table>
				</br>				
				<h3><i>Patient Regular Consultation Results:</i></h3>
					<table align="center">
						<tr>
							<th> Date |</th><th> Blood Pressure Level |</th><th> Blood Sugar Level |</th><th> Cholesterol Level |</th><th> eGFR Ratio |</th><th> hbA1c Level |</th><th> Hyperglycemia Episode |</th><th> Hyperglycemia No. |</th><th> Hypoglycemia Episode |</th><th> Hypoglycemia No. |</th><th> Urine Level |</th><th> Weight |</th><th> Bmi |</th>
						</tr>
			  				<c:forEach var="regHist" items="${regHist}">
			  					<tr>
			  						<td>${regHist.checkupDate} </td><td>${regHist.bloodPressureLevel} </td><td>${regHist.bloodSugarLevel} </td><td>${regHist.cholesterolLevel} </td><td>${regHist.eGFRRatio} </td><td>${regHist.hbA1cLevel} </td><td>${regHist.hyperEpisode} </td><td>${regHist.hyperNoOfTimes} </td><td>${regHist.hypoEpisode} </td><td>${regHist.hypoNoOfTimes} </td><td>${regHist.urineLevel} </td><td>${regHist.weight} </td><td>${regHist.bmi} </td>
						 		</tr>
						 		<tr>
						 			<th colspan="13"> Comments </th>
						 		</tr>
						 		<tr>
						 			<td colspan="13"> ${regHist.comment} </td>
						 		</tr>
						 		<tr>
						 			<td colspan="13">------------------------------------------------</td>
						 		</tr>
							</c:forEach> 
					</table> 
				<br>					
		</div>

	<jsp:include page="footer.jsp" />
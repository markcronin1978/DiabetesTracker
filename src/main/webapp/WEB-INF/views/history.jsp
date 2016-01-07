<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

			
	<jsp:include page="header.jsp" /> <!-- Include the header.jsp page on build -->
	
		<jsp:include page="linkDisplay.jsp" />
		
		<div id="content" style="text-align:center">
			
			<h3>Patient Name: <c:out value="${patient.name}" /></h3>
			
			<h3>Patient Medical History:</h3>
					<table cellpadding='10' align="center">	
						<tr>					
							<td><b>Smoker</b></td><td><b>Insulin Dependant</b></td><td><b>Pneumoccal Vaccine</b></td><td><b>Comments</b></td>			
						</tr>
						<tr>
							<td>${history.smoker}</td><td>${history.insulinDependant}</td><td>${history.pneumococcalVaccine}</td><td>${history.comments}</td>
						</tr>
										
					</table>
				<br>
				<h3>Patient Yearly Consultation Results:</h3>
				<table cellpadding='5' align="center">
					<tr>
						<td><b>Date (YYYY-MM-DD)</b></td><td><b>Eye-Retinspathy</b></td><td><b>flu-vaccine Recieved</b></td><td><b>Date of Flu-vaccine</b></td><td><b>Foot Infection</b></td><td><b>Foot Pulse</b></td><td><b>Foot Vibration Sense</b></td><td><b>Foot Corn</b></td><td><b>abdonimal Circumference</b></td>
					</tr>
			  			<c:forEach var="yearHist" items="${yearHist}">
			  				<tr>
			  					<td>${yearHist.checkUpDate}</td><td>${yearHist.eyeRetinspathy}</td><td>${yearHist.fluVaccineRecieved}</td><td>${yearHist.dateFluVaccineRecieved}</td><td>${yearHist.footInfection}</td><td>${yearHist.footPulse}</td><td>${yearHist.footVibrationSense}</td><td>${yearHist.footCorn}</td><td>${yearHist.abdCircumference}</td>
					 		</tr>
					 		<tr>
					 			<td><b>Comments</b></td>
					 		</tr>
					 		<tr>
					 			<td>${yearHist.comment}</td>
					 		</tr>
						</c:forEach> 
				</table>
				<br>				
				<h3>Patient Regular Consultation Results:</h3>
				<table cellpadding='5' align="center">
					<tr>
						<td><b>Date (YYYY-MM-DD)</b></td><td><b>Blood Pressure Level</b></td><td><b>Blood Sugar Level</b></td><td><b>Cholesterol Level</b></td><td><b>eGFR Ratio</b></td><td><b>hbA1c Level</b></td><td><b>Hyperglycemia Episode</b></td><td><b>Hyperglycemia Number</b></td><td><b>Hypoglycemia Episode</b></td><td><b>Hypoglycemia Number</b></td><td><b>Urine Level</b></td><td><b>Weight</b></td><td><b>Bmi</b></td>
					</tr>
			  			<c:forEach var="regHist" items="${regHist}">
			  				<tr>
			  					<td>${regHist.checkupDate}</td><td>${regHist.bloodPressureLevel}</td><td>${regHist.bloodSugarLevel}</td><td>${regHist.cholesterolLevel}</td><td>${regHist.eGFRRatio}</td><td>${regHist.hbA1cLevel}</td><td>${regHist.hyperEpisode}</td><td>${regHist.hyperNoOfTimes}</td><td>${regHist.hypoEpisode}</td><td>${regHist.hypoNoOfTimes}</td><td>${regHist.urineLevel}</td><td>${regHist.weight}</td><td>${regHist.bmi}</td>
					 		</tr>
					 		<tr>
					 			<td><b>Comments</b></td>
					 		</tr>
					 		<tr>
					 			<td>${regHist.comment}</td>
					 		</tr>
						</c:forEach> 
				</table> 
				<br>				

				
		</div>

	<jsp:include page="footer.jsp" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

			
	<jsp:include page="header.jsp" /> <!-- Include the header.jsp page on build -->
	
		<jsp:include page="linkDisplay.jsp" />
		
		<div id="content" style="text-align:center">
			
			<h2>Patient Medical History:</h2>
					<table cellpadding='10' align="center">	
						<tr>					
							<td><b>Smoker</b></td><td><b>Insulin Dependant</b></td><td><b>Pneumoccal Vaccine</b></td><td><b>Comments</b></td>			
						</tr>
						<tr>
							<td>${history.smoker}</td><td>${history.insulinDependant}</td><td>${history.pneumococcalVaccine}</td><td>${history.comments}</td>
						</tr>
										
					</table>
				<br>				
				<h2>Patient Regular Check-up History</h2>
				<table cellpadding='5' align="center">
					<tr>
						<td><b>Date (YYYY-MM-DD)</b></td><td><b>Blood Pressure Level</b></td><td><b>Blood Sugar Level</b></td><td><b>Cholesterol Level</b></td><td><b>eGFR Ratio</b></td><td><b>hbA1c Level</b></td><td><b>Hyperglycemia Episode</b></td><td><b>Hyperglycemia Number</b></td><td><b>Hypoglycemia Episode</b></td><td><b>Hypoglycemia Number</b></td><td><b>Urine Level</b></td><td><b>Weight</b></td><td><b>Bmi</b></td><td><b>Comments</b></td>
					</tr>
			  			<c:forEach var="regHist" items="${regHist}">
			  				<tr>
			  					<td>${regHist.checkupDate}</td><td>${regHist.bloodPressureLevel}</td><td>${regHist.bloodSugarLevel}</td><td>${regHist.cholesterolLevel}</td><td>${regHist.eGFRRatio}</td><td>${regHist.hbA1cLevel}</td><td>${regHist.hyperEpisode}</td><td>${regHist.hyperNoOfTimes}</td><td>${regHist.hypoEpisode}</td><td>${regHist.hypoNoOfTimes}</td><td>${regHist.urineLevel}</td><td>${regHist.weight}</td><td>${regHist.bmi}</td><td>${regHist.comment}</td>
					 		</tr>
						</c:forEach> 
				</table> 
				
		</div>
	
	<jsp:include page="footer.jsp" />
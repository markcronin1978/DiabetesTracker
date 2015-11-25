<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

			
	<jsp:include page="header.jsp" /> <!-- Include the header.jsp page on build -->
	
		<jsp:include page="linkDisplay.jsp" />
		
		<div id="content" style="text-align:center">
			
			<h2>Patient Medical History:</h2>
					<table cellpadding='10' align="center">	
						<tr>					
							<td>Smoker</td><td>Insulin Dependant</td><td>Pneumoccal Vaccine</td><td>Comments</td>			
						</tr>
						<tr>
							<td>${history.smoker}</td><td>${history.insulinDependant}</td><td>${history.pneumococcalVaccine}</td><td>${history.comments}</td>
						</tr>
										
					</table>
				<br>				
				<h2>Patient Regular Check-up History</h2>
				<table cellpadding='5' align="center">
					<tr>
						<td>Date (YYYY-MM-DD)</td><td>Blood Pressure Level</td><td>Blood Sugar Level</td><td>Cholesterol Level</td><td>eGFR Ratio</td><td>hbA1c Level</td><td>Hyperglycemia Episode</td><td>Hyperglycemia Number</td><td>Hypoglycemia Episode</td><td>Hypoglycemia Number</td><td>Urine Level</td><td>Weight</td><td>Bmi</td><td>Comments</td>
					</tr>
			  			<c:forEach var="regHist" items="${regHist}">
			  				<tr>
			  					<td>${regHist.checkupDate}</td><td>${regHist.bloodPressureLevel}</td><td>${regHist.bloodSugarLevel}</td><td>${regHist.cholesterolLevel}</td><td>${regHist.eGFRRatio}</td><td>${regHist.hbA1cLevel}</td><td>${regHist.hyperEpisode}</td><td>${regHist.hyperNoOfTimes}</td><td>${regHist.hypoEpisode}</td><td>${regHist.hypoNoOfTimes}</td><td>${regHist.urineLevel}</td><td>${regHist.weight}</td><td>${regHist.bmi}</td><td>${regHist.comment}</td>
					 		</tr>
						</c:forEach> 
				</table> 
				
		</div>
	
	<jsp:include page="footer.jsp" />
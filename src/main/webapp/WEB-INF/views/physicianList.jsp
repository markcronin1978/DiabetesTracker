<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

			
	<jsp:include page="header.jsp" /> <!-- Include the header.jsp page on build -->
	
		<jsp:include page="linkDisplay.jsp" />	<!-- I am including the LinkDisplay.jsp page -->
		
		<div id="content" style="text-align:center">
		
		<!-- present list of phyisicans -->
			
			<h2>Physician List:</h2>
				<h3>To Edit Physician Information, Click on Physician Name</h3>
				<c:forEach var="phy" items="${physician}">
					<p><a href ='<c:url value = "/physician/${phy.id}/"/>'>${phy.name}</a> ${phy.address1} ${phy.address2} ${phy.address3} ${phy.address4} </p> 
					 <p>Telephone Number : ${phy.phoneNumber}</p> 
				</c:forEach>    
				
		</div>
	
	<jsp:include page="footer.jsp" />
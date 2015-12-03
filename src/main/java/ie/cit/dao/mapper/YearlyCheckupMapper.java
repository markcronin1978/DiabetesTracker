package ie.cit.dao.mapper;

import ie.cit.domain.YearlyCheckup;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;



public class YearlyCheckupMapper implements RowMapper<YearlyCheckup> {

	public YearlyCheckup mapRow(ResultSet rs, int rowNum) throws SQLException {
		YearlyCheckup yc = new YearlyCheckup();
		
		yc.setPatientId(rs.getString("patientid"));
		yc.setDate(rs.getString("date"));
		yc.setEyeRetinspathy(rs.getString("eyeretinspathy"));
		yc.setFluVaccineRecieved(rs.getString("fluvaccinerecieved"));
		yc.setDateFluVaccineRecieved(rs.getString("datefluvaccinerecieved"));
		yc.setFootInfection(rs.getString("footinfection"));
		yc.setFootPulse(rs.getString("footpulse"));
		yc.setFootVibrationSense(rs.getString("footvibrationsense"));
		yc.setFootCorn(rs.getString("footcorn"));
		yc.setAbdCircumference(rs.getString("abdcircumference"));
		yc.setComment(rs.getString("comment"));

		return yc;
	}

}

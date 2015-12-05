package ie.cit.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class YearlyCheckup {
	
	private String patientId;
	private String date;
	private String checkUpDate;
	@NotEmpty
	private String eyeRetinspathy;
	@NotEmpty
	private String fluVaccineRecieved;
	@NotEmpty
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String dateFluVaccineRecieved;
	@NotEmpty
	private String footInfection;
	@NotEmpty
	private String footPulse;
	@NotEmpty
	private String footVibrationSense;
	@NotEmpty
	private String footCorn;
	@NotNull
	private String abdCircumference; 
	private String comment;
	
	public YearlyCheckup(){
		
	}
	
	/**
	 * @param patientId
	 * @param date
	 * @param eyeRetinspathy
	 * @param fluVaccineRecieved
	 * @param dateFluVaccineRecieved
	 * @param footInfection
	 * @param footPulse
	 * @param footVibrationSense
	 * @param footCorn
	 * @param abdCircumference
	 * @param comment
	 */
	public YearlyCheckup(String patientId, String date, String eyeRetinspathy,
			String fluVaccineRecieved, String dateFluVaccineRecieved,
			String footInfection, String footPulse, String footVibrationSense,
			String footCorn, String abdCircumference, String comment) {
		super();
		this.patientId = patientId;
		this.date = date;
		this.eyeRetinspathy = eyeRetinspathy;
		this.fluVaccineRecieved = fluVaccineRecieved;
		this.dateFluVaccineRecieved = dateFluVaccineRecieved;
		this.footInfection = footInfection;
		this.footPulse = footPulse;
		this.footVibrationSense = footVibrationSense;
		this.footCorn = footCorn;
		this.abdCircumference = abdCircumference;
		this.comment = comment;
	}

	public YearlyCheckup(String patientId, String Date, String checkUpDate,
			String eyeRetinspathy, String fluVaccineRecieved,
			String dateFluVaccineRecieved, String footInfection,
			String footPulse, String footVibrationSense, String footCorn,
			String abdCircumference, String comment) {
		super();
		this.patientId = patientId;
		this.checkUpDate = checkUpDate;
		this.eyeRetinspathy = eyeRetinspathy;
		this.fluVaccineRecieved = fluVaccineRecieved;
		this.dateFluVaccineRecieved = dateFluVaccineRecieved;
		this.footInfection = footInfection;
		this.footPulse = footPulse;
		this.footVibrationSense = footVibrationSense;
		this.footCorn = footCorn;
		this.abdCircumference = abdCircumference;
		this.comment = comment;
	}
	
	

	public String getCheckUpDate() {
		return checkUpDate;
	}

	public void setCheckUpDate(String checkUpDate) {
		this.checkUpDate = checkUpDate;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return dateFormat.format(date);
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getEyeRetinspathy() {
		return eyeRetinspathy;
	}

	public void setEyeRetinspathy(String eyeRetinspathy) {
		this.eyeRetinspathy = eyeRetinspathy;
	}

	public String getFluVaccineRecieved() {
		return fluVaccineRecieved;
	}

	public void setFluVaccineRecieved(String fluVaccineRecieved) {
		this.fluVaccineRecieved = fluVaccineRecieved;
	}

	public String getDateFluVaccineRecieved() {
		return dateFluVaccineRecieved;
	}

	public void setDateFluVaccineRecieved(String dateFluVaccineRecieved) {
		this.dateFluVaccineRecieved = dateFluVaccineRecieved;
	}

	public String getFootInfection() {
		return footInfection;
	}

	public void setFootInfection(String footInfection) {
		this.footInfection = footInfection;
	}

	public String getFootPulse() {
		return footPulse;
	}

	public void setFootPulse(String footPulse) {
		this.footPulse = footPulse;
	}

	public String getFootVibrationSense() {
		return footVibrationSense;
	}

	public void setFootVibrationSense(String footVibrationSense) {
		this.footVibrationSense = footVibrationSense;
	}

	public String getFootCorn() {
		return footCorn;
	}

	public void setFootCorn(String footCorn) {
		this.footCorn = footCorn;
	}

	public String getAbdCircumference() {
		return abdCircumference;
	}

	public void setAbdCircumference(String abdCircumference) {
		this.abdCircumference = abdCircumference;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "YearlyCheckup [patientId=" + patientId + ", date=" + date
				+ ", eyeRetinspathy=" + eyeRetinspathy
				+ ", fluVaccineRecieved=" + fluVaccineRecieved
				+ ", dateFluVaccineRecieved=" + dateFluVaccineRecieved
				+ ", footInfection=" + footInfection + ", footPulse="
				+ footPulse + ", footVibrationSense=" + footVibrationSense
				+ ", footCorn=" + footCorn + ", abdCircumference="
				+ abdCircumference + ", comment=" + comment + "]";
	}
	
	

}
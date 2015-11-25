package ie.cit.domain;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

public class RegularCheckUp {
	
	private String patientId;
	private String date;
	private String checkupDate;

	@NotEmpty
	private String bloodPressureLevel;
	@NotNull 
	@NumberFormat(style = Style.NUMBER, pattern ="###.###")
	private double bloodSugarLevel;
	@NotNull
	@NumberFormat(style = Style.NUMBER, pattern ="###.###")
	private double cholesterolLevel;
	@NotNull 
	@NumberFormat(style = Style.NUMBER, pattern ="###.###")
	private double eGFRRatio;
	@NotNull
	@NumberFormat(style = Style.NUMBER, pattern ="###.###")
	private double hbA1cLevel;
	@NotEmpty
	private String hyperEpisode;
	private int hyperNoOfTimes;
	@NotEmpty
	private String hypoEpisode;
	private int hypoNoOfTimes;
	@NotNull
	@NumberFormat(style = Style.NUMBER, pattern ="###.###")
	private double urineLevel;
	@NotNull 
	@NumberFormat(style = Style.NUMBER, pattern ="###.###")
	private double weight;
	@NotNull
	@NumberFormat(style = Style.NUMBER, pattern ="###.###")
	private double bmi;
	private String comment;
	
	public RegularCheckUp(){
		
	}
	
	public RegularCheckUp(String patientId, String date,String checkupDate,
			String bloodPressureLevel,double bloodSugarLevel, 
			double cholesterolLevel, double eGFRRatio,
			double hbA1cLevel, String hyperEpisode, int hyperNoOfTimes,
			String hypoEpisode, int hypoNoOfTimes, double urineLevel,
			double weight, double bmi, String comment) {
		super();
		this.patientId = patientId;
		this.date = date;
		this.checkupDate= checkupDate;
		this.bloodPressureLevel = bloodPressureLevel;
		this.bloodSugarLevel = bloodSugarLevel;
		this.cholesterolLevel = cholesterolLevel;
		this.eGFRRatio = eGFRRatio;
		this.hbA1cLevel = hbA1cLevel;
		this.hyperEpisode = hyperEpisode;
		this.hyperNoOfTimes = hyperNoOfTimes;
		this.hypoEpisode = hypoEpisode;
		this.hypoNoOfTimes = hypoNoOfTimes;
		this.urineLevel = urineLevel;
		this.weight = weight;
		this.bmi = bmi;
		this.comment = comment;
	}
	

	public String getCheckupDate() {
		return checkupDate;
	}

	public void setCheckupDate(String checkupDate) {
		this.checkupDate = checkupDate;
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

	public String getBloodPressureLevel() {
		return bloodPressureLevel;
	}

	public void setBloodPressureLevel(String bloodPressureLevel) {
		this.bloodPressureLevel = bloodPressureLevel;
	}

	public double getBloodSugarLevel() {
		return bloodSugarLevel;
	}

	public void setBloodSugarLevel(double bloodSugarLevel) {
		this.bloodSugarLevel = bloodSugarLevel;
	}

	public double getCholesterolLevel() {
		return cholesterolLevel;
	}

	public void setCholesterolLevel(double cholesterolLevel) {
		this.cholesterolLevel = cholesterolLevel;
	}

	public double geteGFRRatio() {
		return eGFRRatio;
	}

	public void seteGFRRatio(double eGFRRatio) {
		this.eGFRRatio = eGFRRatio;
	}

	public double getHbA1cLevel() {
		return hbA1cLevel;
	}

	public void setHbA1cLevel(double hbA1cLevel) {
		this.hbA1cLevel = hbA1cLevel;
	}

	public String getHyperEpisode() {
		return hyperEpisode;
	}

	public void setHyperEpisode(String hyperEpisode) {
		this.hyperEpisode = hyperEpisode;
	}

	public int getHyperNoOfTimes() {
		return hyperNoOfTimes;
	}

	public void setHyperNoOfTimes(int hyperNoOfTimes) {
		this.hyperNoOfTimes = hyperNoOfTimes;
	}

	public String getHypoEpisode() {
		return hypoEpisode;
	}

	public void setHypoEpisode(String hypoEpisode) {
		this.hypoEpisode = hypoEpisode;
	}

	public int getHypoNoOfTimes() {
		return hypoNoOfTimes;
	}

	public void setHypoNoOfTimes(int hypoNoOfTimes) {
		this.hypoNoOfTimes = hypoNoOfTimes;
	}

	public double getUrineLevel() {
		return urineLevel;
	}

	public void setUrineLevel(double urineLevel) {
		this.urineLevel = urineLevel;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getBmi() {
		return bmi;
	}

	public void setBmi(double bmi) {
		this.bmi = bmi;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "RegularCheckUp [patientId=" + patientId + ", Date=" + date
				+ ", bloodPressureLevel=" + bloodPressureLevel
				+ ", bloodSugarLevel=" + bloodSugarLevel
				+ ", cholesterolLevel=" + cholesterolLevel + ", eGFRRatio="
				+ eGFRRatio + ", hbA1cLevel=" + hbA1cLevel + ", hyperEpisode="
				+ hyperEpisode + ", hyperNoOfTimes=" + hyperNoOfTimes
				+ ", hypoEpisode=" + hypoEpisode + ", hypoNoOfTimes="
				+ hypoNoOfTimes + ", urineLevel=" + urineLevel + ", weight="
				+ weight + ", bmi=" + bmi + ", comment=" + comment + "]";
	}
	
	

}

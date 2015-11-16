package ie.cit.domain;

import org.hibernate.validator.constraints.NotEmpty;

public class History {


	private String patientId;
	@NotEmpty
	private String smoker;
	@NotEmpty
	private String insulinDependant;
	@NotEmpty
	private String pneumococcalVaccine;
	private String comments;
	
	public History(){
		
	}
	
	public History(String patientId, String smoker, String insulinDependant,
			String pneumococcalVaccine, String comments) {
		super();
		this.patientId = patientId;
		this.smoker = smoker;
		this.insulinDependant = insulinDependant;
		this.pneumococcalVaccine = pneumococcalVaccine;
		this.comments = comments;
	}

	public String getPatientId() {
		return patientId;
	}

	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}

	public String getSmoker() {
		return smoker;
	}

	public void setSmoker(String smoker) {
		this.smoker = smoker;
	}

	public String getInsulinDependant() {
		return insulinDependant;
	}

	public void setInsulinDependant(String insulinDependant) {
		this.insulinDependant = insulinDependant;
	}

	public String getPneumococcalVaccine() {
		return pneumococcalVaccine;
	}

	public void setPneumococcalVaccine(String pneumococcalVaccine) {
		this.pneumococcalVaccine = pneumococcalVaccine;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "History [patientId=" + patientId + ", smoker=" + smoker
				+ ", insulinDependant=" + insulinDependant
				+ ", pneumococcalVaccine=" + pneumococcalVaccine
				+ ", comments=" + comments + "]";
	}

		
}

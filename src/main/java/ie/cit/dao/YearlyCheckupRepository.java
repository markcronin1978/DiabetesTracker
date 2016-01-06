package ie.cit.dao;

import java.util.List;

import ie.cit.domain.YearlyCheckup;

public interface YearlyCheckupRepository {

	/**
	 * Save Yearly Checkup
	 * @param yearlyCheckup
	 */
	void save(YearlyCheckup yearlyCheckup);

	/**
	 * @param id
	 * @return a list of yearly checkups for a specifc patient
	 */
	List<YearlyCheckup> getYrAll(String id);
	
	

}

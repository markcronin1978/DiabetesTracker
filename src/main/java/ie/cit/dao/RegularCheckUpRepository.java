package ie.cit.dao;

import java.util.List;

import ie.cit.domain.RegularCheckUp;

public interface RegularCheckUpRepository {
	
	/**
	 * Save a Regular Checkup
	 * @param regularCheckUp
	 */
	void save(RegularCheckUp regularCheckUp);

	/**
	 * List regular checkup history for a specific patient
	 * @param id
	 * @return
	 */
	List<RegularCheckUp> getRegAll(String id);
	


	

}

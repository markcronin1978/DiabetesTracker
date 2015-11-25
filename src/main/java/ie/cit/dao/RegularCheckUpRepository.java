package ie.cit.dao;

import java.util.List;

import ie.cit.domain.RegularCheckUp;

public interface RegularCheckUpRepository {

	void save(RegularCheckUp regularCheckUp);

	List<RegularCheckUp> getRegAll(String id);
	


	

}

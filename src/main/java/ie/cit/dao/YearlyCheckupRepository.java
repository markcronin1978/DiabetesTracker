package ie.cit.dao;

import java.util.List;

import ie.cit.domain.YearlyCheckup;

public interface YearlyCheckupRepository {

	void save(YearlyCheckup yearlyCheckup);

	List<YearlyCheckup> getYrAll(String id);
	
	

}

package ie.cit.dao;

import ie.cit.domain.History;

public interface HistoryRepository {

	void save(History history);

	History getAll(String id);

	History getById(String id);
	
	

}

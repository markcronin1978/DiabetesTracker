package ie.cit.dao;

import ie.cit.domain.History;

public interface HistoryRepository {

	/**
	 * Save History
	 * @param history
	 */
	void save(History history);

	/**
	 * Get all History for a specific patient
	 * @param id
	 * @return
	 */
	History getAll(String id);

	/**
	 * get a specific patient history
	 * @param id
	 * @return
	 */
	History getById(String id);
	
	

}

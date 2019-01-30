package excelToTable.rest.services.service;

import java.util.List;

import excelToTable.rest.services.model.RBPGroups;

public interface RBPGroupsService {
	public List<RBPGroups> findAll();
	public RBPGroups update(RBPGroups group);
	public RBPGroups create(RBPGroups group);
	public RBPGroups findById(Long id);
	public void deleteById(Long id);
	public void deleteByObject(RBPGroups group);
	public int updateAll();
	public int deleteFlagged();

}

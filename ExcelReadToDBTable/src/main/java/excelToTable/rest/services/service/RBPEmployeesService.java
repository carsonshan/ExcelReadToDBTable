package excelToTable.rest.services.service;

import java.util.List;

import excelToTable.rest.services.model.RBPEmployees;

public interface RBPEmployeesService {
	
	public List<RBPEmployees> findAll();
	public RBPEmployees update(RBPEmployees employee);
	public RBPEmployees create(RBPEmployees employee);
	public RBPEmployees findById(Long id);
	public void deleteById(Long id);
	public void deleteByObject(RBPEmployees employee);
	public int updateAll();
	public int deleteFlagged();
}

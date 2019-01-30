package excelToTable.rest.services.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import excelToTable.rest.services.model.RBPEmployees;

@Transactional
@Component
public class RBPEmployeesServiceImp implements RBPEmployeesService {
	@PersistenceContext
	 EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RBPEmployees> findAll() {
		Query query = em.createNamedQuery("RBPEmployees.findAll");
		 List<RBPEmployees> models = query.getResultList();

	        return models;
	}

	@Override
	@Transactional
	public RBPEmployees create(RBPEmployees employee) {
		 em.persist(employee);
		 return employee;
	}

	@Override
	@Transactional
	public RBPEmployees update(RBPEmployees employee) {
		em.merge(employee);
		 return employee;
	}

	@Override
	public RBPEmployees findById(Long id) {
		RBPEmployees employee = em.find(RBPEmployees.class, id);
        return employee;
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		RBPEmployees employee = em.find(RBPEmployees.class, id);
		em.remove(employee);
		
	}

	@Override
	@Transactional
	public void deleteByObject(RBPEmployees employee) {
		em.remove(employee);
		
	}

	@Override
	public int updateAll() {
		Query query = em.createNamedQuery("RBPEmployees.updateAll");
		 return query.executeUpdate();
		
	}

	@Override
	public int deleteFlagged() {
		Query query = em.createNamedQuery("RBPEmployees.deleteFlagged");
		 return query.executeUpdate();
	}

}

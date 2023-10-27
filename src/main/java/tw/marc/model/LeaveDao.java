package tw.marc.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public class LeaveDao {
	@Autowired
	private SessionFactory factory;
	
	public List<Leave> getLeaveById(Integer empId) {
		Session session = factory.openSession();
		
		String hqlstr = "from Leave where emp.employee_id=:empId";
		Query<Leave> query = session.createQuery(hqlstr, Leave.class);
		query.setParameter("empId", empId);
		
		List<Leave> res = query.getResultList();
		session.close();
		return res;
	}
}
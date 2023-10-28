package tw.marc.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public class EmployeeDao {
	@Autowired
	private SessionFactory factory;
	
	public Employee checkLogin(String empAcc, String empPwd) {
		Session session = factory.openSession();
		
		String hqlstr = "from Employee where employee_account=:e_acc and employee_password=:e_pwd";
		Query<Employee> query = session.createQuery(hqlstr, Employee.class);
		query.setParameter("e_acc", empAcc);
		query.setParameter("e_pwd", empPwd);
		
		Employee resultBean =  query.uniqueResult();
		session.close();
		
		if(resultBean!=null) {
			return resultBean;
		}
		return null;

	}
	public Employee getEmployeeById(Integer empId) {
		Session session = factory.openSession();
		
		String hqlstr = "from Employee where employee_id=:empId";
		Query<Employee> query = session.createQuery(hqlstr, Employee.class);
		query.setParameter("empId", empId);
		Employee res = query.uniqueResult();
		if( res==null) {
			System.out.println("can not find employee by Id");
		}
		session.close();
		return res;
	}
}

package tw.marc.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;

import java.util.Set;
import java.util.LinkedHashSet;
@Entity @Table(name="employee")
@Component
public class Employee {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)@Column(name="employee_id")
	private int employee_id;
	@Column(name="employee_name")
	private String employee_name;
	@Column(name="employee_account")
	private String employee_account;
	@Column(name="employee_password")
	private String employee_password;
	@OneToMany(fetch= FetchType.LAZY,mappedBy="emp",cascade=CascadeType.ALL)
	private Set<Leave> leaves= new LinkedHashSet<Leave>();
	public Set<Leave> getLeaves() {
		return leaves;
	}
	public void setLeaves(Set<Leave> leaves) {
		this.leaves = leaves;
	}
	public Employee(){
		;
	}
	public Employee(int employee_id, String employee_name, String employee_account, String employee_password) {
		super();
		this.employee_id = employee_id;
		this.employee_name = employee_name;
		this.employee_account = employee_account;
		this.employee_password = employee_password;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public String getEmployee_account() {
		return employee_account;
	}
	public void setEmployee_account(String employee_account) {
		this.employee_account = employee_account;
	}
	public String getEmployee_password() {
		return employee_password;
	}
	public void setEmployee_password(String employee_password) {
		this.employee_password = employee_password;
	}
	
	
	
}

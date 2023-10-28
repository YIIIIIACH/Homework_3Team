package tw.marc.model;

import java.util.Date;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
@Entity@Table(name="leave")
@Component
public class Leave {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="leave_id")
	private Integer leave_id;
//	@Transient
//	@Column(name="fk_employee_id")
//	private Integer fk_employee_id;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="fk_employee_id")
	private Employee emp;
	
	public Employee getEmployee() {
		return emp;
	}
	public void setEmployee(Employee employee) {
		this.emp = employee;
	}
	@Temporal(TemporalType.TIMESTAMP)@Column(name="leave_datetime")
	private Date leave_datetime;
	
	public Leave() {
		;
	}
	
	public Leave(Integer leave_id, Employee emp, Date leave_datetime, String leave_reason) {
		super();
		this.leave_id = leave_id;
		this.emp = emp;
		this.leave_datetime = leave_datetime;
		this.leave_reason = leave_reason;
	}
	public Integer getLeave_id() {
		return leave_id;
	}
	public void setLeave_id(Integer leave_id) {
		this.leave_id = leave_id;
	}
//	public Integer getFk_employee_id() {
//		return fk_employee_id;
//	}
//	public void setFk_employee_id(Integer fk_employee_id) {
//		this.fk_employee_id = fk_employee_id;
//	}
	public Date getLeave_datetime() {
		return leave_datetime;
	}
	public void setLeave_datetime(Date leave_datetime) {
		this.leave_datetime = leave_datetime;
	}
	@Column(name="leave_reason",unique=true)
	private String leave_reason;

	public String getLeave_reason() {
		return leave_reason;
	}
	public void setLeave_reason(String leave_reason) {
		this.leave_reason = leave_reason;
	}
	
	
}

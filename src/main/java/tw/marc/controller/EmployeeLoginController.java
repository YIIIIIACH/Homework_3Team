package tw.marc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tw.marc.model.Employee;
import tw.marc.model.EmployeeDao;
import tw.marc.model.Leave;
import tw.marc.model.LeaveDao;

@Controller
public class EmployeeLoginController {
	@Autowired
	private EmployeeDao eDao;
	@Autowired
	private LeaveDao lDao;
	@GetMapping("/empMain")
	public String processEmployeeLogin() {
		return "employeeLogin";
	}
	
	@PostMapping("/empCheckAcc")
	public String processEmployeeCheck(@RequestParam("empAcc") String empAcc, @RequestParam("empPwd") String empPwd, Model m) {
		// if eDao.check() success, fail
		Employee e=eDao.checkLogin(empAcc, empPwd);
		if(e!=null) {
			// get all leave of that emp
			List<Leave> leaves = lDao.getLeaveById(e.getEmployee_id());
			if(leaves !=null) {
				for(Leave l: leaves) {
					System.out.println(l.getLeave_id()+ l.getEmployee().getEmployee_name()+ l.getLeave_datetime().toString());
				}
				m.addAttribute("leaves", leaves);
			}
			return "empLeave";			
		}
		return "error";
	}
}

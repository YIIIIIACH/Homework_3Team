package tw.marc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tw.marc.model.Employee;
import tw.marc.model.EmployeeDao;
import tw.marc.model.Leave;
import tw.marc.model.LeaveDao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Controller
public class PostLeaveController {
	@Autowired
	private EmployeeDao eDao;
	@Autowired
	private LeaveDao lDao;
	
	@PostMapping("/postLeave")
	public String postLeaveProcessor(@RequestParam("empId") String empId, @RequestParam("leaveDate") String leaveDate, 
			@RequestParam("leaveTime")String leaveTime,@RequestParam("leaveReason")String leaveReason ,Model m) throws ParseException {
		System.out.println(empId + "  "+ leaveDate+ " " + leaveTime+" "+leaveReason);
		Employee e = eDao.getEmployeeById(Integer.valueOf(empId));
		Date ld = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(leaveDate+" "+leaveTime);
//		System.out.println(ld);
		lDao.insertLeave(new Leave(Integer.valueOf(empId),e, ld , leaveReason));
		List<Leave> leaves = lDao.getLeaveById(e.getEmployee_id());
		if(leaves !=null) {
			for(Leave l: leaves) {
				System.out.println(l.getLeave_id()+ l.getEmployee().getEmployee_name()+ l.getLeave_datetime().toString());
			}
			m.addAttribute("leaves", leaves);
		}
		return "empLeave";
	}
}

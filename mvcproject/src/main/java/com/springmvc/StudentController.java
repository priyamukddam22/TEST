package com.springmvc;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;





@Controller
public class StudentController {
	@Autowired
	StudentDao studao;
	
	@RequestMapping("/crud")
	public String getRegistrationForm()
	{
		return "StudentForm";
	}
	
	@RequestMapping(value="/saveStudent",method=RequestMethod.POST)
	public String getSave(@ModelAttribute("student") StuModel student)
	{
		studao.save(student);
		return "redirect:/viewstudent";
	}
	
	@RequestMapping("/viewstudent")
	public String getView(Model model)
	{
		List<StuModel> list = studao.getAllStudent();
		model.addAttribute("studentlist",list);
		return "studentview";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id,HttpSession session)
	{
		studao.delete(id);
		session.setAttribute("msg", "<script>alert('Student Deleted Succes!!!')</script>");
		 return "redirect:/viewstudent";
	}

	@RequestMapping("edit/{id}")
	public String getStudentById(@PathVariable int id,Model m)
	{
		StuModel student = studao.getStudentByID(id);
		m.addAttribute("command", student);
		m.addAttribute("student", student);
		return "studentedit";
	}
	
	/*@RequestMapping(value="/update",method=RequestMethod.POST)
	public String getUpdateStudent(@ModelAttribute("student") StuModel student,HttpSession session)
	{
		
		studao.getUpdateStudent(student);
		session.setAttribute("msg1", "<script>alert('Student Updated Successs!!!')</script>");
		return "redirect:/viewstudent";
	}*/
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateEmployee(@ModelAttribute("student") StuModel student,int id){
		studao.getUpdateStudent(student,id);
		return "redirect:/viewstudent";
	}
	
	//
	// login code

		@RequestMapping("/login")
		public String getLogForm() {
			return "Login";
		}

		@RequestMapping(value = "/dologin", method = RequestMethod.POST)
		public String doLogin(@ModelAttribute("log") LoginModel log, HttpSession session) {
			List<StuModel> list = studao.getLogin(log);
			if (list == null) {
				return "Login";
			}

			else {
				session.setAttribute("sesuser", log.getUsername());
				return "redirect:/getEmpdetails";

			}

		}

		@RequestMapping("getEmpdetails")
		public String getEmps(HttpSession session)
		{
			return "home";
		}
	
}

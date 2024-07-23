package equ.cjc.springcollageapplication.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



import equ.cjc.springcollageapplication.Model.Collage;
import equ.cjc.springcollageapplication.serviceI.CollageserviceI;





@Controller
public class HomeController 
{
	
	@Autowired
	CollageserviceI cci;
	
	@RequestMapping("/")
	public String prelogin()
	{
		return "login";
	}
	
	
	@RequestMapping("/openreg")
	public String preRegister()
	{
		return "register";
		
	}
	
	 @RequestMapping("/save")
		public String saveCollage(@ModelAttribute Collage c )
		{
			 cci.saveCollage(c);
			return "login";
		}
	 
	 @RequestMapping("log")
		public String loginStudent(@RequestParam("username")String username,@RequestParam("password")String password,Model m)
		{
			List<Collage> list=cci.logieCollage(username,password);
			if(!list.isEmpty())
			{
				m.addAttribute("data",list);
			return "success" ;
			}
			else 
			{
			return "login";
			
		}
		}
	 @RequestMapping("/paging")
		public String paging(@RequestParam("pageNo")int pageNo,Model m)
		{
			List<Collage> list=cci.pagingCollage(pageNo);
			m.addAttribute("data",list);
			
			return "success";
			
		}
		
		@RequestMapping("/delete")
		public String deleteStudent(@RequestParam("rollno") int rollno,Model m)
		{
			List<Collage> list=cci.deleteStudent(rollno);
			m.addAttribute("data",list);
			return "success";
			
		}
		@RequestMapping("/edit")
		public String editStudent(@RequestParam("rollno") int rollno,Model m)
		{
			Collage s= cci.editStudent(rollno);
			m.addAttribute("stu", s);
			return "edit";
			
		}
		@RequestMapping("/update")
		public String updateStudent(@ModelAttribute Collage c,Model m)
		{
			List<Collage> list=cci.updateCollage(c);
			m.addAttribute("data", list);
			return "success";
			
		
	 
	
	

		}		
}

package equ.cjc.springcollageapplication.Collageserviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import equ.cjc.springcollageapplication.Model.Collage;
import equ.cjc.springcollageapplication.Repositary.CollageRepositary;
import equ.cjc.springcollageapplication.serviceI.CollageserviceI;

public class Collageserviceimpl <Pageable> implements CollageserviceI
{
	@Autowired
     CollageRepositary sr;


	@Override
	public void saveCollage(Collage c) {
		sr.save(c);
		
	}

	@Override
	public List<Collage> logieCollage(String username, String password) {
		if(username.equals("ADMIN") && password.equals("ADMIN"))
		{
			return (List<Collage>)  sr.findAll(PageRequest.of(0, 2)).toList();//change
			
		}
		else {
			return sr.findByUsernameAndPassword(username, password);
			
		}
	}

	@Override
	public List<Collage> pagingCollage(int pageNo) {
		PageRequest pageable =  PageRequest.of(pageNo,2,Sort.by("name").ascending());
		return sr.findAll(pageable).toList();
		
	}

	@Override
	public List<Collage> deleteStudent(int rollno) {
         sr.deleteData(rollno);
		
		return sr.findAll();
		
	}

	@Override
	public Collage editStudent(int rollno) {
		Optional <Collage> op =sr.findByAdministrator(rollno);
		return op.get();
		
	}

	@Override
	public List<Collage> updateCollage(Collage c) {
		sr.UpdateData(c.getAdministrator(),c.getFacultyMember(),c.getStudent());
		return sr.findAll();
		
	}
	

}

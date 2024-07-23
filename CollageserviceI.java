package equ.cjc.springcollageapplication.serviceI;

import java.util.List;


import equ.cjc.springcollageapplication.Model.Collage;

public interface CollageserviceI {

	public void saveCollage(Collage c);

	

	public List<Collage> logieCollage(String username, String password);



	public List<Collage> pagingCollage(int pageNo);



	public List<Collage> deleteStudent(int rollno);



	public Collage editStudent(int rollno);



	public List<Collage> updateCollage(Collage c);

}

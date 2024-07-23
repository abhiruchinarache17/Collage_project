package equ.cjc.springcollageapplication.Repositary;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



import equ.cjc.springcollageapplication.Model.Collage;
import jakarta.transaction.Transactional;



public interface CollageRepositary extends JpaRepository<Collage,String>
{
	
	 public List<Collage> findByUsernameAndPassword(String username, String password);
		
		public List<Collage> findByUsernameOrPassword(String username,String password);
		
		@Transactional
		@Modifying
		@Query(name = "deletedata",value = "delete from Student where rollno=?1")
		public void deleteData(int rollno);
		
		@Query(value = "from Student")
		public List<Collage> getAllData();
                
		@Query(value = "from Student where rollno=?1")
      	public Collage getSingleDta(int rollno);
         
		@Transactional
		@Modifying
		@Query(value = "update Collage set name=:nm,username=:u,password=:p where rollno=:id")
		public void UpdateData(@Param("nm") String name,@Param("u") String username,@Param("p") String password);

		public Optional<Collage> findByAdministrator(int rollno);

		
		
	

}

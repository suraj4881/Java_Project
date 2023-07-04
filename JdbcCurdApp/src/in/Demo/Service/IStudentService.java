package in.Demo.Service;

import in.Demo.Dto.Student;

public interface IStudentService {

	
	//opertion to be implement
		public String addStudent(String sname,Integer sage,String saddress);
		
		public Student searchStudent(Integer sid);
		
		public String  updateStudent(Student student);
		
		public String  deleteStudent(Integer sid);

		
		
}

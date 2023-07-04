package in.Demo.ServiceFactory;

import in.Demo.Service.IStudentService;
import in.Demo.Service.StudentServiceImpl;

   //Abstraction logic of implementation
    public class StudentServiceFactory {

	//make constuctor private to avoid object creation
	private StudentServiceFactory() {

	}

	private static IStudentService studentService = null;

	public static IStudentService getStudentService() 
	{
		
		//singleton pattern code
		if (studentService == null) 
		{
			studentService = new StudentServiceImpl();
		}
		return studentService;
		
	}
 }


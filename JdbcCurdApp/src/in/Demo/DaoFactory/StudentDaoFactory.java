package in.Demo.DaoFactory;

import in.Demo.Persistance.IStudentDao;
import in.Demo.Persistance.StudentDaoImpl;
import in.Demo.Service.IStudentService;
import in.Demo.Service.StudentServiceImpl;


	//Abstraction logic of implementation
    public class StudentDaoFactory {

	//make constuctor private to avoid object creation
	private StudentDaoFactory() {

	}

	private static IStudentDao StudentDao = null;

	public static IStudentDao getStudentDao() 
	{
		
		//singleton pattern code
		if (StudentDao == null) 
		{
			StudentDao = new StudentDaoImpl();
		}
		return StudentDao;
		
	}
		
		

	}



package in.Demo.Service;

import java.io.IOException;

import java.sql.SQLException;

import in.Demo.DaoFactory.StudentDaoFactory;
import in.Demo.Dto.Student;
import in.Demo.Persistance.IStudentDao;


public class StudentServiceImpl implements IStudentService {
      
      
	private IStudentDao stdDao;

	@Override
	public String addStudent(String sname, Integer sage, String saddress) {
		stdDao = StudentDaoFactory.getStudentDao();
		return stdDao.addStudent(sname, sage, saddress);
	}

	@Override
	public Student searchStudent(Integer sid) {
		stdDao = StudentDaoFactory.getStudentDao();
		return stdDao.searchStudent(sid);
	}

	@Override
	public String updateStudent(Student student) {
		stdDao = StudentDaoFactory.getStudentDao();
		return stdDao.updateStudent(student);
	}
	

	@Override
	public String deleteStudent(Integer sid) {
		stdDao = StudentDaoFactory.getStudentDao();
		return stdDao.deleteStudent(sid);
	}

}

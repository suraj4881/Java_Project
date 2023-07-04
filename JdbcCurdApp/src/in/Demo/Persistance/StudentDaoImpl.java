package in.Demo.Persistance;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.Demo.Dto.Student;
import in.Demo.Util.JdbcUtil;

public class StudentDaoImpl implements IStudentDao {


	Connection connection=null;
    PreparedStatement pstmt=null;
    ResultSet rowCount=null;
	private int sid;
    
	@Override
	public String addStudent(String sname, Integer sage, String saddress) {
		String sqlInsertQuery="Insert into student(`name`,`age`,`address`)value(?,?,?)";
		try {
			connection=JdbcUtil.getJdbcConnection();
		
		
		if(connection!=null) {
			
			pstmt=connection.prepareStatement(sqlInsertQuery);
		}
		if(pstmt!=null) {
			pstmt.setString(1, sname);
			pstmt.setInt(2, sage);
			pstmt.setString(3, saddress);
			
		int RowAffected	=pstmt.executeUpdate();
		if(RowAffected==1) {
			
			return "success";
	}
	}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "failure";
	}

	
	
	
	@Override
	public Student searchStudent(Integer sid) {
		
		String sqlSelectQuery = "select id,name,age,address from student where id = ?";
		Student student = null;

		try {
			connection = JdbcUtil.getJdbcConnection();

			if (connection != null)
				pstmt = connection.prepareStatement(sqlSelectQuery);

			if (pstmt != null)
				pstmt.setInt(1, sid);

			if (pstmt != null) {
				rowCount = pstmt.executeQuery();
			}

			if (rowCount != null) {

				if (rowCount.next()) {
					student = new Student();
					
					// copy resultSet data to student object
					student.setSid(rowCount.getInt(1));
					student.setSname(rowCount.getString(2));
					student.setSage(rowCount.getInt(3));
					student.setSaddress(rowCount.getString(4));
					
					return student;
				}

			}

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		}

		return student;
	}
	

	@Override
	public String updateStudent(Student student) {
		String sqlInsertQuery="update student set name=?,age=?,address=? where id=?";
		try {
			connection=JdbcUtil.getJdbcConnection();
		
		
		if(connection!=null) {
			
			pstmt=connection.prepareStatement(sqlInsertQuery);
		}
		if(pstmt!=null) {
			pstmt.setString(1, student.getSname());
			pstmt.setInt(2, student.getSage());
			pstmt.setString(3, student.getSaddress());
			pstmt.setInt(4, student.getSid());
			
		int RowAffected	=pstmt.executeUpdate();
		if(RowAffected==1) {
			
			return "success";
	}
	}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "failure";
	}


	@Override
	public String deleteStudent(Integer sid) {
		
		String sqlDeleteQuery="delete from student where id = ?";
		try {
			connection=JdbcUtil.getJdbcConnection();
		
		
		if(connection!=null) {
			
			pstmt=connection.prepareStatement(sqlDeleteQuery);
		}
		if(pstmt!=null) {
			
			pstmt.setInt(1, sid);
			
			
		int RowAffected	=pstmt.executeUpdate();
		if(RowAffected==1) {
			
			return "success";
	}
		else {
			return "not found";
		}
	}
		} catch (SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "failure";
		}
		return "failure";
	}

	}



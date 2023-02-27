package com.springmvc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;



public class StudentDao {

	JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int save(StuModel student) {
		// TODO Auto-generated method stub
		String sql = "insert into student(firstname,lastname,email,password,phone,gender,city) value('"
				+ student.getFirstname() + "','" + student.getLastname() + "','" + student.getEmail() + "','"
				+ student.getPassword() + "','" + student.getPhone() + "','" + student.getGender() + "','"
				+ student.getCity() + "')";
		return jdbcTemplate.update(sql);
	}

	public List<StuModel> getAllStudent() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from student", new RowMapper<StuModel>() {

			@Override
			public StuModel mapRow(ResultSet rs, int arg1) throws SQLException {
				StuModel student = new StuModel();
				student.setId(rs.getInt(1));
				student.setFirstname(rs.getString(2));
				student.setLastname(rs.getString(3));
				student.setEmail(rs.getString(4));
				student.setPassword(rs.getString(5));
				student.setPhone(rs.getString(6));
				student.setGender(rs.getString(7));
				student.setCity(rs.getString(8));
				return student;
			}

		});

	}

	public int delete(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from student where id='" + id + "'";
		return jdbcTemplate.update(sql);
	}

	public StuModel getStudentByID(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from student where id='" + id + "'";
		return jdbcTemplate.queryForObject(sql, new Object[] {}, new BeanPropertyRowMapper<StuModel>(StuModel.class));
	}

	public int getUpdateStudent(StuModel student, int id) {

		String sql = "update Student set firstname='" + student.getFirstname() + "',lastname='" + student.getLastname()
				+ "',email='" + student.getEmail() + "',password='" + student.getPassword() + "',phone='"
				+ student.getPhone() + "',gender='" + student.getGender() + "',city='" + student.getCity()
				+ "' where id='" + id + "'";
		return jdbcTemplate.update(sql);
	}

	// login code

		public List<StuModel> getLogin(LoginModel log) {
			// TODO Auto-generated method stub
			String sql = "select * from student_table where firstname='" + log.getUsername() + "' and password='"
					+ log.getPassword() + "'";
			return jdbcTemplate.query(sql, new RowMapper<StuModel>() {

				@Override
				public StuModel mapRow(ResultSet rs, int arg1) throws SQLException {
					// TODO Auto-generated method stub
					StuModel s=new StuModel();
					s.setFirstname(rs.getString(2));
					s.setPassword(rs.getString(5));
					return s;
				}
			});
		}
	
}

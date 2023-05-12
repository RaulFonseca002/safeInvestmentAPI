package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Professor;


public class ProfessorDAO extends DAO {
	
	public ProfessorDAO() {
		super();
		conectar();
	}

	public void finalize() {
		close();
	}
	
	public boolean insert(Professor professor) {

		boolean status = false;

		try {  

			Statement st = conexao.createStatement();

			String sql = "INSERT INTO \"Professor\" (user_code, professor_code, avg_grade, stamp, full_name)"
				       + " VALUES ('"
				       + professor.getUserCode() + "', '" 
				       + professor.getProfessorCode() + "', '"
				       + professor.getAvgGrade() + "', '"
				       + professor.getStamp() + "', '"
				       + professor.getFullName() + "');";
			System.out.println(sql);

			st.executeUpdate(sql);
			st.close();
			status = true;

		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}

		return status;
	}
	
	public Professor get(int codigo) {
		Professor professor = null;
		
		try {

			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM Professor WHERE codigo=" + codigo;
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	

	        if(rs.next()){            
	        	professor = new Professor(  rs.getInt("userCode"), 
                                            rs.getInt("professorCode"), 
                                            rs.getFloat("avgGrade"), 
                                            rs.getString("stamp"), 
                                            rs.getString("fullName"));
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return professor;
	}
	
	
	public List<Professor> get() {
		return get("");
	}

	public List<Professor> getOrderByCodigo() {
		return get("professorCode");		
	}
	
	private List<Professor> get(String orderBy) {	
	
		List<Professor> xs = new ArrayList<Professor>();
		
		try {

			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM " + "Professor" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);

	        while(rs.next()) {	       

	        	Professor Professor = new Professor(    rs.getInt("userCode"), 
                                                        rs.getInt("professorCode"), 
                                                        rs.getFloat("avgGrade"), 
                                                        rs.getString("stamp"), 
                                                        rs.getString("fullName"));
	            xs.add(Professor);
	        }
	        st.close();

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return xs;
	}
	
	public boolean update(Professor professor) {

		boolean status = false;

		try {  

			Statement st = conexao.createStatement();
			String sql =
			        "UPDATE Professor SET user_code = '" +
			        professor.getUserCode() +
			        "', professor_code = '" +
			        professor.getProfessorCode() +
			        "', avg_grade = '" +
			        professor.getAvgGrade() +
			        "', stamp = '" +
			        professor.getStamp() +
			        "', full_name = '" +
			        professor.getFullName() +
			        "'" +
			        " WHERE codigo = " +
			        professor.getProfessorCode();
			System.out.println(sql);

			st.executeUpdate(sql);
			st.close();
			status = true;

		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean delete(int codigo) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "DELETE FROM Professor WHERE codigo = " + codigo;
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public Professor buscaProfessor(String name) {

		Professor professor = null;
		
		try {

			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM \"Professor\" WHERE full_name='" + name + "\'";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);

	        if(rs.next()){            
	        	professor = new Professor(  rs.getInt("userCode"), 
                                            rs.getInt("professorCode"), 
                                            rs.getFloat("avgGrade"), 
                                            rs.getString("stamp"), 
                                            rs.getString("fullName"));
	        }
	        st.close();

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return professor;
	}
}
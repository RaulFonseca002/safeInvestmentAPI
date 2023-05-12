package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Class;


public class ClassDAO extends DAO {
	
	public ClassDAO() {
		super();
		conectar();
	}

	public void finalize() {
		close();
	}
	
	public boolean insert(Class db_Class) {

		boolean status = false;

		try {  

			Statement st = conexao.createStatement();

			String sql = "INSERT INTO \"Class\" (code, name, grade, price, time, area, professor)"
				       + " VALUES ('"
				       + db_Class.getCode() + "', '" 
				       + db_Class.getName() + "', '"
				       + db_Class.getGrade() + "', '"
				       + db_Class.getPrice() + "', '"
                       + db_Class.getTime() + "', '"
                       + db_Class.getArea() + "', '"
				       + db_Class.getProfessor() + "');";
			System.out.println(sql);

			st.executeUpdate(sql);
			st.close();
			status = true;

		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}

		return status;
	}
	
	public Class get(int codigo) {
		Class db_Class = null;
		
		try {

			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM Class WHERE codigo=" + codigo;
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	

	        if(rs.next()){            
	        	db_Class = new Class(   rs.getInt("code"), 
                                        rs.getString("name"), 
                                        rs.getFloat("grade"),
                                        rs.getFloat("price"), 
                                        rs.getString("currency"), 
                                        rs.getString("time"),
                                        rs.getInt("professor"),
                                        rs.getString("area"));
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return db_Class;
	}
	
	
	public List<Class> get() {
		return get("");
	}

	public List<Class> getOrderByCodigo() {
		return get("ClassCode");		
	}
	
	private List<Class> get(String orderBy) {	
	
		List<Class> xs = new ArrayList<Class>();
		
		try {

			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM " + "Class" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);

	        while(rs.next()) {	       

	        	Class db_Class = new Class(rs.getInt("code"), 
                                        rs.getString("name"), 
                                        rs.getFloat("grade"),
                                        rs.getFloat("price"), 
                                        rs.getString("currency"), 
                                        rs.getString("time"),
                                        rs.getInt("professor"),
                                        rs.getString("area"));
	            xs.add(db_Class);
	        }
	        st.close();

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return xs;
	}
	
	public boolean update(Class db_Class) {

		boolean status = false;

		try {  

			Statement st = conexao.createStatement();
			String sql =
			        "UPDATE Class SET idCode = '" +
			        db_Class.getCode() +
			        "', name = '" +
			        db_Class.getName() +
			        "', grade = '" +
			        db_Class.getGrade() +
			        "', price = '" +
			        db_Class.getPrice() +
			        "', time = '" +
			        db_Class.getTime() +
			        "'" +
                    "', area = '" +
			        db_Class.getArea() +
			        "', professor = '" +
			        db_Class.getProfessor() +
			        " WHERE codigo = " +
			        db_Class.getCode();
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
			String sql = "DELETE FROM Class WHERE codigo = " + codigo;
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public Class buscaClass(String name) {

		Class db_Class = null;
		
		try {

			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM \"Class\" WHERE full_name='" + name + "\'";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);

	        if(rs.next()){            
	        	db_Class = new Class(  rs.getInt("code"), 
                                    rs.getString("name"), 
                                    rs.getFloat("grade"),
                                    rs.getFloat("price"), 
                                    rs.getString("currency"), 
                                    rs.getString("time"),
                                    rs.getInt("professor"),
                                    rs.getString("area"));
	        }
	        st.close();

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return db_Class;
	}
}
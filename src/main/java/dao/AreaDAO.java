package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Area;


public class AreaDAO extends DAO {
	
	public AreaDAO() {
		super();
		conectar();
	}

	public void finalize() {
		close();
	}
	
	public boolean insert(Area area) {

		boolean status = false;

		try {  

			Statement st = conexao.createStatement();

			String sql = "INSERT INTO \"Area\" (code, acronym, name, return_type, return_security, return_quality, super_Area)"
				       + " VALUES ('"
                       + area.getCode() + "', '" 
				       + area.getAcronym() + "', '" 
				       + area.getName() + "', '"
                       + area.returns.getType() + "', '" 
				       + area.returns.getSecurity() + "', '"
                       + area.returns.getTime() + "', '"
				       + area.returns.getQuality() + "', '"
				       + area.getSuperArea() + "');";
			System.out.println(sql);

			st.executeUpdate(sql);
			st.close();
			status = true;

		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}

		return status;
	}
	
	public Area get(int code) {
		Area area = null;
		
		try {

			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM Area WHERE codigo=" + code;
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	

	        if(rs.next()){            
	        	area = new Area(rs.getInt("code"), 
                                rs.getString("acronym"), 
                                rs.getString("name"), 
                                rs.getString("returns"),
                                rs.getString("superAreaAcronym"));
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return area;
	}
	
	
	public List<Area> get() {
		return get("");
	}

	public List<Area> getOrderByCodigo() {
		return get("AreaCode");		
	}
	
	private List<Area> get(String orderBy) {	
	
		List<Area> xs = new ArrayList<Area>();
		
		try {

			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM " + "Area" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);

	        while(rs.next()) {	       

	        	Area area = new Area(rs.getInt("code"), 
                                rs.getString("acronym"), 
                                rs.getString("name"), 
                                rs.getString("returns"),
                                rs.getString("superAreaAcronym"));
	            xs.add(area);
	        }
	        st.close();

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return xs;
	}
	
	public boolean update(Area area) {

		boolean status = false;

		try {  

			Statement st = conexao.createStatement();
			String sql =
			        "UPDATE Area SET code = '" +
			        area.getCode() +
			        "', acronym = '" +
			        area.getAcronym() +
			        "', name = '" +
			        area.getName() +
			        "', return_type = '" +
			        area.returns.getType() +
                    "', return_time = '" +
			        area.returns.getTime() +
                    "', return_security = '" +
			        area.returns.getSecurity() +
                    "', return_quality = '" +
			        area.returns.getQuality() +
			        "', super_Area = '" +
			        area.getSuperArea() +
			        "'" +
			        " WHERE codigo = " +
			        area.getCode();
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
			String sql = "DELETE FROM Area WHERE codigo = " + codigo;
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public Area buscaArea(String acronym) {

		Area area = null;
		
		try {

			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM \"Area\" WHERE acronym='" + acronym + "\'";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);

	        if(rs.next()){            
	        	area = new Area(rs.getInt("code"), 
                                rs.getString("acronym"), 
                                rs.getString("name"), 
                                rs.getString("returns"),
                                rs.getString("superAreaAcronym"));
	        }
	        st.close();

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return area;
	}
}
package testeJdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.mysql.jdbc.Statement;

import db.DB;

public class Insert {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement st = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement(
					"INSERT INTO seller " 
					+ "(Name, Email, BirthDate, BaseSalary, departmentId) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, "Joana Dark");
			st.setString(2, "joana@gmail.com");
			st.setDate(3, new java.sql.Date(sdf.parse("28/10/1984").getTime()));
			st.setDouble(4, 14000.00);
			st.setInt(5, 1);
			
			int rowsAffected = st.executeUpdate();
			
			if(rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				while(rs.next()) {
					int id = rs.getInt(1);
					System.out.println("Done! ID: " + id);
				}
			}else {
				System.out.println("No Rows affected.");
			}
			
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeStatment(st);
			DB.closeConnection();
		}

	}

}

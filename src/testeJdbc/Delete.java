package testeJdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import db.DbIntegrityException;

public class Delete {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
			st = conn.prepareStatement(""
					+ " DELETE FROM department "
					+ " WHERE id = ?");
			
			st.setInt(1, 4);
			int rowsAffected = st.executeUpdate();
			System.out.println("Rows affected: " + rowsAffected);
			
		} catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		}finally {
			DB.closeStatment(st);
			DB.closeConnection();
		}

	}

}

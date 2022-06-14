package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.DB;
import jdbc.DbException;

public class Transaction {

	public static void main(String[] args) {

		Connection conn = null;
		Statement st = null;

		try {
			conn = DB.getConnection();
			conn.setAutoCommit(false);
			st = conn.createStatement();
			int rows1 = st.executeUpdate("UPDATE seller SET baseSalary = 8000 WHERE DepartmentId = 2");
			int rows2 = st.executeUpdate("UPDATE seller SET baseSalary = 7000 WHERE DepartmentId = 3");

			conn.commit();
			System.out.println("Done! Rows affected:" + rows1);
			System.out.println("Done! Rows affected:" + rows2);

		} catch (SQLException e) {
			try {
				conn.rollback();
				throw new DbException("Transaction rolled back!! Caused by " + e.getMessage());
			} catch (SQLException e1) {
				throw new DbException("Error trying to rollback!! Caused by " + e.getMessage());
			}
		} finally {
			DB.closeStatment(st);
			DB.closeConnection();
		}

	}

}

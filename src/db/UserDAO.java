package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import bean.User;

/**
 * UserDAO
 * 
 * @author kazushi47
 *
 */
public class UserDAO {

	private static Connection createConnection() {
		Connection con;
		
		String jdbcDriver = null, dbUri = null, dbUser = null, dbPassword = null;	
		try {
			ResourceBundle rb = ResourceBundle.getBundle("dbInfo");
			jdbcDriver = rb.getString("jdbcDriver");
			dbUri = rb.getString("dbUri");
			dbUser = rb.getString("dbUser");
			dbPassword = rb.getString("dbPassword");
		} catch (MissingResourceException e) {
			throw new RuntimeException("データベース接続情報が見つかりません。", e);
		}
		
		try {
			Class.forName(jdbcDriver);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("指定されたJDBCドライバーが見つかりません。", e);
		}
		
		try {
			con = DriverManager.getConnection(dbUri, dbUser, dbPassword);			
		} catch (SQLException e) {
			throw new RuntimeException("データベース接続エラーが発生しました。", e);
		}
		
		return con;
	}
	
	/**
	 * 全件検索
	 * @return ArrayList<User>
	 * @throws Exception
	 */
	public ArrayList<User> findAll() {
		ArrayList<User> list = new ArrayList<>();
		
		try (
				Connection con = createConnection();
				PreparedStatement ps = con.prepareStatement("select * from users u inner join roles r on u.role_number = r.role_number");
				ResultSet rs = ps.executeQuery()
		) {
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setRole_number(rs.getInt("role_number"));
				user.setRole_name(rs.getString("role_name"));
				user.setLogin_status(rs.getInt("login_status"));
				user.setLast_login_time(rs.getDate("last_login_time"));
				user.setEmail(rs.getString("email"));
				user.setFull_name(rs.getString("full_name"));
				list.add(user);
			}
		} catch (Exception e) {
			throw new RuntimeException("SQLエラーが発生しました。", e);
		}
		
		return list;
	}
	
}

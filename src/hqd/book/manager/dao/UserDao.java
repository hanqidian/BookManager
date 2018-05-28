package hqd.book.manager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hqd.book.manager.model.User;

/**
 * 用户Dao类
 * @author hqd
 *
 */
public class UserDao {

	/**
	 * 登录验证
	 * @param conn
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	public User login(Connection conn,User user) throws SQLException {
		
		User resultUser = null;
		String sql = "select * from m_user where userName=? and password=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, user.getUserName());
		ps.setString(2, user.getPassword());
		ResultSet rs = ps.executeQuery();
		if(rs != null && rs.next()) {
			resultUser = new User();
			resultUser.setId(rs.getString("id"));
			resultUser.setUserName(rs.getString("userName"));
			resultUser.setPassword(rs.getString("password"));
		}
		return resultUser;
		
	}
	
}

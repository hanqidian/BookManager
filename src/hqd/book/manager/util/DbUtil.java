package hqd.book.manager.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库工具类
 * @author hqd
 *
 */
public class DbUtil {

	private String dbUrl = "jdbc:oracle:thin:@localhost:1521:orcl";	//数据库连接地址
	private String dbUserName = "BOOK_MANAGER";	//用户名
	private String dbPassword = "123";	//密码
	private String jdbcName="oracle.jdbc.driver.OracleDriver";	//驱动名称
	
	/**
	 * 获取数据库连接
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Connection getConn() throws ClassNotFoundException, SQLException {
		Class.forName(jdbcName);
		Connection conn = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
		return conn;
	}
	
	/**
	 * 关闭数据库连接
	 * Connection占用内存较大，必须关闭；ResultSet占用内存较小，且可以自动回收，可以不关闭
	 * @param conn
	 * @throws SQLException 
	 */
	public void closeConn(Connection conn) throws SQLException {
		if(conn != null) {
			conn.close();
		}
	}
	
}

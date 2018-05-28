package hqd.book.manager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hqd.book.manager.model.BookType;
import hqd.book.manager.util.StringUtil;
import hqd.book.manager.util.UUIDUtil;

/**
 * 图书类别Dao类
 * @author hqd
 *
 */
public class BookTypeDao {

	/**
	 * 图书类别添加
	 * @param conn
	 * @param bookType
	 * @return
	 * @throws SQLException 
	 */
	public int add(Connection conn,BookType bookType) throws SQLException {
		
		String sql = "insert into m_bookType values(?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, UUIDUtil.getUUID());
		ps.setString(2, bookType.getBookTypeName());
		ps.setString(3, bookType.getBookTypeDesc());
		return ps.executeUpdate();
		
	}
	
	/**
	 * 查询所有图书类别集合
	 * @param conn
	 * @param bookType
	 * @return
	 * @throws SQLException 
	 */
	public ResultSet list(Connection conn,BookType bookType) throws SQLException {
		
		StringBuffer sb = new StringBuffer("select * from M_BookType");
		if(StringUtil.isNotEmpty(bookType.getBookTypeName())) {
			sb.append(" and bookTypeName like '%"+bookType.getBookTypeName()+"%'");
		}
		PreparedStatement ps = conn.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return ps.executeQuery();
		
	}
	
	/**
	 * 删除图书类别
	 * @param conn
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public int delete(Connection conn,String id) throws SQLException {
		
		String sql = "delete from m_bookType where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		return ps.executeUpdate();
		
	}
	
	/**
	 * 更新图书类别
	 * @param conn
	 * @param bookType
	 * @return
	 * @throws SQLException
	 */
	public int update(Connection conn,BookType bookType) throws SQLException {
		
		String sql = "update m_bookType set bookTypeName=?,bookTypeDesc=? where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, bookType.getBookTypeName());
		ps.setString(2, bookType.getBookTypeDesc());
		ps.setString(3, bookType.getId());
		return ps.executeUpdate();
		
	}
	
}

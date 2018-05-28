package hqd.book.manager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import hqd.book.manager.model.Book;
import hqd.book.manager.util.StringUtil;
import hqd.book.manager.util.UUIDUtil;

/**
 * 图书Dao类
 * @author hqd
 *
 */
public class BookDao {

	/**
	 * 图书添加
	 * @param conn
	 * @param book
	 * @return
	 * @throws SQLException 
	 */
	public int add(Connection conn,Book book) throws SQLException {
		
		String sql = "insert into m_book values(?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, UUIDUtil.getUUID());
		ps.setString(2, book.getBookName());
		ps.setString(3, book.getAuthor());
		ps.setString(4, book.getSex());
		ps.setFloat(5, book.getPrice());
		ps.setString(6, book.getBookTypeId());
		ps.setString(7, book.getBookDesc());
		return ps.executeUpdate();
		
	}
	
	/**
	 * 图书信息查询
	 * @param conn
	 * @param book
	 * @return
	 * @throws SQLException 
	 */
	public ResultSet list(Connection conn,Book book) throws SQLException {
		
		StringBuffer sb = new StringBuffer("select * from m_book b,m_bookType bt where b.bookTypeId=bt.id");
		if(StringUtil.isNotEmpty(book.getBookName())) {
			sb.append(" and b.bookName like '%"+book.getBookName()+"%'");
		}
		if(StringUtil.isNotEmpty(book.getAuthor())) {
			sb.append(" and b.author like '%"+book.getAuthor()+"%' ");
		}
		if(book.getBookTypeId() != null && !"".equals(book.getBookTypeId())) {
			sb.append(" and b.bookTypeId='"+book.getBookTypeId()+"' ");
		}
		PreparedStatement ps = conn.prepareStatement(sb.toString());
		return ps.executeQuery();
		
	}
	
	/**
	 * 图书信息删除
	 * @param conn
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public int delete(Connection conn,String id) throws SQLException {
		
		String sql = "delete from m_book where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		return ps.executeUpdate();
		
	}
	
	/**
	 * 图书信息修改
	 * @param conn
	 * @param book
	 * @return
	 * @throws SQLException 
	 */
	public int update(Connection conn,Book book) throws SQLException {
		
		String sql = "update m_book set bookName=?,author=?,sex=?,price=?,bookDesc=?,bookTypeId=? where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, book.getBookName());
		ps.setString(2, book.getAuthor());
		ps.setString(3, book.getSex());
		ps.setFloat(4, book.getPrice());
		ps.setString(5, book.getBookDesc());
		ps.setString(6, book.getBookTypeId());
		ps.setString(7, book.getId());
		return ps.executeUpdate();
		
	}
	
	/**
	 * 指定图书类别下是否存在图书
	 * @param conn
	 * @param bookTypeId
	 * @return
	 * @throws SQLException 
	 */
	public boolean existBookByBookTypeId(Connection conn,String bookTypeId) throws SQLException {
		
		String sql = "select * from m_book where bookTypeId=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, bookTypeId);
		ResultSet rs = ps.executeQuery();
		return rs.next();
		
	}
	
}

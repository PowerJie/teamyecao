package com.yecao.mapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

import com.yecao.Constance;
import com.yecao.bean.Subject;
import com.yecao.bean.User;

/**
 * 一个主题的相关db操作
 * @author dujh
 *
 */
public class SubjectMapper {
	
	private JdbcTemplate t = null;

	public static final String ADD_SUBJECT = "INSERT INTO subject(title,content,userid,pic,createtime)VALUES(?,?,?,?,?)";
	
	public static final String DEL_SUBJECT = "DELETE FROM subject where id=?";
	
	public static final String UPDATE_SUBJECT = "UPDATE subject SET content=? where id=?";
	
	public static final String SELECT_ONE_SUBJECT = "SELECT * FROM subject where id='";
	
	public static final String SELECT_SUBJECT = "SELECT * FROM subject LIMIT ";

	public void addSubject(final Subject subject){
		t.update(ADD_SUBJECT, new PreparedStatementSetter(){

			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, subject.getTitle());
				ps.setString(2, subject.getContent());
				ps.setString(3, subject.getUser().getId());
				ps.setBinaryStream(4, subject.getPic().getBinaryStream());
				ps.setString(5, subject.getCreateTime());
			}});
	}
	
	public void delete(final String id){
		t.update(DEL_SUBJECT, new PreparedStatementSetter(){

			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, id);
			}});
	}
	
	public void modify(final String id,final String content){
		t.update(UPDATE_SUBJECT, new PreparedStatementSetter(){

			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, content);
				ps.setString(2, id);
			}});
	}
	public Subject selectOne(String id){
		return t.queryForObject(SELECT_ONE_SUBJECT+id+"'", new RowMapper<Subject>() {

			public Subject mapRow(ResultSet rs, int arg1) throws SQLException {
				Subject subject=new Subject();
				subject.setTitle(rs.getString("title"));
				subject.setContent(rs.getString("content"));
				subject.setPic(rs.getBlob("pic"));
				subject.setCreateTime(rs.getString("email"));
				subject.setCreateTime(rs.getString("createtime"));
				subject.setUserId(rs.getString("userid"));
				return subject;
			}
		});
	}
	public List<Subject> getSubjects(int page){
		//分页
		String sql=SELECT_SUBJECT+page+" "+Constance.SUBJECT_PAGE_SIZE;
		return t.query(sql,new RowMapper() {

			public Object mapRow(ResultSet rs, int arg1) throws SQLException {
				Subject subject=new Subject();
				subject.setTitle(rs.getString("title"));
				subject.setContent(rs.getString("content"));
				subject.setPic(rs.getBlob("pic"));
				subject.setCreateTime(rs.getString("email"));
				subject.setCreateTime(rs.getString("createtime"));
				subject.setUserId(rs.getString("userid"));
				return subject;
			}
		});
		
	}

	public JdbcTemplate getT() {
		return t;
	}

	public void setT(JdbcTemplate t) {
		this.t = t;
	}
	
	
}

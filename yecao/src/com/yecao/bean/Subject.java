package com.yecao.bean;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

public class Subject {

	private String id;
	private String title;
	private String content;
	private User user;
	private String userId;
	private Blob pic;
	
	private String createTime;
	private List<Comment> comments=new ArrayList<Comment>();
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Blob getPic() {
		return pic;
	}
	public void setPic(Blob pic) {
		this.pic = pic;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	
	
}

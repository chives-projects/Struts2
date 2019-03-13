package manage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Comment;
import bean.Titles;
import bean.Users;

public class DAO {
	public DbManager dbManager;
	public DAO(){
		dbManager=new DbManager("test","csc","123");		
	}
	
	public List selectAllUsers(){
		List list=new ArrayList();
		String sqlString="select * from login";
		ResultSet resultSet=dbManager.executequery(sqlString);
		try {
			while(resultSet.next()){
				Users users=new Users();
				users.setId(resultSet.getInt("id"));
				users.setUserName(resultSet.getString("userName"));
				users.setPassword(resultSet.getString("password"));
				list.add(users);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List selectTitles(){
		List list=new ArrayList();
		String sqlString="select * from titles ";
		
		ResultSet resultSet=dbManager.executequery(sqlString);
		try {
			while(resultSet.next()){
				Titles titles=new Titles();
				titles.setId(resultSet.getInt("id"));
				titles.setUserName(resultSet.getString("userName"));
				titles.setTitle(resultSet.getString("title"));
				titles.setContent(resultSet.getString("content"));
				list.add(titles);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List selectTitlesByUserName(String userName){
		List list=new ArrayList();
		String sqlString="select * from titles where userName='"+userName+"'";
		ResultSet resultSet=dbManager.executequery(sqlString);
		try {
			while(resultSet.next()){
				Titles titles=new Titles();
				titles.setId(resultSet.getInt("id"));
				titles.setUserName(resultSet.getString("userName"));
				titles.setTitle(resultSet.getString("title"));
				titles.setContent(resultSet.getString("content"));
				list.add(titles);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}	
	
	public List selectTitlesId(String userName,String title){
		Titles titles=new Titles();
		List list=new ArrayList();
		String sqlString="select * from titles where userName='"+userName+"' and title='"+title+"'";
		ResultSet resultSet=dbManager.executequery(sqlString);
		try {
			while(resultSet.next()){
				titles.setId(resultSet.getInt("id"));
				titles.setUserName(resultSet.getString("userName"));
				titles.setTitle(resultSet.getString("title"));
				titles.setContent(resultSet.getString("content"));
				String idString=String.valueOf(titles.getId());
				list.add(idString);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}	
	
	public List selectComment(String userName1,String title){
		List list=new ArrayList();
		String sqlString="select * from comment where userName1='"+userName1+"' and title='"+title+"'";
	
		ResultSet resultSet=dbManager.executequery(sqlString);
		try {
			while(resultSet.next()){
				Comment comment=new Comment();
				comment.setUserName(resultSet.getString("userName"));
				comment.setUserName1(resultSet.getString("userName1"));
				comment.setComment(resultSet.getString("comment"));
				list.add(comment);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public Titles selectContentByTitleAndUserName(String title,String userName){
		String sqlString="select * from titles where title='"+title+"' and userName='"+userName+"'";
		Titles titles=new Titles();
		ResultSet resultSet=dbManager.executequery(sqlString);
		try {
			while(resultSet.next()){
				titles=new Titles(resultSet.getInt("id"),resultSet.getString("userName"),resultSet.getString("title"),resultSet.getString("content"));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return titles;
	}
	
	public  boolean insertUsers(Users users){
		String sqlString="insert into login values('"+users.getId()+"','"+users.getUserName()+"','"+users.getPassword()+"')";
		int result=dbManager.executeNoQuery(sqlString);
		return result > 0 ? true : false;
	}
	public  boolean insertTitles(Titles titles){
		String sqlString="insert into titles values('"+titles.getId()+"','"+titles.getUserName()+"','"+titles.getTitle()+"','"+titles.getContent()+"')";
		int result=dbManager.executeNoQuery(sqlString);
		return result > 0 ? true : false;
	}
	public  boolean insertComment(Comment comment){
		String sqlString="insert into comment values('"+comment.getUserName()+"','"+comment.getUserName1()+"','"+comment.getTitle()+"','"+comment.getComment()+"')";
		int result=dbManager.executeNoQuery(sqlString);
		return result > 0 ? true : false;
	}
	
	public boolean deleteById(Users users){
		String sqlString="delete from login where id="+users.getId();
		int result=dbManager.executeNoQuery(sqlString);
		return result>0?true:false;
	}
	
	public boolean updateById(Users users){
		String sqlString="update login set username="+users.getUserName()+",password="+users.getPassword();
		int result=dbManager.executeNoQuery(sqlString);
		return result>0?true:false;
	}
	
	public boolean updateTitlesByUserName(Titles titles){
		String sqlString="update titles set title='"+titles.getTitle()+"',content='"+titles.getContent()+"' where id='"+titles.getId()+"'";
		int result=dbManager.executeNoQuery(sqlString);
		return result>0?true:false;
	}
	
}


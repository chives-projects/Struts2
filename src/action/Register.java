package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import manage.DAO;
import bean.Users;

import com.opensymphony.xwork2.ActionSupport;

public class Register extends ActionSupport{
	public String execute() {
		HttpServletRequest request = ServletActionContext.getRequest();
		if(request.getParameter("password1")==null){
			System.out.println("password is null");
		}
		else{
		 if(request.getParameter("password1").equals(request.getParameter("password2"))){ 
			 DAO dao=new DAO();
			 Users users=new Users();
			 List list=dao.selectAllUsers();
			 System.out.println("select");
				for(int i=0;i<list.size();i++){
					 users=(Users)(list.get(i));
					if(users.getUserName().equals(request.getParameter("userName"))){
						//response.sendRedirect("../register.jsp");
						return "failed";
					}
				}
			 Users user=new Users(users.getId()+1,request.getParameter("userName"),request.getParameter("password1"));
			 dao.insertUsers(user);
			 System.out.println("insert");
			 dao.dbManager.stop();
			 //response.sendRedirect("../login.jsp");
			 return "success";
		   } 
		   else{
			 System.out.println("NOregister");
			// response.sendRedirect("../register.jsp");
			 return "failed";
 
		   } 
		}
		return null;
	}
	
	private String userName;
	private String password1;
	private String password2;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	

}

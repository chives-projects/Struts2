package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import manage.DAO;
import bean.Users;

import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport{
	public String execute() {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().setAttribute("userName", userName);
		DAO dao = new DAO();
		int i;
		List list = dao.selectAllUsers();
		dao.dbManager.stop();
		for (i = 0; i < list.size(); i++) {
			Users users = (Users) (list.get(i));
			if (userName.equals(users.getUserName())) {
				if (password.equals(users.getPassword())) {				
					break;
				}
			}
			System.out.println(users.getUserName());
			System.out.println(users.getPassword());
		}
		if (i >= list.size()) {
			System.out.println("Invalid userName or password");
			return "failed";
		}
		System.out.println("dologin1");
		return "success";
		}
	private String userName;
	private String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
  
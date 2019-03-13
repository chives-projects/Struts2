package action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import manage.DAO;
import bean.Titles;

import com.opensymphony.xwork2.ActionSupport;

public class LookTitles extends ActionSupport{
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		DAO dao = new DAO(); 
		List list = dao.selectTitles();
		List userNameList=new ArrayList();
		List titlesList=new ArrayList();
		for(int i=0;i<list.size();i++){ 
				Titles titles=(Titles)(list.get(i)); 
				userNameList.add(titles.getUserName());
				titlesList.add(titles.getTitle());
				
			} 
		request.getSession().setAttribute("userNameList", userNameList);
		request.getSession().setAttribute("titlesList", titlesList);
			dao.dbManager.stop();
		
		return "success";
		
	}

}

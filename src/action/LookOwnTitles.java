package action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import manage.DAO;
import bean.Titles;

import com.opensymphony.xwork2.ActionSupport;

public class LookOwnTitles extends ActionSupport {
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		DAO dao=new DAO();
		List list=new ArrayList();
		String userName=(String) request.getSession().getAttribute("userName");
		list=dao.selectTitlesByUserName(userName);
		List contentList=new ArrayList();
		List titlesList=new ArrayList();
		for(int i=0;i<list.size();i++){ 
				Titles titles=(Titles)(list.get(i)); 
				System.out.println(i+" "+list.size()); 
				System.out.print(titles.getId()+" "); 
				System.out.print(titles.getUserName()+" "); 
				System.out.print(titles.getTitle()+" "); 
				System.out.println(titles.getContent()); 
				contentList.add(titles.getContent());
				titlesList.add(titles.getTitle());
				
			} 
		
		request.getSession().setAttribute("contentList", contentList);
		request.getSession().setAttribute("titlesList", titlesList);
			dao.dbManager.stop();
			
		return "success";
	}

}

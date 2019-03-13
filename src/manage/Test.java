package manage;

import java.util.List;

import manage.DAO;
import bean.Titles;
import bean.Users;

public class Test {
	public static void main(String[] args){
		DAO dao=new DAO();
		List list=dao.selectAllUsers();
		for(int i=0;i<list.size();i++){
			Users users=(Users)(list.get(i));
			System.out.print(users.getUserName()+"  ");
			System.out.println(users.getPassword());
		}
		String userName="aaa";
		System.out.println(userName);
	List list1 = dao.selectTitlesId("aaa", "Monday");
	for(int i=0;i<list1.size();i++){
		System.out.println(list1.get(i));
	}

	}

}

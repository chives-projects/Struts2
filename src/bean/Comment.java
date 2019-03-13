package bean;

public class Comment {
	//userName为发表评论的人（登陆人）
	//userName1为发表主题的人
	private String userName;
	private String userName1;
	private String comment;
	private String title;
	

	public Comment(){
		
	}
public Comment(String userName,String userName1,String comment,String title){
	this.userName=userName;
	this.userName1=userName1;
	this.comment=comment;
	this.title=title;
		
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserName1() {
		return userName1;
	}
	public void setUserName1(String userName1) {
		this.userName1 = userName1;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	

}

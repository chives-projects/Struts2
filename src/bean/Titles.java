package bean;

public class Titles {
	private int id;
	private String userName;
	private String title;
	private String content;
	
	public Titles(){
		
	}
	public Titles(int id,String userName,String title,String content){
		this.id=id;
		this.userName=userName;
		this.title=title;
		this.content=content;
	}
	public Titles(String userName,String title,String content){
		this.userName=userName;
		this.title=title;
		this.content=content;
	}
	public Titles(String title,String content){
		this.title=title;
		this.content=content;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	
	

}

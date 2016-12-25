package entity;

public class Comment {

	private int id;
	private int articleid;
	private int uesrid;
	private String content;
	private String date;//时间戳问题！！！
	
	public Comment()
	{
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getArticleid() {
		return articleid;
	}

	public void setArticleid(int articleid) {
		this.articleid = articleid;
	}

	public int getUesrid() {
		return uesrid;
	}

	public void setUesrid(int uesrid) {
		this.uesrid = uesrid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
}

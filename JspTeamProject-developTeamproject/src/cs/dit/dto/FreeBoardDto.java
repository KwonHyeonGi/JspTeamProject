package cs.dit.dto;

public class FreeBoardDto {

	private String id;
	private String title;
	private String textarea;
	private String date;
	
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
	public String getTextarea() {
		return textarea;
	}
	public void setTextarea(String textarea) {
		this.textarea = textarea;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public FreeBoardDto() {}
	public FreeBoardDto(String textarea,String date,String title) {
		this.textarea = textarea;
		this.date = date;
		this.title = title;
	}	
	public FreeBoardDto(String title,String id, String textarea, String date) {
		this.title = title;
		this.id = id;
		this.textarea = textarea;
		this.date = date;
	}


}

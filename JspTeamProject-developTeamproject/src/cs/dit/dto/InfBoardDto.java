package cs.dit.dto;

public class InfBoardDto {

	private String title;
	private String textarea;
	private String filename;
	private String id;
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
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public InfBoardDto() {}	
	public InfBoardDto(String textarea, String date ,String filename,String title) {
		this.textarea = textarea;
		this.date = date;
		this.filename = filename;
		this.title = title;
	}
	public InfBoardDto(String title,String id, String textarea, String date ,String filename) {
		this.title = title;
		this.id = id;
		this.textarea = textarea;
		this.date = date;
		this.filename = filename;
	}


}

package cs.dit.dto;

public class FreeBoardDto {
	private String id;
	private String date;
	private String title;
	private String txtarea;
	private int viewcount;
	
	/**
	 * @return the viewcount
	 */
	public int getViewcount() {
		return viewcount;
	}
	/**
	 * @param viewcount the viewcount to set
	 */
	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the txtarea
	 */
	public String getTxtarea() {
		return txtarea;
	}
	/**
	 * @param txtarea the txtarea to set
	 */
	public void setTxtarea(String txtarea) {
		this.txtarea = txtarea;
	}
	
	public FreeBoardDto() {}
	
	public FreeBoardDto(String id, String date, String title, String txtarea, int viewcount) {
		this.id = id;
		this.date = date;
		this.title = title;
		this.txtarea = txtarea;
		this.viewcount = viewcount;
	}
}

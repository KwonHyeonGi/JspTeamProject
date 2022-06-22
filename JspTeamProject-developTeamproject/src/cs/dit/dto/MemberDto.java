package cs.dit.dto;

public class MemberDto {
	private String id;
	private String password;
	private String nickName;
	private String email;
	private String hobby;
	
	public MemberDto() {
	}
	public MemberDto(String id, String password, String nickName, String email, String hobby) {
		this.id = id;
		this.password = password;
		this.nickName = nickName;
		this.email = email;
		this.hobby = hobby;
	}
	public MemberDto(String id, String password,String reDate) {
		this.id = id;
		this.password = password;
		this.email = reDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
}

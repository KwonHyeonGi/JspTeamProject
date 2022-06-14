package cs.dit.dto;

/**
 * 패키지명 : cs.dit
 * 파일명 : LoginDto.java
 * 변경이력 :
 *    2022-05-02 / 최초작성 : 권현기
 * 프로젝트 설명 : 데이터 전달을 위한 객체
 *
 */
public class LoginDto {
	private String id;
	private String pwd;
	private String name;
	
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the pwd
	 */
	public String getPwd() {
		return pwd;
	}
	/**
	 * @param pwd the pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public LoginDto() {} // 기본 생성자
	
	public LoginDto(String id, String name, String pwd) {
		this.id = id;
		this.name = name;
		this.pwd = pwd;
	}
}

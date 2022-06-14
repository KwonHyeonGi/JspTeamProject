package cs.dit.dto;

/**
 * ��Ű���� : cs.dit
 * ���ϸ� : LoginDto.java
 * �����̷� :
 *    2022-05-02 / �����ۼ� : ������
 * ������Ʈ ���� : ������ ������ ���� ��ü
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
	public LoginDto() {} // �⺻ ������
	
	public LoginDto(String id, String name, String pwd) {
		this.id = id;
		this.name = name;
		this.pwd = pwd;
	}
}

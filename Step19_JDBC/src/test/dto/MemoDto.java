package test.dto;

public class MemoDto {
	//필드 선언
	private int num;
	private String content;
	private String regdate;
	
	//기본 생성자 만들기
	public MemoDto() {}
	public MemoDto(int num, String content, String regdate) {
		super();
		this.num = num;
		this.content = content;
		this.regdate = regdate;
	}//생성자 종료

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
}//MemoDto

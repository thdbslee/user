package egovframework.example.sevtest.board;

import egovframework.example.sample.service.SampleDefaultVO;

public class commentVO extends SampleDefaultVO{
	private int INX;
	private String COMMENT;
	private String ID;
	private int B_INX;
	private String LOGIN_DATE;

	public String getLOGIN_DATE() {
		return LOGIN_DATE;
	}
	public void setLOGIN_DATE(String lOGIN_DATE) {
		LOGIN_DATE = lOGIN_DATE;
	}
	public int getINX() {
		return INX;
	}
	public void setINX(int iNX) {
		INX = iNX;
	}
	public String getCOMMENT() {
		return COMMENT;
	}
	public void setCOMMENT(String cOMMENT) {
		COMMENT = cOMMENT;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public int getB_INX() {
		return B_INX;
	}
	public void setB_INX(int b_INX) {
		B_INX = b_INX;
	}
	
	
}

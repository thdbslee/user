package egovframework.example.sevtest.level;

public class levelVO {
	private int INX;
	private String INXS[];
	private String ID;
	private String CONTENT;
	private String INSERT_DATE;
	private String TITLE;

	
	
	public String[] getINXS() {
		return INXS;
	}
	public void setINXS(String[] iNXS) {
		INXS = iNXS;
	}
	public String getTITLE() {
		return TITLE;
	}
	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}
	public int getINX() {
		return INX;
	}
	public void setINX(int iNX) {
		INX = iNX;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getCONTENT() {
		return CONTENT;
	}
	public void setCONTENT(String cONTENT) {
		CONTENT = cONTENT;
	}
	public String getINSERT_DATE() {
		return INSERT_DATE;
	}
	public void setINSERT_DATE(String iNSERT_DATE) {
		INSERT_DATE = iNSERT_DATE;
	}
	
	
}

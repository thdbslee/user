package egovframework.example.sevtest.notice;

import org.springframework.web.multipart.MultipartFile;

public class noticeVO {
	private int INX ;
	private String[] INXS;
	private String CONTENT;
	private MultipartFile IMG1;
	private String IMG_1;
	private String TITLE;
	private String INSERT_DATE; //등록일
	private int INFO;//조회수
	private String NAME; 
	private String ID;
	
	
	public int getINX() {
		return INX;
	}
	public void setINX(int iNX) {
		INX = iNX;
	}
	public String[] getINXS() {
		return INXS;
	}
	public void setINXS(String[] iNXS) {
		INXS = iNXS;
	}

	public String getCONTENT() {
		return CONTENT;
	}
	public void setCONTENT(String cONTENT) {
		CONTENT = cONTENT;
	}
	public MultipartFile getIMG1() {
		return IMG1;
	}
	public void setIMG1(MultipartFile iMG1) {
		IMG1 = iMG1;
	}
	public String getIMG_1() {
		return IMG_1;
	}
	public void setIMG_1(String iMG_1) {
		IMG_1 = iMG_1;
	}
	public String getTITLE() {
		return TITLE;
	}
	public void setTITLE(String tITLE) {
		TITLE = tITLE;
	}
	public String getINSERT_DATE() {
		return INSERT_DATE;
	}
	public void setINSERT_DATE(String iNSERT_DATE) {
		INSERT_DATE = iNSERT_DATE;
	}
	public int getINFO() {
		return INFO;
	}
	public void setINFO(int iNFO) {
		INFO = iNFO;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	
	
}

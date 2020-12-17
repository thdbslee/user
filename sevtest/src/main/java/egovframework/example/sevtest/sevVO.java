package egovframework.example.sevtest;

public class sevVO {
	private int INX;
	private String[] INXS; //삭제할때 여러개 할수있도록
	private String NAME;
	private String PHONE;
	private String LEVEL;
	private String LEVEL_NAME;
	private String AGE;
	private String STWORK;
	private String ID;
	private String PASSWD; 
	private String LOCK_YN;
	private int FAIL_COUNT;
	private String AUTH_CODE;
	private String LOGIN_DATE;
	private int LEV_COUNT ; //등업게시물 등록 건수
	private String OUT ; //탈퇴여부 
	
	public int getLEV_COUNT() {
		return LEV_COUNT;
	}
	public void setLEV_COUNT(int lEV_COUNT) {
		LEV_COUNT = lEV_COUNT;
	}
	public String getLEVEL_NAME() {
		return LEVEL_NAME;
	}
	public void setLEVEL_NAME(String lEVEL_NAME) {
		LEVEL_NAME = lEVEL_NAME;
	}
	public String getLOGIN_DATE() {
		return LOGIN_DATE;
	}
	public void setLOGIN_DATE(String lOGIN_DATE) {
		LOGIN_DATE = lOGIN_DATE;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPASSWD() {
		return PASSWD;
	}
	public void setPASSWD(String pASSWD) {
		PASSWD = pASSWD;
	}
	public String getLOCK_YN() {
		return LOCK_YN;
	}
	public void setLOCK_YN(String lOCK_YN) {
		LOCK_YN = lOCK_YN;
	}
	public int getFAIL_COUNT() {
		return FAIL_COUNT;
	}
	public void setFAIL_COUNT(int fAIL_COUNT) {
		FAIL_COUNT = fAIL_COUNT;
	}
	public String getAUTH_CODE() {
		return AUTH_CODE;
	}
	public void setAUTH_CODE(String aUTH_CODE) {
		AUTH_CODE = aUTH_CODE;
	}
	public int getINX() {
		return INX;
	}
	public void setINX(int iNX) {
		INX = iNX;
	}
	public String getNAME() {
		return NAME;
	}
	
	public String[] getINXS() {
		return INXS;
	}
	public void setINXS(String[] iNXS) {
		INXS = iNXS;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public String getPHONE() {
		return PHONE;
	}
	public void setPHONE(String pHONE) {
		PHONE = pHONE;
	}
	public String getLEVEL() {
		return LEVEL;
	}
	public void setLEVEL(String lEVEL) {
		LEVEL = lEVEL;
	}
	public String getAGE() {
		return AGE;
	}
	public void setAGE(String aGE) {
		AGE = aGE;
	}
	public String getSTWORK() {
		return STWORK;
	}
	public void setSTWORK(String sTWORK) {
		STWORK = sTWORK;
	}
	public String getOUT() {
		return OUT;
	}

	
	
	
	
}

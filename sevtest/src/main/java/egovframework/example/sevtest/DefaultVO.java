package egovframework.example.sevtest;

import java.io.Serializable;

public class DefaultVO implements Serializable {

	private String 	searchType="";
	private String 	searchText="";
	private int 	searchTotal=1;
	private int		searchPage=1;
	private int		searchMaxPage=1;
	private int		searchStart=1;
	private int		searchEnd=1;
	private int 	searchListCount = 10;
	private int		searchStartPage=1;
	private int		searchEndPage=1;
	private int 	searchPageCount = 10;

	private int mSearchStart = 0;
	private int mSearchCount = 0;
	private String CALL_COUNT = "";
	
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getSearchText() {
		return searchText;
	}
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	public int getSearchTotal() {
		return searchTotal;
	}
	public void setSearchTotal(int searchTotal) {
		this.searchTotal = searchTotal;
	}
	public int getSearchPage() {
		return (searchPage==0?'1':searchPage);
	}
	public void setSearchPage(int searchPage) {
		this.searchPage = searchPage;
	}
	public int getSearchMaxPage() {
		return ((searchTotal - 1) / searchListCount) + 1;
	}
	public void setSearchMaxPage(int searchMaxPage) {
		this.searchMaxPage = searchMaxPage;
	}
	public int getSearchStart() {
		return (getSearchPage()-1)*searchListCount;
	}
	public void setSearchStart(int searchStart) {
		this.searchStart = searchStart;
	}
	public int getSearchEnd() {
		return getSearchPage()*searchListCount;
	}
	public void setSearchEnd(int searchEnd) {
		this.searchEnd = searchEnd;
	}
	public int getSearchListCount() {
		return searchListCount;
	}
	public void setSearchListCount(int searchListCount) {
		this.searchListCount = searchListCount;
	}
	public int getSearchStartPage() {
		int startPage = (int) Math.ceil((getSearchPage()-1)/searchPageCount)*searchPageCount+1;
		return startPage;
	}
	public void setSearchStartPage(int searchStartPage) {
		this.searchStartPage = searchStartPage;
	}
	public int getSearchEndPage() {
		int endPage = getSearchStartPage()+searchPageCount-1;
		return (endPage>getSearchMaxPage()?getSearchMaxPage():endPage);
	}
	public void setSearchEndPage(int searchEndPage) {
		this.searchEndPage = searchEndPage;
	}
	public int getSearchPageCount() {
		return searchPageCount;
	}
	public void setSearchPageCount(int searchPageCount) {
		this.searchPageCount = searchPageCount;
	}	
	public int getMsearchStart() {
		return this.mSearchStart;
	}

	public void setMsearchStart(int mSearchStart) {
		this.mSearchStart = mSearchStart;
	}

	public int getMsearchCount() {
		return this.mSearchCount;
	}

	public void setMsearchCount(int mSearchCount) {
		this.mSearchCount = mSearchCount;
	}

	public String getCALL_COUNT() {
		return this.CALL_COUNT;
	}
	
	public void setCALL_COUNT(String cALL_COUNT) {
		this.CALL_COUNT = cALL_COUNT;
	}
	

}
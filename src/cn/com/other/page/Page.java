package cn.com.other.page;



public class Page {
	private int currentPage=1; //��ǰҳ
	private int perRows;    //ÿҳ��ʾ��
    
	private int totalPage=0; //��ҳ��;
	
	private int totalRows= 0; //
	
	public final int DEFAULT_PERROWS =5;
	public final int DEFAULT_MAX_PAGE = 5; //可选择的最大页数
	
	
	public Page() {
		super();
		this.perRows=DEFAULT_PERROWS;
	}

	public Page(int currentPage, int perRows, int totalPage, int totalRows) {
		super();
		this.currentPage = currentPage;
		this.perRows = perRows;
		this.totalPage = totalPage;
		this.totalRows = totalRows;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPerRows() {
		return perRows;
	}

	public void setPerRows(int perRows) {
		this.perRows = perRows;
	}

	public int getTotalPage() {
		return totalPage;
	}

	private void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
		this.totalPage=(this.totalRows-1)/this.perRows+1;
	}


	
}

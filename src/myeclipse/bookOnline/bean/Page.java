package myeclipse.bookOnline.bean;

import java.util.List;

public class Page {

	private Integer pageSize = 5;		//每一页的固定大小
	private Integer pageNum;			//当前页
	private Integer pageTotal;			//总页数
	private Integer totalRecord;		//总数据条数
	private Integer startPage;			//显示的首数
	private Integer endPage;			//显示的末页
	@SuppressWarnings("rawtypes")
	private List list;
	@SuppressWarnings("rawtypes")
	public List getList() {
		return list;
	}

	@SuppressWarnings("rawtypes")
	public void setList(List list) {
		this.list = list;
	}

	private Integer startIndex;			//当前数据从哪一条记录开始取
	
	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(Integer pageTotal) {
		this.pageTotal = pageTotal;
	}

	public Integer getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(Integer totalRecord) {
		this.totalRecord = totalRecord;
	}

	public Integer getStartPage() {
		return startPage;
	}

	public void setStartPage(Integer startPage) {
		this.startPage = startPage;
	}

	public Integer getEndPage() {
		return endPage;
	}

	public void setEndPage(Integer endPage) {
		this.endPage = endPage;
	}

	public Integer getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

	public Page(Integer pageNum,Integer totalRecord){
		this.pageNum = pageNum;
		this.totalRecord = totalRecord;
		
		//算出总页数
		this.pageTotal = (this.totalRecord + this.pageSize - 1)/this.pageSize;
		//算出用户想看的页的数据从数据库哪个地方开始取
		this.startIndex = (this.pageNum - 1)*this.pageSize;
		
		if(this.pageTotal<=10){
			this.startPage = 1;
			this.endPage = this.pageTotal;
		}else{
			this.startPage = pageNum - 4;
			this.endPage = pageNum + 5;
			
			if(this.startPage<1){
				this.startPage = 1;
				this.endPage = 10;
			}
			if(this.endPage>this.pageTotal){
				this.endPage = this.pageTotal;
				this.startPage = this.pageTotal-9;
			}
		}
	}
}

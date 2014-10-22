package myeclipse.bookOnline.bean;

import java.util.List;

public class Page {

	private Integer pageSize = 5;		//ÿһҳ�Ĺ̶���С
	private Integer pageNum;			//��ǰҳ
	private Integer pageTotal;			//��ҳ��
	private Integer totalRecord;		//����������
	private Integer startPage;			//��ʾ������
	private Integer endPage;			//��ʾ��ĩҳ
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

	private Integer startIndex;			//��ǰ���ݴ���һ����¼��ʼȡ
	
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
		
		//�����ҳ��
		this.pageTotal = (this.totalRecord + this.pageSize - 1)/this.pageSize;
		//����û��뿴��ҳ�����ݴ����ݿ��ĸ��ط���ʼȡ
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

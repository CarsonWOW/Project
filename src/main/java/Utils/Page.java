package Utils;

public class Page {
    //当前页  当前查询的是第几页
    private  int curPageNo=1;
    //每页显示多少条数据
    private  int pageSize=10;//默认显示10条  等下程序去修改
    //总页数  //总页数，应该是通过总条数算出来的
    private  int totalPageCount=0;//默认0
    //总条数
    private  int totalCount=0;//

    //生成getter/setter方法

    public int getCurPageNo() {
        return curPageNo;
    }

    public void setCurPageNo(int curPageNo) {
        this.curPageNo = curPageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(int totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    //去修改此方法   这个代码可以自己复制
    public void setTotalCount(int totalCount) {
        if(totalCount>0){
            this.totalCount = totalCount;
            //totalPageCount  总页数是通过总条数算出来的  计算总页数
            if(totalCount%pageSize==0){
                totalPageCount=totalCount/pageSize;
            }else {
                totalPageCount=totalCount/pageSize+1;
            }

        }

    }
}

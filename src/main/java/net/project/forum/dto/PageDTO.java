package net.project.forum.dto;

import java.util.List;

/**
 * 泛型
 */
public class PageDTO<T> {

    /**
     * 当前页码
     */
    private int pageNumber;

    /**
     * 每页显示数
     */
    private int pageSize;

    /**
     * 总条数
     */
    private int totalRecord;

    /**
     * 总页数
     */
    private int totalPage;

    /**
     * 数据集合
     */
    private List<T> list;

    public PageDTO(int pageNumber, int pageSize, int totalRecord) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.totalRecord = totalRecord;


        if (totalRecord % pageSize == 0) {
            totalPage = totalRecord/pageSize;
        } else {
            totalPage = totalRecord/pageSize + 1;
        }
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    @Override
    public String toString() {
        return "PageDTO{" +
                "pageNumber=" + pageNumber +
                ", pageSize=" + pageSize +
                ", totalRecord=" + totalRecord +
                ", totalPage=" + totalPage +
                ", list=" + list +
                '}';
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}

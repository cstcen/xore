package com.cstcen.core.model.result;

import com.cstcen.core.constant.OrderEnum;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @author Chester
 **/
public class DataPage<T> implements Serializable {

    private static final long serialVersionUID = 2689369274615118731L;

    private int pageNo = 1;
    private int pageSize = 20;
    private OrderEnum order = null;
    private String orderBy = null;
    private boolean needData = true;
    private boolean needTotalCount = true;

    private List<T> data = null;
    private long totalCount = -1;

    public DataPage() {
    }

    public DataPage(int pageSize) {
        this.pageSize = pageSize;
    }

    public DataPage(int pageNo, int pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    public DataPage(boolean needData, boolean needTotalCount) {
        this.needData = needData;
        this.needTotalCount = needTotalCount;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = Math.max(pageNo, 1);
    }

    public DataPage<T> pageNo(int pageNo) {
        setPageNo(pageNo);
        return this;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public DataPage<T> pageSize(int pageSize) {
        setPageSize(pageSize);
        return this;
    }

    public int getFirst() {
        return (pageNo - 1) * pageSize;
    }

    /**
     * 获得排序字段，无默认值，多个排序字段，用','分割
     */
    public String getOrderBy() {
        return orderBy;
    }

    /**
     * 设置排序字段，多个排序字段，用','分割
     */
    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public DataPage<T> orderBy(String orderBy) {
        setOrderBy(orderBy);
        return this;
    }

    /**
     * 获得排序方向，无默认值
     */
    public OrderEnum getOrder() {
        return order;
    }

    public void setOrder(OrderEnum order) {
        this.order = order;
    }

    public DataPage<T> order(OrderEnum order) {
        setOrder(order);
        return this;
    }

    public boolean isOrdered() {
        return StringUtils.isNotBlank(orderBy) && Objects.nonNull(order);
    }

    public boolean isNeedData() {
        return needData;
    }

    public void setNeedData(boolean needData) {
        this.needData = needData;
    }

    public boolean isNeedTotalCount() {
        return needTotalCount;
    }

    public void setNeedTotalCount(boolean needTotalCount) {
        this.needTotalCount = needTotalCount;
    }

    public DataPage<T> needTotalCount(boolean needTotalCount) {
        setNeedTotalCount(needTotalCount);
        return this;
    }

    public List<T> getDataList() {
        return data;
    }

    public void setDataList(List<T> dataList) {
        this.data = dataList;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public long getTotalPages() {
        if (totalCount < 0) {
            return -1;
        }

        long count = totalCount / pageSize;

        if (totalCount % pageSize > 0) {
            count++;
        }

        return count;
    }

    /**
     * 是否还有下一页
     */
    public boolean hasNext() {
        return pageNo + 1 <= getTotalPages();
    }

    public int nextPage() {
        if (hasNext()) {
            return pageNo + 1;
        }
        return pageNo;
    }

    public int endIndex() {
        return pageNo * pageSize;
    }

    public int beginIndex() {
        return this.getFirst();
    }

    public boolean hasPrev() {
        return pageNo - 1 >= 1;
    }

    public int prevPage() {
        if (hasPrev()) {
            return pageNo - 1;
        }
        return pageNo;
    }
}

package com.cstcen.core.model.result;

/**
 * @author xin.cen
 **/
public class PageResult<T> extends BaseResult {

    private static final long serialVersionUID = 6569019743624849384L;

    private DataPage<T> page;

    public DataPage<T> getPage() {
        return page;
    }

    public void setPage(DataPage<T> page) {
        this.page = page;
    }

    @SuppressWarnings("unchecked")
    public <S extends PageResult> S withPage(DataPage<T> page) {
        this.page = page;
        return (S) this;
    }
}

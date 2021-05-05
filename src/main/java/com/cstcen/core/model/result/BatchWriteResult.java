package com.cstcen.core.model.result;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author xin.cen
 **/
@SuppressWarnings("unchecked")
public class BatchWriteResult<T> extends BaseResult {
    private static final long serialVersionUID = 4541069104176451507L;

    private Collection<?> successList = new ArrayList<>();

    private Collection<T> failList = new ArrayList<>();

    @Override
    public boolean isSuccess() {
        return !successList.isEmpty();
    }

    /**
     * 由接口实现方确定返回ID List，还是DO List
     */
    public <E> Collection<E> getSuccessList() {
        return (Collection<E>) successList;
    }

    public <S extends BatchWriteResult<?>> S withSuccessList(Collection<?> successList) {
        this.successList = successList;
        return (S) this;
    }

    public Collection<T> getFailList() {
        return failList;
    }

    /**
     * 一般返回ID List，对于insert List的可返回 DO List
     */
    public <S extends BatchWriteResult<?>> S withFailList(Collection<T> failList) {
        this.failList = failList;
        return (S)this;
    }
}

package com.cstcen.core.model.result;

/**
 * @author xin.cen
 **/
@SuppressWarnings("unchecked")
public class ModelResult<T> extends BaseResult {
    private static final long serialVersionUID = -6105271631587287073L;

    private T model;
    private boolean readFromCache = true;

    public ModelResult() {
    }

    public ModelResult(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }

    public <S extends ModelResult<T>> S withModel(T model) {
        this.model = model;
        return (S) this;
    }

    public <S extends ModelResult<T>> S withModelFromDB(T model) {
        this.model = model;
        this.readFromCache = false;
        return (S) this;
    }

    public boolean isReadFromCache() {
        return readFromCache;
    }

    public void setReadFromCache(boolean readFromCache) {
        this.readFromCache = readFromCache;
    }
}

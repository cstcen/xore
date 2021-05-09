package com.cstcen.core.model.result;

/**
 * @author Chester
 **/
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
        @SuppressWarnings("unchecked")
        final S s = (S) this;
        return s;
    }

    public <S extends ModelResult<T>> S withModelFromDb(T model) {
        this.model = model;
        this.readFromCache = false;
        @SuppressWarnings("unchecked")
        final S s = (S) this;
        return s;
    }

    public boolean isReadFromCache() {
        return readFromCache;
    }

    public void setReadFromCache(boolean readFromCache) {
        this.readFromCache = readFromCache;
    }
}

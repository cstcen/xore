package com.cstcen.core.model.result;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author Chester
 **/
public class BaseResult implements Serializable {

    private static final long serialVersionUID = 4982910566347785512L;

    private Map<String, String> errorList = new HashMap<>();

    public boolean isSuccess() {
        return errorList.isEmpty();
    }

    public <T extends BaseResult> T withError(String code, String msg) {
        errorList.put(code, msg);
        @SuppressWarnings("unchecked")
        final T t = (T) this;
        return t;
    }

    public Optional<String> getCode() {
        if (isSuccess()) {
            return Optional.empty();
        }
        return Optional.of(errorList.keySet().iterator().next());
    }

    public Map<String, String> getErrorList() {
        return errorList;
    }

    public void setErrorList(Map<String, String> errorList) {
        this.errorList = errorList;
    }
}

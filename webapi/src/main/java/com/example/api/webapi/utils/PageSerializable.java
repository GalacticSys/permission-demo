package com.example.api.webapi.utils;

import java.io.Serializable;
import java.util.List;

public class PageSerializable<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    protected long total;
    protected List<T> list;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}

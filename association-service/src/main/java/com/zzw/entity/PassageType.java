package com.zzw.entity;

import java.io.Serializable;

public class PassageType implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 文章类型
     */
    private Integer id;
    /**
     * 文章类型
     */
    private String type;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "PassageType{" +
        "id=" + id +
        ", type=" + type +
        "}";
    }
}

package com.pyf.housedbes.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * @author ADMIN
 */
@Data
public class PageParam {

    @Getter
    @Setter
    private Integer page;

    @Getter
    @Setter
    private Integer size;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}

package com.enigma.pocket.wrapper;

import org.springframework.data.domain.Page;

import java.util.List;

public class PageWrapper<T> {

    private List<T> content;
    private Long totalContent;
    private Integer totalPage;
    private Integer page;
    private Integer size;

    public PageWrapper(Page<T> page) {
        this.content = page.getContent();
        this.totalContent = page.getTotalElements();
        this.totalPage = page.getTotalPages();
        this.page = page.getNumber();
        this.size = page.getSize();
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public Long getTotalContent() {
        return totalContent;
    }

    public void setTotalContent(Long totalContent) {
        this.totalContent = totalContent;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

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

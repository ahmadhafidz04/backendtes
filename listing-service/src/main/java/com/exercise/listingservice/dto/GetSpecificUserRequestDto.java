package com.exercise.listingservice.dto;

public class GetSpecificUserRequestDto {
    private Integer Id;
    private String name;
    private Integer pageNum;
    private Integer pageSize;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer d) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPageNum() {
        return pageNum;
    }
    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}

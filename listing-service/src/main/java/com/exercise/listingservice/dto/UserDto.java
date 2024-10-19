package com.exercise.listingservice.dto;

public class UserDto {

    private Integer Id;
    private String name;
    private Long createAt;
    private Long updateAt;

    public Integer getId() {
        return Id;
    }
    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Long getCreateAt() {
        return createAt;
    }
    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public Long getUpdateAt() {
        return updateAt;
    }
    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }

}

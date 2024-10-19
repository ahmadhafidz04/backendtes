package com.exercise.listingservice.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

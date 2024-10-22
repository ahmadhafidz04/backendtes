package com.exercise.listingservice.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class GetSpecificUserResponseDto {
    private Boolean result;
    private Integer Id;
    private List<UserDto> user;

    public Boolean getResult() {
        return result;
    }
    public void setResult(Boolean result) {
        this.result = result;
    }

    public Integer getId() {
        return Id;
    }
    public void setId(Integer id) {
        this.Id = id;
    }

    public List<UserDto> getUser() {
        return user;
    }

    public void setUser(List<UserDto> listings) {
        this.user = listings;
    }
}

package com.vlpc.service.dto;

import org.springframework.lang.NonNull;

public class PositionDto {

    @NonNull
    private String title;

    public PositionDto(String title) {
        this.title = title;
    }

    public PositionDto(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

package com.gurkan.shortlink.dto;

import lombok.Data;

@Data
public class CreateLinkResponseDto {

    private String code;
    private String link;
}

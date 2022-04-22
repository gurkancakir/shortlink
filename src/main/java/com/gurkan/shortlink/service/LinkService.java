package com.gurkan.shortlink.service;

import com.gurkan.shortlink.dto.CreateLinkRequestDto;
import com.gurkan.shortlink.dto.CreateLinkResponseDto;

public interface LinkService {

    CreateLinkResponseDto save(CreateLinkRequestDto createLinkRequestDto);
    String findLinkByCode(String code);
}

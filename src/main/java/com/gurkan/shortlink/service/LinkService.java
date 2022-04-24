package com.gurkan.shortlink.service;

import com.gurkan.shortlink.dto.CreateLinkRequestDto;
import com.gurkan.shortlink.dto.CreateLinkResponseDto;
import com.gurkan.shortlink.entity.Link;

import java.util.List;

public interface LinkService {

    CreateLinkResponseDto save(CreateLinkRequestDto createLinkRequestDto);
    String findLinkByCode(String code);
    List<Link> findAll();
}

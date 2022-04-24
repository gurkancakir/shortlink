package com.gurkan.shortlink.service.impl;

import com.gurkan.shortlink.dto.CreateLinkRequestDto;
import com.gurkan.shortlink.dto.CreateLinkResponseDto;
import com.gurkan.shortlink.entity.Link;
import com.gurkan.shortlink.enums.RecordStatus;
import com.gurkan.shortlink.repository.LinkRepository;
import com.gurkan.shortlink.service.LinkGeneratorService;
import com.gurkan.shortlink.service.LinkService;
import lombok.AllArgsConstructor;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LinkServiceImpl implements LinkService {

    private final LinkRepository linkRepository;
    private final LinkGeneratorService linkGeneratorService;
    private final DozerBeanMapper dozerMapper;

    public CreateLinkResponseDto save(CreateLinkRequestDto createLinkRequestDto) {
        Link link = new Link();
        link.setStatus(RecordStatus.ACTIVE);
        link.setCode(linkGeneratorService.generateCode());
        link.setLink(createLinkRequestDto.getLink());
        return dozerMapper.map(linkRepository.save(link), CreateLinkResponseDto.class);
    }

    public String findLinkByCode(String code) {
        Link link = linkRepository.findByCodeEquals(code).orElseThrow();
        return link.getLink();
    }

    public List<Link> findAll() {
        return linkRepository.findAll();
    }
}

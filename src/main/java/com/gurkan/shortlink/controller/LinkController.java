package com.gurkan.shortlink.controller;

import com.gurkan.shortlink.dto.CreateLinkRequestDto;
import com.gurkan.shortlink.dto.CreateLinkResponseDto;
import com.gurkan.shortlink.service.LinkGeneratorService;
import com.gurkan.shortlink.service.LinkService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/link")
@AllArgsConstructor
public class LinkController {

    private final LinkService linkService;
    private final LinkGeneratorService linkGeneratorService;

    @PostMapping
    public CreateLinkResponseDto save(@RequestBody CreateLinkRequestDto createLinkRequestDto) {
        return linkService.save(createLinkRequestDto);
    }

    @GetMapping("/generate-code")
    public String generateCode() {
        return linkGeneratorService.generateCode();
    }

    @GetMapping("/{code}/show")
    public String findLink(@PathVariable("code") String code) {
        return linkService.findLinkByCode(code);
    }
}

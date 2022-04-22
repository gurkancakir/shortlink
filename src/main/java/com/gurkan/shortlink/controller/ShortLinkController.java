package com.gurkan.shortlink.controller;

import com.gurkan.shortlink.service.LinkService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@AllArgsConstructor
public class ShortLinkController {

    private final LinkService linkService;

    @GetMapping("{code}")
    public ResponseEntity<Void> findLink(@PathVariable("code") String code) {
        String link = linkService.findLinkByCode(code);
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(link))
                .build();
    }
}

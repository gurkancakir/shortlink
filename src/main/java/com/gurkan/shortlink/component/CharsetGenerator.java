package com.gurkan.shortlink.component;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@AllArgsConstructor
public class CharsetGenerator {

    private List<Charset> charsets;

    public String createCharset() {
        return this.createCharset(charsets);
    }

    public String createCharset(Charset... charsets) {
        return this.createCharset(Stream.of(charsets).collect(Collectors.toList()));
    }

    private String createCharset(List<Charset> charsets) {
        StringBuilder charsetBuilder = new StringBuilder();
        for (Charset charset : charsets) {
            charsetBuilder.append(charset.charset());
        }
        return charsetBuilder.toString();
    }
}

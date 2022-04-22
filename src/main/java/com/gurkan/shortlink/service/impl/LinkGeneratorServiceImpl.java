package com.gurkan.shortlink.service.impl;

import com.gurkan.shortlink.component.CharsetGenerator;
import com.gurkan.shortlink.service.LinkGeneratorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LinkGeneratorServiceImpl implements LinkGeneratorService {

    private final CharsetGenerator charsetGenerator;


    private static final String SYMBOLS = "!@#$%^&*?";
    private static final String AMBIGUOUS_SYMBOLS = "!@#$%^&*?";

    public String generateCode() {
        return this.generateCode(8);
    }

    public String generateCode(int length) {
        String charset = charsetGenerator.createCharset();
        StringBuilder code = new StringBuilder();
        for (int i = 0, n = charset.length(); i < length; ++i) {
            code.append(charset.charAt((int) Math.floor(Math.random() * n)));
        }
        return code.toString();
    }
}

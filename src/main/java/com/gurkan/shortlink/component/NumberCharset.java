package com.gurkan.shortlink.component;

import org.springframework.stereotype.Component;

@Component
public class NumberCharset implements Charset {

    private static final String NUMBERS = "0123456789";

    @Override
    public String charset() {
        return NUMBERS;
    }
}

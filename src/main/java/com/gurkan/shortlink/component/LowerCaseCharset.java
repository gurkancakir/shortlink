package com.gurkan.shortlink.component;

import org.springframework.stereotype.Component;

@Component
public class LowerCaseCharset implements Charset {

    private static final String LOVER_CASE = "abcdefghijklmnopqrstuvwxyz";

    @Override
    public String charset() {
        return LOVER_CASE;
    }
}

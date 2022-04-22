package com.gurkan.shortlink.component;

import org.springframework.stereotype.Component;

@Component
public class UpperCaseCharset implements Charset {

    private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @Override
    public String charset() {
        return UPPER_CASE;
    }
}

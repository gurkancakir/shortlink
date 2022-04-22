package com.gurkan.shortlink.service;

public interface LinkGeneratorService {

    String generateCode();
    String generateCode(int length);
}

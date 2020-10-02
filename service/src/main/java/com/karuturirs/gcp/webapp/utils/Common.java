package com.karuturirs.gcp.webapp.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class Common {

    @Async
    public CompletableFuture<String> randomWord(int size){
        return CompletableFuture.completedFuture(RandomStringUtils.randomAlphanumeric(size,size));
    }


    @Async
    public CompletableFuture<String> randomKey(int size){
        return CompletableFuture.completedFuture(RandomStringUtils.randomAlphabetic(size,size*2));
    }

}

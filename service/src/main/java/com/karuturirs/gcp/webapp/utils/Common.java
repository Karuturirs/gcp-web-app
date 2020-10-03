package com.karuturirs.gcp.webapp.utils;

import com.karuturirs.gcp.webapp.service.KeysServiceImpl;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

@Component
public class Common {

    private static final Logger logger = LoggerFactory.getLogger(Common.class);

    @Async("abcd")
    public CompletableFuture<String> randomWord(int size) throws InterruptedException {
        int x = (new Random()).nextInt();
        //logger.info("In Word generation : {}", x);
        //Thread.sleep(1000);
        //logger.info("In Word generation : {}", x);
        return CompletableFuture.completedFuture(RandomStringUtils.randomAlphanumeric(size,size));
    }


    @Async("abcd")
    public CompletableFuture<String> randomKey(int size) throws InterruptedException {
        int x = (new Random()).nextInt();
        //logger.info("In Key generation : {}", x);
        //Thread.sleep(500);
        //logger.info("In Key generation : {}",x);
        return CompletableFuture.completedFuture(RandomStringUtils.randomAlphabetic(size,size*2));
    }

}

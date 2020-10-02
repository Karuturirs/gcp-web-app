package com.karuturirs.gcp.webapp.service;

import com.karuturirs.gcp.webapp.pojo.Keys;
import com.karuturirs.gcp.webapp.utils.Common;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class KeysServiceImpl implements KeysService {

    private static final Logger logger = LoggerFactory.getLogger(KeysServiceImpl.class);

    @Autowired
    Common common;

    @Override
    public Keys randomKeysGenerator(int count) {

        Keys keys = new Keys();

        Map<CompletableFuture<String>, CompletableFuture<String>> keyMap = IntStream.range(1, count).boxed()
                .collect(
                        Collectors.toMap(
                                i -> common.randomKey(5), i -> common.randomWord(20))
                );
        keyMap.forEach((k, v) -> {
            try {
                keys.addKey(k.get(), v.get());
            }catch(Exception e){
                logger.error("Unable to Generate Keys", e);
            }
        });

        return keys;
    }
}

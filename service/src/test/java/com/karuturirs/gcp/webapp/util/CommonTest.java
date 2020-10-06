package com.karuturirs.gcp.webapp.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CommonTest {

    @Test
    public void streamTest(){
        Map<String, String> keyMap = IntStream.range(0, 10).boxed()
                .collect(
                        Collectors.toMap(
                                i -> RandomStringUtils.randomAlphanumeric(5), i -> RandomStringUtils.randomAlphanumeric(20))
                );
       Assertions.assertEquals(10, keyMap.size());
        keyMap.forEach((k,v)-> System.out.println(k+"--"+v));
    }
}

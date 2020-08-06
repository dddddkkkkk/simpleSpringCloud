package com.springcloud.eureka;

import com.netflix.discovery.DiscoveryClient;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class EurekaServerApplicationTest extends TestCase {

    @Autowired
    DiscoveryClient discoveryClient;

    @Test
    public void test() {
        Set<String> allKnownRegions = discoveryClient.getAllKnownRegions();
        log.info("--->{}", allKnownRegions);
    }
}
package com.landon30.crossdemo.test.idea;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 使用log4j2
 *
 * @author landon30
 */
public class HelloLog4j2 {
    private static final Logger log = LogManager.getLogger(HelloLog4j2.class);

    public static void main(String[] args) {
        log.debug("Hello,Log4j2");
        log.debug("I'm {}", "log4j2");

        try {
            System.out.println(5 / 0);
        } catch (Exception e) {
            log.error("error", e);
        }
    }
}

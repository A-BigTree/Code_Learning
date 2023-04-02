/**
 * ==================================================
 * Project: pro3_mybatis_log
 * Package: org.example
 * =====================================================
 * Title: LogTest.java
 * Created: [2023/4/1 15:05] by Shuxin-Wang
 * =====================================================
 * Description: description here
 * =====================================================
 * Revised History:
 * 1. 2023/4/1, created by Shuxin-Wang.
 * 2.
 */

package org.example;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTest {
    private final Logger logger = LoggerFactory.getLogger(LogTest.class);

    @Test
    public void testLog(){
        logger.trace("hello trace");
        logger.debug("hello, debug");
        logger.info("hello info");
        logger.warn("hello warn");
        logger.error("hello error");
    }
}

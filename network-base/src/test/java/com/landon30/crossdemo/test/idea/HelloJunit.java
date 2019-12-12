package com.landon30.crossdemo.test.idea;

import org.junit.Assert;
import org.junit.Test;

/**
 * 使用idea编写的第一个junit
 *
 * @author landon30
 */
public class HelloJunit {

    @Test
    public void test() {
        int a = 100;
        Assert.assertEquals(a, 100);
    }

    @Test
    public void test2() {
        int b = 50;
        Assert.assertEquals(b, 100);
    }
}

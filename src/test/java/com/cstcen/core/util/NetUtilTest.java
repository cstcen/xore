package com.cstcen.core.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class NetUtilTest {

    @Test
    public void testMY_IP() {
        System.out.println("NetUtil.MY_IP = " + NetUtil.MY_IP);
        assertNotNull(NetUtil.MY_IP);
    }
}
package com.kevinearls.Simple;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by kearls on 2/8/16.
 */
public class SimpleTest {
    Random random = new Random();
    @Test
    public void simpleTest() throws Exception {
        int selection = random.nextInt(5) + 1;
        assertEquals(3, selection);
    }
}

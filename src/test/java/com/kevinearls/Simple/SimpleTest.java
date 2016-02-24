package com.kevinearls.Simple;

import org.junit.Test;
import org.junit.Ignore;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by kearls on 2/8/16.
 */
public class SimpleTest {
    Random random = new Random();

    @Ignore
    @Test
    public void simpleTest() throws Exception {
        int selection = random.nextInt(5) + 1;
        assertEquals(666, selection);
    }

    @Test
    public void justPassThisTest() throws Exception {
        Thread.sleep(5000);
    }
}

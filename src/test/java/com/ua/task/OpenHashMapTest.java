package com.ua.task;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class OpenHashMapTest {

    private OpenHashMap openHashMap;

    @Before
    public void setUp() throws Exception {
        openHashMap = new OpenHashMap(1);
        openHashMap.put(0, 12);

    }

    @After
    public void tearDown() throws Exception {
        openHashMap = null;
    }

    @Test
    public void put_success() throws Exception {
        openHashMap.put(3, 12);
        assertEquals(12, openHashMap.getValue(3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void put_Exception() throws Exception {
        openHashMap.put(3, 12);
        openHashMap.put(4, 12);
    }

    @Test
    public void getValue_success() throws Exception {
        assertEquals(12, openHashMap.getValue(0));
    }

    @Test(expected = RuntimeException.class)
    public void getValue_Exception() throws Exception {
        assertEquals(12, openHashMap.getValue(48));
    }

    @Test
    public void size() throws Exception {
        assertEquals(2, openHashMap.size());
    }

}

package com.Reflection.Annotation.IO;

import org.junit.Test;
import static org.junit.Assert.*;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;



public class TestTask {
    @Test
    public void testInit() {
        List<Class> cl = new ArrayList<>();
        Reflection reflection = new Reflection();
        reflection.init(cl);
        assertTrue(cl.contains(Child1.class));
        assertTrue(cl.contains(Child2.class));
    }

    @Test
    public void testSearch(){
        Reflection reflection = new Reflection();
        List cl = new ArrayList<>();
        cl.add(Child1.class);
        cl.add(Child2.class);
        cl = reflection.search(cl, 5);
        assertEquals(1, cl.size());
    }

    @Test
    public void testReflect() throws InvocationTargetException, IllegalAccessException, InstantiationException{
        Reflection reflection = new Reflection();
        DataContainer dataContainer = new DataContainer();
        reflection.reflect(5, 3, dataContainer);
        assertFalse(reflection.str.length() < 0);
    }

    @Test
    public void testCreateLog() {
        LogCreator logCreator = new LogCreator();
        logCreator.createLog();
        File dir = new File("log");
        assertTrue(dir.exists());
    }
}
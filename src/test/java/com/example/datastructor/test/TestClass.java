package com.example.datastructor.test;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestClass {
    public static void main(String[] args) {
        TestClass tc = new TestClass();
        tc.test();
    }

    public void test() {
        MethodTest mt = new MethodTest();
        mt.getCaller();
    }

    @Test
    public void test2() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        MethodTest methodTest = new MethodTest();
        Class<? extends MethodTest> aClass = methodTest.getClass(); //通过实例对象获取反射类获取反射类
//        Class<Method> a = Method.class; //通过类获取反射类
        Method getCaller = aClass.getDeclaredMethod("getCaller");
        getCaller.invoke(methodTest);
        aClass.getMethod("getCaller", int.class, String.class).invoke(methodTest, 1, "abc");
    }
}
class MethodTest{
    public void getCaller(int a, String b) {
        System.out.println("调用了有参方法getCaller()");
        System.out.println(a + b + "");
    }

    public void getCaller() {
        System.out.println("调用了无参方法getCaller()");
    }
}
package com.example.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api("test")
@RestController
@RequestMapping("/test")
public class TestController {


    @RequestMapping(value = "/oomTest.do", method = RequestMethod.POST)
    public void oomTest(int times) {
        List<A> list = new ArrayList<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < times; ++i) {
                        Thread.sleep(1000);
                        list.add(new A());
                        System.out.println(list);
                    }
                } catch (InterruptedException e) {

                }
            }
        }).start();
    }
    class A{
        Byte[] bytes = new Byte[100*1024*1024];
    }
    @RequestMapping(value = "/deadLock.do", method = RequestMethod.POST)
    public void deadLock(@RequestParam("times") int times) {
        for (int i = 0; i < times; ++i) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    B b = new B();
                    b.methodB();
                    C c = new C();
                    c.methodC();
                }
            }).start();
        }
    }

    class B{
        private C c = new C();
        public synchronized void methodB() {
            c.methodC();
        }

    }

    class C {
        private B b = new B();
        public synchronized void methodC() {
            b.methodB();
        }
    }
}

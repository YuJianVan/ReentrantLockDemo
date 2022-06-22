package com.gzhu.reentrantlockdemo02.service.Impl;

import com.gzhu.reentrantlockdemo02.service.TestService;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class TestServiceImpl implements TestService {
    Lock lock=new ReentrantLock();
    @Override
    public String test(String code) {
        lock.lock();
        try {
            SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.print(sdf.format(System.currentTimeMillis()));
            System.out.println(" code="+code+"  tid="+Thread.currentThread().getId()+" comes in");
            TimeUnit.SECONDS.sleep(3);
            System.out.println(sdf.format(System.currentTimeMillis())+" "+Thread.currentThread().getId()+" finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return "success";
    }
}
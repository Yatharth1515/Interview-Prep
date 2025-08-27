package org.example;

public class MonitorLockRunnable implements Runnable{
    MonitorLock obj;
    public MonitorLockRunnable(MonitorLock monitorLock){
        this.obj = monitorLock;
    }
    @Override
    public void run() {
        obj.task1();
    }
}

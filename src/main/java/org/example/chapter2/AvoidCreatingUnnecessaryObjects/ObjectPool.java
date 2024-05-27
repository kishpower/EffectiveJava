package org.example.chapter2.AvoidCreatingUnnecessaryObjects;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ObjectPool<T> {
    private final BlockingQueue<T> pool;
    private final int maxSize;

    public ObjectPool(int maxSize, Class<T> clazz) throws Exception {
        this.maxSize = maxSize;
        pool = new LinkedBlockingQueue<>(maxSize);
        for (int i = 0; i < maxSize; i++) {
            pool.offer(clazz.getDeclaredConstructor().newInstance());
        }
    }

    public T borrowObject() throws InterruptedException {
        T obj = pool.take();
        if (obj instanceof DatabaseConnection) {
            ((DatabaseConnection) obj).setInUse(true);
        }
        return obj;
    }

    public void returnObject(T obj) {
        if (obj instanceof DatabaseConnection) {
            ((DatabaseConnection) obj).setInUse(false);
        }
        pool.offer(obj);
    }
}

package testng.parallel.demo;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import org.testng.annotations.AfterClass;

public class TestBase {
    Set<Thread> threads = new HashSet<>();

    @AfterClass(alwaysRun=true)
    public void listThreads() {
        recordThread("listThreads");
        System.out.println(getClass().getSimpleName() + " ran on threads: " + threads);
    }

    protected void recordThread(Method method) {
        recordThread(method.toString());
    }

    private void recordThread(String name) {
        System.out.println(name + " running on thread " + Thread.currentThread());
        threads.add(Thread.currentThread());
    }
}

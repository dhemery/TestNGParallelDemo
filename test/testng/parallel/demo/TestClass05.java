package testng.parallel.demo;
import java.lang.reflect.Method;

import org.testng.annotations.Test;

public class TestClass05 extends TestBase {
    @Test
    public void freeMethod(Method method) {
        recordThread(method);
    }

    @Test(dependsOnMethods="freeMethod")
    public void dependentMethod(Method method) {
        recordThread(method);
    }
}

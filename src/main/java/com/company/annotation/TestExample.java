package com.company.annotation;

/**
 * Created by rajpurev on 5/17/16.
 */

//http://www.mkyong.com/java/java-custom-annotations-example/
@TesterInfo(
        priority = TesterInfo.Priority.HIGH,
        createdBy = "Test",
        tags = {"annotation","test"}
)
public class TestExample {

    @Test
    void testA() {
        if (true)
            throw new RuntimeException("This test always failed");
    }

    @Test(enabled = false)
    void testB() {
        if (false)
            throw new RuntimeException("This test always passed");
    }

    @Test(enabled = true)
    void testC() {
        if (10 > 1) {
            // do nothing, this test always passed.
        }
    }

}

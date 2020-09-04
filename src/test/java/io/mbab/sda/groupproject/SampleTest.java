package io.mbab.sda.groupproject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SampleTest {

    @Test
    void shouldDoSomething() {
        //given
        int value = 1;
        int expectedValue = 3;

        //when
        int actualValue =  value +  2;

        //then
        Assertions.assertEquals(expectedValue, actualValue);
    }
}

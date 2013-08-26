package fr.xebia.xke.pricer;

import org.fest.assertions.Assertions;
import org.junit.Test;

public class PerformanceTest {

    @Test
    public void performance() {
        Long startTime = System.currentTimeMillis();

        for (int i = 0; i < 10; i++) {
            new Pricer(
                    100d,
                    100d,
                    1.07,
                    1.01,
                    20).fairValue();
        }

        Assertions.assertThat(System.currentTimeMillis() - startTime).as("Timeout").isLessThan(10000);

    }
}
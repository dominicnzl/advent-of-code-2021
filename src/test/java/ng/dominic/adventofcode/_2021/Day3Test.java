package ng.dominic.adventofcode._2021;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class Day3Test {

    private static final Logger logger = LoggerFactory.getLogger(Day3Test.class);

    @Test
    void task1() throws IOException {
        // Integer.parseInt("10110", 2) * Integer.parseInt("01001", 2);
        assertThat(Day3.task1("_2021/day3-sample", 5)).isEqualTo(198);
        logger.info("Answer to task 1 is {}", Day3.task1("_2021/day3", 12));
    }

    @Test
    void task2() throws IOException {
        assertThat(Day3.task2("_2021/day3-sample")).isEqualTo(230);
        logger.info("Answer to task2 is {}", Day3.task2("_2021/day3"));
    }

}
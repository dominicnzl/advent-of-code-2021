package ng.dominic.adventofcode._2021;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Day2Test {

    Logger logger = LoggerFactory.getLogger(Day2Test.class);

    @Test
    void task1() throws IOException {
        // forward = 15, down = 10 -> 15 * 10 = 150
        assertThat(Day2.task1("_2021/day2-sample")).isEqualTo(150);
        logger.info("Answer for task 1 is {}", Day2.task1("_2021/day2"));
    }

    @Test
    void task2() throws IOException {
        assertThat(Day2.task2("_2021/day2-sample")).isEqualTo(900);
        logger.info("Answer for task 2 is {}", Day2.task2("_2021/day2"));
    }

}
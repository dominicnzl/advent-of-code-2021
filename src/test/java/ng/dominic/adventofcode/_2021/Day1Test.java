package ng.dominic.adventofcode._2021;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Day1Test {

    Logger logger = LoggerFactory.getLogger(Day1Test.class);

    @Test
    void task1() throws IOException {
        logger.info("Answer for task1 is: {}", Day1.countNumberOfIncreases("aoc-2021-day1"));
        assertThat(Day1.countNumberOfIncreases("aoc-2021-day1-sample")).isEqualTo(7);
    }

    @Test
    void task2() throws IOException {
        logger.info("Answer for task2 is: {}", Day1.countNumberOfIncreasedSlidingWindow("aoc-2021-day1"));
        assertThat(Day1.countNumberOfIncreasedSlidingWindow("aoc-2021-day1-sample")).isEqualTo(5);
    }
}
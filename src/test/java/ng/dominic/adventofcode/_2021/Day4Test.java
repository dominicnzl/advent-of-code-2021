package ng.dominic.adventofcode._2021;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class Day4Test {

    Logger logger = LoggerFactory.getLogger(Day4Test.class);

    @Test
    void task1() throws IOException {

        // The score of the winning board can now be calculated. Start by finding the sum of all unmarked numbers on
        // that board; in this case, the sum is 188. Then, multiply that sum by the number that was just called when
        // the board won, 24, to get the final score, 188 * 24 = 4512.
        assertThat(Day4.task1("_2021/day4-sample")).isEqualTo(4512);
        logger.info("answer to task1 = {}", Day4.task1("_2021/day4"));
    }
}
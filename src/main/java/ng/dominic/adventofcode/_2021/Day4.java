package ng.dominic.adventofcode._2021;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.function.Predicate.not;
import static ng.dominic.adventofcode.util.Reader.read;

public class Day4 {

    /*
    notes:
    data set has no negative numbers and has a range from 0 to 99

    the first read line are the numbers to be checked off

    assumptions:
    - only one board can win per draw (assignment doesn't state otherwise)
    - the order of checking boards goes from top to bottom, first one wins
    - each number on the board occurs only once per board
     */

    private Day4() {

    }

    public static int task1(String fileName) throws IOException {

        try (var reader = read(fileName)) {
            var draws = Arrays.stream(reader.readLine().split(",")).map(Integer::parseInt).toList();


            // read the next blocks of 5*5 numbers until the end and set aside as the bingo cards
            final AtomicInteger counter = new AtomicInteger();
            var boards = reader.lines()
                    .filter(not(String::isEmpty))
                    .collect(Collectors.groupingBy(it -> counter.getAndIncrement() / 5))
                    .values()
                    .stream()
                    .map(Day4::extractBoard)
                    .toList();

            for (Integer draw : draws) {
                for (Board board : boards) {
                    var result = board.handleDraw(draw);
                    if (result > -1) {
                        return result;
                    }
                }
            }
            return 0;
        }
    }

    private static Board extractBoard(List<String> lines) {
        var boardInput = lines.stream()
                .map(String::trim)
                .map(s -> s.split("\\s+"))
                .map(Arrays::asList)
                .map(s -> s.stream().map(Integer::valueOf).toList())
                .toList();
        return new Board(boardInput);
    }

    static class Board {

        private List<List<Integer>> scores;

        public Board(List<List<Integer>> scores) {
            this.scores = scores;
        }

        int handleDraw(int draw) {
            var isFound = scores.stream()
                    .flatMap(Collection::stream)
                    .filter(Objects::nonNull)
                    .anyMatch(it -> it == draw);

            if (isFound) {
                scores = removeScore(draw);

                if (checkHorizontal() || checkVertical()) {
                    var remainingScores = scores.stream().flatMap(Collection::stream)
                            .filter(n -> n > -1)
                            .reduce(0, Integer::sum);
                    return remainingScores * draw;
                }
            }
            return -1;
        }

        // some weird shit to get this done... (turns out it was the immutability of toList() that I didn't think of)
        List<List<Integer>> removeScore(int draw) {
            var array = scores.stream()
                    .map(it -> it.toArray(Integer[]::new))
                    .toArray(Integer[][]::new);
            for (int row = 0; row < array.length; row++) {
                for (int col = 0; col < array[row].length; col++) {
                    if (array[row][col] == draw) {
                        array[row][col] = -1;
                    }
                }
            }
            return Arrays.stream(array)
                    .map(Arrays::asList)
                    .toList();
        }

        boolean checkHorizontal() {
            // if scores contains draw, set that score to null
            // then check if bingo
            return scores.stream().anyMatch(a -> a.stream().allMatch(b -> b == -1));
        }

        boolean checkVertical() {
            var transposed = transpose(scores);
            return transposed.stream().anyMatch(a -> a.stream().allMatch(b -> b == -1));
        }

        public static <T> List<List<T>> transpose(List<List<T>> listList) {
            return IntStream.range(0, 4)
                    .mapToObj(i -> listList.stream().map(l -> l.get(i)).toList())
                    .toList();
        }

        @Override
        public String toString() {
            return "Board{" +
                    "scores=" + scores +
                    '}';
        }
    }

}

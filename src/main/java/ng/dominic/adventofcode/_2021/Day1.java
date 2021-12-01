package ng.dominic.adventofcode._2021;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static java.lang.String.format;

public class Day1 {

    private Day1() {
    }

    public static int countNumberOfIncreases(String filename) throws IOException {
        try (var reader = new BufferedReader(new FileReader(format("src/main/resources/%s.txt", filename)))) {
            int count = -1; // eerste regel telt niet mee
            int previous = 0;
            int current;
            for (String line; (line = reader.readLine()) != null; ) {
                current = Integer.parseInt(line);
                if (current > previous) {
                    count++;
                }
                previous = current;
            }
            return count;
        }
    }

    public static int countNumberOfIncreasedSlidingWindow(String filename) throws IOException {
        try (var reader = new BufferedReader(new FileReader(format("src/main/resources/%s.txt", filename)))) {
            var lines = reader.lines().map(Integer::parseInt).toList();
            int count = -1; // eerste telt niet mee
            int previous = 0;
            int current;
            for (int i = 0; i < lines.size() - 2; i++) {
                current = lines.get(i) + lines.get(i + 1) + lines.get(i + 2);
                if (current > previous) {
                    count++;
                }
                previous = current;
            }
            return count;
        }
    }
}

package ng.dominic.adventofcode._2021;

import java.io.IOException;
import java.util.List;

import static ng.dominic.adventofcode.util.Reader.read;

public class Day3 {

    private Day3() {
    }

    public static int task1(String fileName, int positions) throws IOException {
        try (var reader = read(fileName)) {
            var count = new int[positions];
            var lineCount = 0;
            for (String line; (line = reader.readLine()) != null; ) {
                if (line.length() != positions) {
                    throw new IllegalArgumentException("denk dat het aantal positions niet klopt");
                }
                var chars = line.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    count[i] = count[i] + Character.getNumericValue(chars[i]);
                }
                lineCount++;
            }
            StringBuilder g = new StringBuilder();
            StringBuilder e = new StringBuilder();
            for (int i = 0; i < count.length; i++) {
                // ik zie niet wat ik zou moeten doen bij een gelijk aantal 0 en 1 dus apart tellen
                g.append(count[i] > lineCount / 2 ? "1" : "0");
                e.append(count[i] < lineCount / 2 ? "1" : "0");
            }
            int gamma = Integer.parseInt(g.toString(), 2);
            int epsilon = Integer.parseInt(e.toString(), 2);
            return gamma * epsilon;
        }
    }

    // ik geef het op, dan maar lelijk!
    public static int task2(String fileName) throws IOException {
        try (var reader = read(fileName)) {
            var lines = reader.lines().toList();
            final var numberChar = lines.get(0).length();

            var c02lines = lines;

            var o2String = "";
            var oCol = 0;
            for (int i = 0; i < numberChar; i++) {
                var oneOrZero = getBitCriterium(lines, oCol, true);
                int finalCol = oCol;
                lines = lines.stream()
                        .filter(s -> oneOrZero.equals(s.charAt(finalCol)))
                        .toList();
                if (lines.size() == 1) {
                    o2String = lines.get(0);
                    break;
                }
                oCol++;
            }
            var cO2String = "";
            var cCol = 0;
            for (int j = 0; j < numberChar; j++) {
                var oneOrZero = getBitCriterium(c02lines, cCol, false);
                int finalCCol = cCol;
                c02lines = c02lines.stream()
                        .filter(s -> oneOrZero.equals(s.charAt(finalCCol)))
                        .toList();
                if (c02lines.size() == 1) {
                    cO2String = c02lines.get(0);
                    break;
                }
                cCol++;
            }
            return Integer.parseInt(o2String, 2) * Integer.parseInt(cO2String, 2);
        }
    }

    private static Character getBitCriterium(List<String> lines, int kolomindex, boolean isOxygen) {
        var count = lines.stream()
                .map(line -> line.charAt(kolomindex))
                .mapToInt(Character::getNumericValue)
                .sum();
        if (isOxygen) {
            return count >= (lines.size() + 1) / 2 ? '1' : '0';
        }
        return count < (lines.size() + 1) / 2 ? '1' : '0';
    }
}

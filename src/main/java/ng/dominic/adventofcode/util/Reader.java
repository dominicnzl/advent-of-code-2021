package ng.dominic.adventofcode.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static java.lang.String.format;

public class Reader {

    private Reader() {
    }

    public static BufferedReader read(String filename) throws FileNotFoundException {
        return new BufferedReader(new FileReader(format("src/main/resources/%s.txt", filename)));
    }
}

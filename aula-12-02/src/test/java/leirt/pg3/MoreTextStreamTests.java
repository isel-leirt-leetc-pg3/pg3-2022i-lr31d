package leirt.pg3;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class MoreTextStreamTests {

    @Test
    public void countLines_test() throws IOException {
        String sourceName = "input.txt";

        try (BufferedReader reader =
                 new BufferedReader(new FileReader(sourceName))) {

            int count = TextStreamUtils.countLines(reader);
            System.out.format("%s has %d lines!\n",
                sourceName, count);
        }
    }
}

package leirt.pg3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;
import static leirt.pg3.ListUtils.*;

public class StreamUtils {

    public static List<String> lines(BufferedReader reader) {
        try {
            String line;
            List<String> lines = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            return lines;
        }
        catch(IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static List<String> findStr(BufferedReader reader,
                                       String word)
        throws IOException {
        String line;
        List<String> occurrences = new ArrayList<>();

        while((line = reader.readLine()) != null) {
            if (line.contains(word))
                occurrences.add(line);
        }
        return occurrences;
    }

    private  int val;

    public  List<String> findStr2(BufferedReader reader,
                                       String word) {
        List<String> lines = lines(reader);
        Predicate<String> pred = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains(word) &&
                    (StreamUtils.this.val %2) == 0;
            }
        };


        return filter(lines, s -> {
            return s.contains(word) && (this.val %2) == 0;
        });

    }

    public  List<String> findStr3(BufferedReader reader,
                                  String word) {
        return filter(lines(reader), s -> s.contains(word));
    }

    public  List<String> findStr4(BufferedReader reader,
                                  String word) {
        return reader
               .lines()
               .filter(s -> s.contains(word))
               .collect(toList());
    }


    public long totalChars(List<String> words) {
        return sum(
            map(words, w -> w.length())
        );
    }
}

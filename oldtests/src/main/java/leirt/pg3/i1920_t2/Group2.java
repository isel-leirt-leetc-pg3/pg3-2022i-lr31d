package leirt.pg3.i1920_t2;

import java.io.*;

import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Group2 {

    public static void foreachLineIf( BufferedReader in,
                                      Function<String, Date> getDateInLine,
                                      Predicate<Date> filter,
                                      BiConsumer<String, Date > action
    ) throws IOException {
        String line;

        while((line = in.readLine()) != null) {
            Date d = getDateInLine.apply(line);
            if (filter.test(d))
                action.accept(line, d);
        }
    }

    private static Date getDate(String line) {
        String[] parts = line.split(" ");
        return new Date(parts[2]);
    }

    public static void acceptIf(String filenameIn, Date d, BiConsumer<String, Date> action)
        throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader(filenameIn))) {
            foreachLineIf(reader,
                          Group2::getDate,
                          df -> df.equals(d), action);
        }
    }


    public static void copyRegisters( String filenameIn, String filenameOut) throws IOException {
        try(PrintWriter writer = new PrintWriter(new FileWriter(filenameOut))) {
            acceptIf(filenameIn,
                     new Date(),
                     (s, d) -> writer.println(s));
        }
    }
}

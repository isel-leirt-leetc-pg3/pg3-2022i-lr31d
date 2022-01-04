package leirt.pg3;

import java.io.*;

public class StreamUtils {
    public static int copyWithReplace(Reader in, Writer out)
        throws IOException {
        int c;
        int totalDots = 0;

        StringBuilder digits = new StringBuilder();
        while((c = in.read()) != -1) {
            while (Character.isDigit(c)) {
                digits.append((char) c);
                c = in.read();
            }
            if (digits.length() > 0) {
                out.write(convert(digits.toString()));
                totalDots += (digits.length() -1 ) / 3;
                digits.setLength(0);
            }
            if (c == -1) break; // EOF
            out.write(c);
        }
        return totalDots;
    }

    private static String convert(String  digits) {
        StringBuilder withDots = new StringBuilder();
        int dotIndex = 3 - (digits.length() % 3);
        for (int i=0; i < digits.length(); ++i) {
            if (dotIndex == 3) {
                dotIndex = 0;
                if (i> 0) withDots.append('.');
            }
            dotIndex++;
            withDots.append(digits.charAt(i));
        }
        return withDots.toString();
    }

    public static void copyWithReplace(String fileIn, String fileOut)
        throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader(fileIn));
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileOut))) {
            copyWithReplace(reader, writer);
        }
    }
}

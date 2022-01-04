package leirt.pg3;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StreamUtilsTests {
    private static final int BUFSIZE = 4096;

    private boolean equalArrays(byte[] a1, byte[] a2, int s1, int s2) {
        if (s1 != s2) return false;
        int i=0;
        while (i < s1 && a1[i] == a2[i]) ++i;
        return i==s1;
    }

    private boolean equalContent(String file1Name, String file2Name)
        throws IOException {
        File file1 = new File(file1Name);
        File file2 = new File(file2Name);
        if (file1.length() != file2.length()) return false;
        try(InputStream s1 = new FileInputStream(file1Name);
            InputStream s2 = new FileInputStream(file2Name)) {
            byte[] buf1 = new byte[BUFSIZE];
            byte[] buf2 = new byte[BUFSIZE];
            int r1;
            do {
                r1 = s1.read(buf1, 0, BUFSIZE);
                int r2 = s2.read(buf2, 0, BUFSIZE);
                if(r1 == -1 && r2 == -1) break;
                if (!equalArrays(buf1,buf2, r1, r2)) return false;
            }
            while(r1 > 0);
            return true;
        }
    }

    @Test
    public void simple_copy_with_replace_tests()
        throws IOException {
        String original = "abc12345678def";
        String expected = "abc12.345.678def";
        int expectedDots = 2;
        StringReader reader = new StringReader(original);
        StringWriter writer = new StringWriter();

        int nDots = StreamUtils.copyWithReplace(reader, writer);
        System.out.println("nDots= " + nDots );
        System.out.println("dotted string= " + writer  );

        assertEquals(expected, writer.toString());
        assertEquals(expectedDots, nDots);
    }

    @Test
    public void file_copy_with_replace_test()
        throws IOException {
        String inFileName = "nodots.txt";
        String outFileName = "converted.txt";
        String expectedFileName = "withdots.txt";

        StreamUtils.copyWithReplace(inFileName, outFileName);

        assertTrue(equalContent(outFileName, expectedFileName));
    }
}

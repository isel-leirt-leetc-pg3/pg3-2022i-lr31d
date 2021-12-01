import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Path;

public class BinaryStreamsTests {

    private static void copyTo(FileInputStream in,
                               FileOutputStream out)
        throws IOException {
        int c;

        while((c = in.read()) != -1) {
            out.write(c);
        }
    }

    private static void copyToFast(FileInputStream in,
                               FileOutputStream out)
        throws IOException {
        byte[] buf = new byte[4096];
        int read;

        while((read = in.read(buf)) > 0) {
            out.write(buf, 0, read );
        }
    }


    @Test
    public void use_copyTo_for_file_copy_using_try_with_resources()
        throws IOException {

        String cwd = Path.of("").toAbsolutePath().toString();
        System.out.println(cwd);
        String sourceName = "input.dat";
        String dstName = "output.dat";


        try (FileInputStream inFile = new FileInputStream(sourceName);
             FileOutputStream outFile = new FileOutputStream(dstName)) {

            copyTo(inFile, outFile);
        }
    }

    @Test
    public void use_copyToFast_for_file_copy_using_try_with_resources()
        throws IOException {

        String cwd = Path.of("").toAbsolutePath().toString();
        System.out.println(cwd);
        String sourceName = "input.dat";
        String dstName = "output.dat";


        try (FileInputStream inFile = new FileInputStream(sourceName);
             FileOutputStream outFile = new FileOutputStream(dstName)) {

            copyToFast(inFile, outFile);
        }
    }

}

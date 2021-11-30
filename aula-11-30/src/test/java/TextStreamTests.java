import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Path;

public class TextStreamTests {

    private static void copyTo(Reader reader, Writer writer)
                        throws IOException  {
        int c;

        while((c = reader.read()) != -1) {
            writer.write(c);
        }
    }

    @Test
    public void use_copy_to_for_file_copy()
        throws IOException {

        String cwd = Path.of("").toAbsolutePath().toString();
        System.out.println(cwd);
        String sourceName = "input.txt";
        String dstName = "output.txt";
        FileReader inFile = null;
        FileWriter outFile = null;
        try {
            inFile = new FileReader(sourceName);
            outFile = new FileWriter(dstName);

            copyTo(inFile, outFile);

        }
        finally {
            if (inFile != null) inFile.close();
            if (outFile != null) outFile.close();
        }
    }

    @Test
    public void use_copy_to_for_file_copy_use_try_with_resources()
        throws IOException {

        String cwd = Path.of("").toAbsolutePath().toString();
        System.out.println(cwd);
        String sourceName = "input.txt";
        String dstName = "output.txt";

        try (FileReader inFile = new FileReader(sourceName);
             FileWriter outFile = new FileWriter(dstName)) {

            copyTo(inFile, outFile);
        }
    }

}

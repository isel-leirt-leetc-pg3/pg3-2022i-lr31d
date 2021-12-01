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
    public void use_copyTo_for_file_copy_no_forced_close()
                        throws IOException {
        String cwd = Path.of("").toAbsolutePath().toString();
        System.out.println(cwd);
        String sourceName = "input.txt";
        String dstName = "output.txt";


        // what if an exception ocurrs between lines 27 and 31
        // no close is done!
        // Bad thing!
        FileReader inFile = new FileReader(sourceName);
        FileWriter outFile = new FileWriter(dstName);


        copyTo(inFile, outFile);

        inFile.close();
        outFile.close();
    }


    @Test
    public void use_copyTo_for_file_copy_with_forced_close()
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
            // block finally is guaranteed to execute in any circumstance,
            // throwing try block an exception or not. Good!
            // But what happens if  inFile.close() throws an exception?
            // Short answer: the outFile is not closed!
            // It is difficult to do this well. Must exist an easier way!
            // the answer is try with resources presented below.
            if (inFile != null) inFile.close();
            if (outFile != null) outFile.close();
        }
    }

    @Test
    public void use_copyTo_for_file_copy_using_try_with_resources()
        throws IOException {

        String cwd = Path.of("").toAbsolutePath().toString();
        System.out.println(cwd);
        String sourceName = "input.txt";
        String dstName = "output.txt";

        // this try variant, named try-with-resources, is
        // the automated way given by java to guarantee that the resources
        // (inFile and outFile in this case) are closed in any circumstance.
        // Simple and good!
        try (FileReader inFile = new FileReader(sourceName);
             FileWriter outFile = new FileWriter(dstName)) {

            copyTo(inFile, outFile);
        }
    }

}

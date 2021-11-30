import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOError;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Path;

public class WriterTests {

    private void  writeTo(String fileName, String content )
            throws IOException {
        try(Writer writer = new FileWriter(fileName, false)) {
            writer.write(content);
        }
    }

    private void  appendTo(String fileName, String content )
        throws IOException {
        try(Writer writer = new FileWriter(fileName, true)) {
            writer.append(content);
        }
    }

    @Test
    public void two_times_write_writer() throws IOException{
        String cwd = Path.of("").toAbsolutePath().toString();
        System.out.println(cwd);
        String fileOut = "testfile.txt";

        //writeTo(fileOut, "A primeira linha\n");
        //writeTo(fileOut, "A segunda linha\n");
    }

    @Test
    public void two_times_append_writer() throws IOException{
        String cwd = Path.of("").toAbsolutePath().toString();
        System.out.println(cwd);
        String fileOut = "testfile.txt";

        appendTo(fileOut, "A primeira linha\n");
        appendTo(fileOut, "A segunda linha\n");
    }

}

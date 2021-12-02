import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOError;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Path;

public class WriterTests {

    private void  writeTo(String fileName, String content, boolean appendMode )
            throws IOException {
        try(Writer writer = new FileWriter(fileName, appendMode)) {
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
    public void two_times_write_writer_no_append_mode() throws IOException{
        String cwd = Path.of("").toAbsolutePath().toString();
        System.out.println(cwd);
        String fileOut = "testfile.txt";

        writeTo(fileOut, "A primeira linha\n", false );
        writeTo(fileOut, "A segunda linha\n", false);
    }

    @Test
    public void two_times_write_writer_with_append_mode() throws IOException{
        String cwd = Path.of("").toAbsolutePath().toString();
        System.out.println(cwd);
        String fileOut = "testfile.txt";

        writeTo(fileOut, "A primeira linha\n", true );
        writeTo(fileOut, "A segunda linha\n", true);
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

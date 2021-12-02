package leirt.pg3;

import java.io.BufferedReader;
import java.io.IOException;

public class TextStreamUtils {

    /**
     * contar as linhas de uma stream de texto
     */
    public static int countLines(BufferedReader reader)
        throws IOException {
        String line = null;
        int count = 0;
        while((line = reader.readLine()) != null) {
            count++;
        }
        return count;
    }

}

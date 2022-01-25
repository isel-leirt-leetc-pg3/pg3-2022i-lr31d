package leirt.pg3.i2021_t2;

import java.io.*;
import java.util.function.Consumer;

public class Group3 {
    // Grupo III a)
    public static int punctuationsOf(BufferedReader in, String playerName, Consumer<String> action )
            throws IOException {
        String line;
        int count = 0;
        while ((line = in.readLine()) != null ) {
            int index =  line.indexOf( ':');
            if ( index != -1 ) {
                int cmp = line.substring(0, index).compareTo( playerName);
                if ( cmp >= 0 ) {
                    if (cmp > 0 ) break;
                    action.accept(line.substring(index + 1).trim());
                    ++count;
                }
            }
        }
        return count;
    }

    // Grupo III a)
    public static void copyPunctuation(String pathnameIn, PrintWriter pw, String playerName ) throws IOException {
        try(BufferedReader br = new BufferedReader(new FileReader( pathnameIn ))) {
            punctuationsOf(br, playerName, pw::println);
        }
    }

    /* <<  Exemplo de utilização >> */
    public static void main(String[] args) throws IOException {
        StringReader sw = new StringReader( "Afonso Gil: 310 03:50\n" +
                                              "Nuno Santos: 350 03:20\n" +
                                              "Nuno Santos:  250 01:50\n" +
                                              "Rui Gaspar: 400 03:30\n" );
        punctuationsOf(new BufferedReader( sw ), "Nuno Santos", System.out::println);

        String filename = "src\\testes\\test2\\players.txt";
        // Cria o ficheiro "punctuations.txt" em que coloca numa linha o nome do jogador e nas seguintes as
        // pontuações do jogador. Para escrever a pontuação do jogador usa o metodo a alinea b)
        try ( PrintWriter pw = new PrintWriter( "src\\testes\\test2\\punctuations.txt")) {
            pw.println("Nuno Santos: ");                            // Escreve o nome
            copyPunctuation(filename, pw, "Nuno Santos"); // Escreve as pontuações
            pw.println("Afonso Gil: ");
            copyPunctuation(filename, pw, "Afonso Gil");
            pw.println("Rui Gaspar: ");
            copyPunctuation(filename, pw, "Rui Gaspar");
        }
    }

}

package leirt.pg3.maps;

import java.io.*;
import java.util.*;

public class CrossReference {
    private final Map<String, List<Integer>> words;

    public CrossReference() {
        words = new TreeMap<>();
    }

    private void newWord(String word, int lineNumber) {
        if (word.length() < 3) return;
        word = word.toLowerCase();

        List<Integer> occurrences = words.get(word);
        if (occurrences == null) {
            occurrences = new ArrayList<>();
            words.put(word, occurrences);
        }
        occurrences.add(lineNumber);
    }

    public void load(BufferedReader reader) throws IOException {
        int ln = 0;
        String line;

        while((line = reader.readLine()) != null) {
            ln++;
            String[] lineWords = line.split("[^a-zA-Z]");
            for (String w : lineWords)
                newWord(w, ln);
        }
    }

    public void load(String fileName)
        throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            load(reader);
        }
    }

    public void save(Writer writer) {
        // throws IOException {
        PrintWriter pw = new PrintWriter(writer);
        for(Map.Entry<String, List<Integer>> entry : words.entrySet())  {
            pw.format("%-20s: ", entry.getKey());
            for(int ln : entry.getValue()) {
                pw.print(ln);
                pw.write(" ");
            }
            pw.println();
        }
        pw.flush();
    }

    public static void main(String[] args) {
        String durFile = "dud_en.txt";
        try {
            CrossReference cross = new CrossReference();

            cross.load(durFile);
            cross.save(new PrintWriter(System.out));
        }
        catch(IOException e) {
            System.out.println("error reading file " + durFile );
        }
    }
}

package leirt.pg3.i2021_t2;

public interface Punctuation extends Comparable< Punctuation > {
    int getScore(); // Número de pontos
    int getTime();  // Tempo
    String toString();// Descrição
}

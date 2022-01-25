package leirt.pg3.i2021_t2;

import java.util.*;

public class Group2 {
    // Grupo II a)
    public static Collection<Punctuation> remove(Player p, Punctuation min ) {
        LinkedHashSet<Punctuation> result = new LinkedHashSet<>();
        p.punctuations().removeIf( pt -> {
            if ( pt == null) return true;
            if ( pt.compareTo( min ) < 0 ) { result.add( pt); return true; }
            return false;
        });
        return result;
    }

    // Grupo II b)
    public static Map<Integer, Integer> bestsTimes(Player p ) {
        Map<Integer, Integer> result = new TreeMap<>( Comparator.reverseOrder());
        for (Punctuation pt: p.punctuations() ) {
            Integer i = result.get( pt.getScore() );
            if ( i == null ||  pt.getTime() < i) result.put( pt.getScore(), pt.getTime());

        }
        return result;
    }

    /* <<  Exemplo de utilização >> */
    private static class P implements Punctuation { // Classe para teste
        private final int score, time;
        P(int s, int t) { score = s; time = t; }
        public int getTime()  { return time;  }
        public int getScore() { return score; }
        public int compareTo(Punctuation p)
        {  return score == p.getScore() ? p.getTime() - time : score - p.getScore(); }
        public boolean equals(Object o) {
            if (!(o instanceof Punctuation)) return false;
            Punctuation p = (Punctuation) o;
            return score == p.getScore() && time == p.getTime();
        }
        public String toString() { return String.format("%d %d:%d", score, time/60, time%60);}
    }

    public static void main(String[] args) {
       List<Punctuation> unmodifiableList = List.of(
               new P(3,30), new P(6, 20 ), new P(7, 10),
               new P(2,20), new P(3, 10), new P(7, 5), new P(2, 15));
       List<Punctuation> list = new ArrayList<>(unmodifiableList);
       var player = new Player() {
            public String getName()                       { return "Nuno"; }
            public Collection<Punctuation> punctuations() { return list;   }
       };

       System.out.println( remove(player, new P(3, 20)) );
       System.out.println( player.punctuations());


       list.clear(); list.addAll(unmodifiableList );
       var res =  bestsTimes( player );
       System.out.println( res.keySet() );
       System.out.println( res );
    }
}

package leirt.pg3.i1920_t2;

import leirt.pg3.i1920_t2.types.Group;
import leirt.pg3.i1920_t2.types.Register;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


public class Group1 {

    public static <Key> Key greaterKey(Group group,
                         Predicate<Register> filter,
                         Function<Register, Key> regToKey,
                         Comparator<Key> cmp ) {
            Key greatest = null;
            for(Register reg : group.registers()) {
                if (filter.test(reg)) {
                    Key currKey = regToKey.apply(reg);
                    if (greatest == null || cmp.compare(currKey, greatest) > 0)
                        greatest = currKey;
                }
            }
            return greatest;
    }

    public static Date firstDate(Group group) {

        return greaterKey(group,
                         r -> r.isVaccinateInDay(),
                         // em alternativa poder-se-ia usar um method reference como mostra abaixo
                         //Register::isVaccinateInDay,
                         r -> r.getNextVaccinate(),
                         (d1, d2) -> d2.compareTo(d1));
    }

    public static SortedMap<Date, List<Register>> registersPerDate(
        Group group, Supplier< List<Register> > listForRegisters ) {

        SortedMap<Date, List<Register> > map = new TreeMap<>();

        for(Register r : group.registers()) {
            List<Register> sameDateRegisters = map.get(r.getNextVaccinate());
            if (sameDateRegisters == null) {
                map.put(r.getNextVaccinate(), sameDateRegisters =listForRegisters.get());
            }
            sameDateRegisters.add(r);
        }

        return map;
    }

    public static Iterable<Register> getAllRegisters( SortedMap<Date, List<Register>> registersPerData ) {
        List<Register> allRegisters = new ArrayList<>();

        for(List<Register> regForDate: registersPerData.values()) {
            // psra criar o comparador usa-se um método estático de Comparator que
            // usa para comparação o valor retornado pelo método getRegisterNumber
            // também podia ser feita uma implementação do comparador como mostra o código
            // comentado na linha seguinte
            //regForDate.sort( (r1, r2) -> r1.getRegisterNumber() - r2.getRegisterNumber());
            regForDate.sort( Comparator.comparing(Register::getRegisterNumber));
            allRegisters.addAll(regForDate);
        }
        return allRegisters;
    }


}

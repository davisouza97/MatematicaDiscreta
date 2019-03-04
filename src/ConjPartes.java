
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class ConjPartes {

    void teste(ArrayList a){
        ArrayList<Integer> conjuntoEntrada = a;
        
        ArrayList<SortedSet<Comparable>> conjuntoDasPartes = new ArrayList<>(); //aqui vai ficar a resposta
        for (Integer item : conjuntoEntrada) {
            conjuntoDasPartes.add(new TreeSet<Comparable>(Arrays.asList(item))); //insiro a combinação "1 a 1" de cada item
        }
        for (int i = 1; i < conjuntoEntrada.size(); i++) {
            List<SortedSet<Comparable>> statusAntes = new ArrayList<>(conjuntoDasPartes); //crio uma cópia para poder não iterar sobre o que já foi
            for (Set<Comparable> antes : statusAntes) {
                SortedSet<Comparable> novo = new TreeSet<>(antes); //para manter ordenado os objetos dentro do set
                novo.add(conjuntoEntrada.get(i));
                if (!conjuntoDasPartes.contains(novo)) { //testo para ver se não está repetido
                    conjuntoDasPartes.add(novo);
                }
            }
        }
        Collections.sort(conjuntoDasPartes, new Comparator<SortedSet<Comparable>>() { //aqui só para organizar a saída de modo "bonitinho"
            @Override
            public int compare(SortedSet<Comparable> o1, SortedSet<Comparable> o2) {
                int sizeComp = o1.size() - o2.size();
                if (sizeComp == 0) {
                    Iterator<Comparable> o1iIterator = o1.iterator();
                    Iterator<Comparable> o2iIterator = o2.iterator();
                    while (sizeComp == 0 && o1iIterator.hasNext()) {
                        sizeComp = o1iIterator.next().compareTo(o2iIterator.next());
                    }
                }
                return sizeComp;
            }
        });
        System.out.println(conjuntoDasPartes);
    }
}

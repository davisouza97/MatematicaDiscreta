
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        ArrayList<Conjunto> conjuntos = new ArrayList<>();
        ArrayList<Elemento> elementos = new ArrayList<>();

        Scanner input = new Scanner(System.in);
        System.out.println("Informe o nome do arquivo");
        String nomeArquivo = input.nextLine();
        FileReader arq = new FileReader(nomeArquivo + ".txt");
        BufferedReader lerArq = new BufferedReader(arq);

        String linha = lerArq.readLine();

        while (linha != null) {
            if (identificador(linha).equalsIgnoreCase("conjunto")) {
                conjuntos.add(new Conjunto(linha));
            } else if (identificador(linha).equalsIgnoreCase("elemento")) {
                elementos.add(new Elemento(linha));
            }
            linha = lerArq.readLine();
        }

        arq.close();
        int menu = 99;
        do {
            System.out.println("");
            System.out.println("----------------MENU----------------");
            System.out.println("        1- Pertence ( \u2208 ) ou Não Pertence ( \u2209 )");
            System.out.println("        2- Contido ou igual( \u2286 )/Não contido ou igual (\u2288)");
            System.out.println("        3- Contido propriamente ( \u2282 )/ Não contido propriamente ( \u2284 )");
            System.out.println("        4- União (\u222a)");
            System.out.println("        5- Interseção (\u2229)");       // feito ate aqui//verificar utilizacao de outros metodos no 4 igual feito no cinco
            System.out.println("        6- Produto Cartesiano (x)");
            System.out.println("        7- Conjunto das Partes (P(A))");
            System.out.println("        0- para SAIR ");
            System.out.println("-------------------------------------");
            menu = input.nextInt();
            if (menu == 1) {
                Pertence(conjuntos.get(0), elementos.get(0));
            }
            if (menu == 2 || menu == 3) {
                Contido(conjuntos.get(0), conjuntos.get(1));
            }
            if (menu == 4) {
                Uniao(conjuntos);
            }
            if (menu == 5) {
                Intersecao(conjuntos);
            }
            if (menu == 6) {
                ProdutoCartesiano(conjuntos);
            }
            if (menu == 7) {
                ConjuntoPartes(conjuntos);
            }
        } while (menu != 0);
    }

    public static String identificador(String x) {
        x.trim();
        if (Character.isLowerCase(x.charAt(0))) {
            return "elemento";
        } else {
            return "conjunto";
        }
    }

    private static boolean Pertence(Conjunto c, Elemento e) {
        boolean pertence = false;
        for (Integer i : c.elementos) {
            if (e.valor == i) {
                pertence = true;
                break;
            }
        }
        if (pertence) {
            System.out.println(e + " \u2208 " + c);
        } else {
            System.out.println(e + " \u2209 " + c);
        }
        return pertence;
    }

    private static boolean Contido(Conjunto c1, Conjunto c2) {
        boolean contido = false;
        for (Integer a : c1.elementos) {            //verifica se cada elemento de c1 esta em c2
            contido = false;
            for (Integer b : c2.elementos) {
                if (Objects.equals(a, b)) {
                    contido = true;
                }
            }
            if (!contido) {
                break;
            }
        }
        if (contido) {
            if (Contido(c2, c1)) {
                System.out.println(c1 + "\u2282 " + c2);    //contido propriamente
            } else {
                System.out.println(c1 + "\u2286" + c2);   //contido ou igual
            }
        } else {
            System.out.println(c1 + "\u2288" + c2);         //VERIFICAR DIFERENCA DE NAO CONTIDO E DENAO CONTIDO PROPRIAMENTE 
        }
        return contido;
    }

    private static void Uniao(ArrayList<Conjunto> conjuntos) {
        Conjunto uniao = new Conjunto();
        uniao.setNome("Conjunto Uniao");
        for (Conjunto c : conjuntos) {
            for (Integer i : c.elementos) {
                uniao.addElemento(i);
            }
        }
        for (int i = 0; i < conjuntos.size(); i++) {
            System.out.print(conjuntos.get(i).nome);
            if (i != conjuntos.size() - 1) {
                System.out.print(" \u222a ");
            }
        }
        System.out.println("");
        System.out.println(uniao.imprime());
    }

    private static void Intersecao(ArrayList<Conjunto> conjuntos) {
        Conjunto intersecao = new Conjunto();
        intersecao.setNome("Conjunto Intersecao");
        boolean pertence = true;
        for (Conjunto c : conjuntos) {
            for (Integer i : c.elementos) {
                pertence = true;
                for (Conjunto conjunto : conjuntos) {
                    if (!Pertence(conjunto, new Elemento(i))) {
                        pertence = false;
                        break;
                    }
                }
                if (pertence) {
                    intersecao.addElemento(i);
                }
            }
        }

        for (int i = 0; i < conjuntos.size(); i++) {
            System.out.print(conjuntos.get(i).nome);
            if (i != conjuntos.size() - 1) {
                System.out.print(" \u2229 ");
            }
        }
        System.out.println("");
        System.out.println(intersecao.imprime());

    }

    private static void ProdutoCartesiano(ArrayList<Conjunto> conjuntos) {
        ClasseProdutoCartesiano pc = new ClasseProdutoCartesiano();
        Conjunto a = conjuntos.get(0);
        Conjunto b = conjuntos.get(1);
        for (Integer itensA : a.elementos) {
            for (Integer itensB : b.elementos) {
                pc.adicionar(itensA, itensB);
            }
        }
        System.out.println("Produto Cartesiano " + a +" \u2716 "+b+" = {");
        for (String itensPc : pc.itens) {
            System.out.print("\u276e");
            System.out.print(itensPc);
            System.out.print("\u2771");
        }
        Scanner input = new Scanner(System.in);
        System.out.println("");
        System.out.println("Reverter operação?(s/n)");
        String reverter = input.next();
        if (reverter.equalsIgnoreCase("s")) {
            Conjunto aReverso = new Conjunto();
            Conjunto bReverso = new Conjunto();
            for (String c : pc.itens) {
                int index = c.indexOf(",");
                aReverso.addElemento(Integer.parseInt(c.substring(0, index)));
                bReverso.addElemento(Integer.parseInt(c.substring(index+1)));
            }
            System.out.print("Primeiro conjunto revertido = ");
            System.out.println(aReverso.imprime());
            System.out.print("Segundo conjunto revertido = ");
            System.out.println(bReverso.imprime());
        }
    }

    private static void ConjuntoPartes(ArrayList<Conjunto> conjuntos) {
        Conjunto a = conjuntos.get(0);
        ConjPartes cp = new ConjPartes();
        cp.teste(a.elementos);
        
    
    
    
    
    
    
    
    
 
    
    }
}

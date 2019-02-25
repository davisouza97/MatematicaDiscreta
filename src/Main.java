
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        ArrayList<Conjunto> conjuntos = new ArrayList<>();
        ArrayList<Elemento> elementos = new ArrayList<>();

        Scanner ler = new Scanner(System.in);
        System.out.println("Informe o nome do arquivo");
        String nomeArquivo = ler.nextLine();
        FileReader arq = new FileReader(nomeArquivo+".txt");
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
            System.out.println("        1- Pertence");
            System.out.println("        2- Não Pertence");
            System.out.println("        3- Contido ou igual");
            System.out.println("        4- Não contido ou igual");
            System.out.println("        5- Contido propriamente");
            System.out.println("        6- Não contido propriamente");
            System.out.println("        7- União");
            System.out.println("        8- Interseção");
            System.out.println("        9- Produto Cartesiano (x)");
            System.out.println("        10- Conjunto das Partes (P(A))");
            System.out.println("        0- para SAIR ");
            System.out.println("-------------------------------------");
            menu = ler.nextInt();
        }while (menu != 0); 
            
        
    }

    public static String identificador(String x) {
        x.trim();
        if (Character.isLowerCase(x.charAt(0))) {
            return "elemento";
        } else {
            return "conjunto";
        }
    }
}

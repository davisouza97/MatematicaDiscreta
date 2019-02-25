public class Elemento {
    String nome;
    Integer valor;
    Elemento(String linha) {
        nome = ""+linha.charAt(0);
        int index = linha.indexOf("=")+1;
        valor = Integer.parseInt(linha.substring(index+1));
    }

    @Override
    public String toString() {
        return nome + " = " + valor;
    }
    
    
}

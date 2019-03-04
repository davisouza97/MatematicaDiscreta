public class Elemento {
    String nome;
    Integer valor;
    Elemento(String linha) {
        linha = linha.replace(" ", "");
        nome = ""+linha.charAt(0);
        int index = linha.indexOf("=");
        valor = Integer.parseInt(linha.substring(index+1));
    }

    Elemento(Integer i) {
        valor = i;
    }
 
    public String imprime(){
    return nome +" = "+valor;
    }
    
     @Override
    public String toString() {
        return nome;
    }
}

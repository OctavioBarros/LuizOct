import java.util.Scanner;

public class MatrizMain{
   public static void main(String[] args){
      Scanner ler = new Scanner(System.in);
      
      System.out.print("Digite o numero de linhas da matriz: ");
      int linhas = ler.nextInt();
      System.out.print("\nDigite o numero de colunas da matriz: ");
      int colunas = ler.nextInt();
     
      int[][] matriz = new int[linhas][colunas];
      
      Matriz matrix = new Matriz();
      
            
       System.out.println("\nPreenchendo a matriz: ");
       for(int i=0; i<matriz.length; i++){
         for(int j=0; j<matriz[i].length; j++){
           System.out.println("Digite o valor da linha "+ (i+1) +" e coluna "+ (j+1) + " : ");
           matriz[i][j] = ler.nextInt();
          }
       }
       
      matrix.setMatriz(matriz);
      matrix.print();
      System.out.print("\nMatriz get: " + matrix.getMatriz());
      matrix.getPrincipal();
      matrix.getSecundaria();
      matrix.printDiagonais();
      int[][] matriz2 = {{1,3,2},{5,4,6},{1,0,-4}};
      //matrix.subtraiMatriz(matriz2);
      //matrix.somaMatriz(matriz2);
      //matrix.print();
      //matrix.multiplicaMatriz(matriz2);
      //matrix.ehInvertivel();
      //matrix.getOposta();
      //matrix.getTransposta();
      
      matrix.getInversa();
      matrix.print();
   }
      
}
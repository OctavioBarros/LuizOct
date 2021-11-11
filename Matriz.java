/*

Disciplina: Estrutura da dados - Unifaminas
Professor: Flávio Motta
Aluno:Luiz Octávio Barros Rodrigues
Entrega: 28/03/2021
Descrição: Preencher todos os métodos da classe matriz de acordo com suas descrições
Esta classe não pode conter um método main. Para testar suas implementações favor criar uma nova classe.

*/

import java.lang.Math;

public class Matriz{
   private int[][] matriz;

   
   //Método get da matriz da classe
   public int[][] getMatriz(){
     return matriz; //Retorna o endereço da matriz da classe
   }
   
   //Método set da matriz da classe
   public void setMatriz(int[][] matrizRecebida){
     matriz = new int[matrizRecebida.length][]; //matriz da classe recebe o numero de linhas da matrizRecebida
     
     for (int i=0; i<matrizRecebida.length; i++){
      matriz[i] = new int[matrizRecebida[i].length];//linha "i" da matriz da classe recebe a quantidade de colunas da Matriz Recebida 
       for (int j=0; j<matriz[i].length; j++){
         matriz[i][j] = matrizRecebida[i][j];//Matriz da classe recebe o valor da Matriz Recebida.
       }
     }       
   }
    
   //Verifica se a Matriz da classe e quadrada e retorna a sua dimensão
   private int matrizQuadrada(){
      if(matriz.length == matriz[0].length){
         return matriz.length;
      }
      else
         return 0;   
   }

   //Método que retorna como vetor a diagonal principal
   public int[] getPrincipal(){
      int []DiagonalP = new int[matriz.length];//Declarando o vetor
      for(int i=0; i<matriz.length; i++){
         for(int j=0; j<matriz[i].length; j++){
            if(j==i){//Confere se o laço passa pelo indice da diagonal principal
               DiagonalP[i] = matriz[i][j];
            }
         }
      }
      return DiagonalP; //Retorna o endereço da diagonal principal
   }
   
   //Método que retorna como vetor a diagonal secundaria
   public int[] getSecundaria(){
      int []DiagonalS = new int[matriz.length];
      int aux = matriz.length - 1; //Auxiliar para encontrar a secundaria, recebe o tamanho da matriz da classe -1
      
      for(int i=0; i<matriz.length; i++){
         for(int j=0; j<matriz[i].length; j++){
            if(aux == j){
               DiagonalS[i] = matriz[i][j];
               aux -= 1;
            }
         }
      }
      return DiagonalS; //Retorna o endereço da diagonal secundária
   }
   
   /*
   Método para imprimir a diagonal principal e a secundária
   Utilizar os métodos getPrincipal e getSecundaria
   */
   public void printDiagonais(){ //Mudei pra void, pois apenas imprime, então não deve retornar nada
      int verificador = matrizQuadrada();
      if(verificador > 0){
         int[] DiagonalP = getPrincipal(); //DiagonalP recebendo o endereço da Diagonal Principal
         int[] DiagonalS = getSecundaria(); //DiagonalS recebendo o endereço da Diagonal Secundaria
      
         System.out.println("\nDiagonal Principal: ");
         System.out.print("[ ");
         for(int i=0; i<DiagonalP.length; i++){
            System.out.print(DiagonalP[i]);
            if(i+1<DiagonalP.length){ //Verifica se o laço acaba, caso não, imprime uma virgula.
               System.out.print(" , ");
            }
         }
         System.out.print(" ]\n");
      
         System.out.println("\nDiagonal Secundaria: ");
         System.out.print("[ ");
         for(int i=0; i<DiagonalS.length;i++){
            System.out.print(DiagonalS[i]);
            if(i+1<DiagonalS.length){
               System.out.print(" , ");
            }
         }
         System.out.print(" ]\n");
      }
      else{
         System.out.print("\nNao eh possivel imprimir as diagonais.\n");
      }
   }
   
   //Metodo que verifica se as matrizes podem ser somadas ou subtraidas.
   private boolean podeSomar(int[][] matrizRecebida){
      if((matriz.length == matrizRecebida.length) && (matriz[0].length == matrizRecebida[0].length)){
         return true;
      }
      else{
         System.out.print("\nAs matrizes devem ser da mesma ordem para efetuar o calculo!\n");
         return false;
      } 
   }
     
   //Metodo que recebe uma matriz e a soma com a matriz da classe
   public void somaMatriz(int[][] matrizRecebida){
      boolean verificador = podeSomar(matrizRecebida);
      if(verificador == true){
         for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz[i].length; j++){
               matriz[i][j] = matriz[i][j] + matrizRecebida[i][j]; //Matriz recebida é somada com a da classe
            }   
         }
      }
   }   
   //Metodo que recebe uma matriz e a subtrai com a matriz da classe
   public void subtraiMatriz(int[][] matrizRecebida){
      boolean verificador = podeSomar(matrizRecebida);
      if(verificador == true){
         for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz[i].length; j++){
               matriz[i][j] = matriz[i][j] - matrizRecebida[i][j];//Matriz da clasee é subtraida pela Recebida
            }
         }
      } 
        
   }
   
   //Metodo que retorna true caso a matriz da classe possa ser multiplicada pela recebida por parâmetro
   private boolean podeMultiplicar(int[][] matrizRecebida){
      System.out.print("Numero de colunas Matriz da classe: "+ matriz[0].length + "\n");//motivo de usar o 0 explicado final do codigo
      System.out.print("Numero de linhas da Matriz recebida: "+ matrizRecebida.length + "\n");
      if(matriz[0].length == matrizRecebida.length){//Compara se o numero de colunas da matriz da classe é igual ao de linhas da recebida
         return true;
      }
      else{
         return false;
      }
   }
   
   /*
   Metodo que multiplica a matriz da classe pela recebida por parâmetro
   Utilizar o metodo podeMultiplicar para verificar se é possivel realizar a operação
   Caso não seja possível retornar falso
   */
   public boolean multiplicaMatriz(int[][] matrizRecebida){
     boolean verificador = podeMultiplicar(matrizRecebida);
     if(verificador == true ){
     
      System.out.println("Multiplicando a matriz: ");
      int [][] matrizProduto = new int[matriz.length][matrizRecebida[0].length];//Declarando matriz produto, recebe os rezultados da multiplicação
      int soma = 0; //Recebera os calculos das matrizes
      
      for(int i=0;i<matriz.length;i++){
         for(int j=0; j<matrizRecebida[0].length;j++){//Aqui eu coloquei indice 0 .Argumentos fim do codigo
            for(int aux =0; aux<matriz[0].length;aux++){//for de aux para realizar as operações
               soma = soma + matriz[i][aux]*matrizRecebida[aux][j];
            }
            matrizProduto[i][j] = soma; //atribui os resultados dos calculos à matrizProduto
            soma = 0;
         }
      }
      print(matrizProduto); //imprime a matriz produto
      setMatriz(matrizProduto);
      return true; 
     }
     else{
      System.out.println("Nao eh possivel multiplicar as matrizes.");
      return false;
     }
   }
     
   //Faz o calculo da determinante por meio de recursão   
   private double determinante(int tamanho, int[][] matrizRecebida){ //tamanho refere a dimensao da matriz recebida 2 pra 2x2, 4 para 4x4 etc...
      double det =0; //variavel que guarda a determinante
      System.out.println("Matriz Recebida: ");
      print(matrizRecebida);
           
      if(tamanho == 2){// tamanho == 2 entra no caso base, realizando o calculo e retornando a determinante 
        det = ((matrizRecebida[0][0]*matrizRecebida[1][1])-(matrizRecebida[1][0]*matrizRecebida[0][1]));
        return det;
      }
      else{
         int subLinha,subColuna;//linhas e colunas da subMatriz
         
         int [][]subMatriz = new int [matrizRecebida.length - 1][matrizRecebida[0].length - 1];// a subMatriz é uma matriz de tamanho reduzido da matriz Recebida
         print(subMatriz);
         for(int contador=0; contador<tamanho; contador++){//contador representa a localização do pivô na primeira linha e auxilia nos cálculos.
            subLinha = 0;
            for(int i=1; i<tamanho; i++){//no método não é considerada a primeira linha e nem a coluna do pivô (valor q multiplica a determinante da subMatrzi), por isso i=1;
               subColuna = 0;
               for(int j=0; j<tamanho; j++){//Se a coluna da MatrizRecebida for a mesma do pivô , é pulada a interação, "cortando" assim a coluna no momento de atribuir
                 if(j==contador)
                 continue; //Garante que não ocorra a interação.
                 subMatriz[subLinha][subColuna] = matrizRecebida[i][j];//Preenchendo subMatriz
                 subColuna ++; 
               }
               subLinha++;       
            }
            det = det + (Math.pow(-1,contador)*matrizRecebida[0][contador] * determinante(tamanho -1, subMatriz)) ;//pow alterna a soma e subtração das determinantes das submatrizes usando (-1)^contador para saber se a iteração e par ou impar;  
         }
      }
      return det;
   } 
   
   //Metodo que retorna true caso a matriz da classe seja invertível
   private boolean ehInvertivel(){
   double determinante = 0;
   int verificador = matrizQuadrada();//Recebe o tamanho da matriz quadrada 1 pra 1x1, 2 pra 2x2 etc...
      if(verificador > 1){//Se maior que 1, ele pode entrar no método de cálculo de determinante que só aceita Matrizes 2x2 ou maiores. (Casos base é uma matriz 2x2)
         determinante = determinante(verificador,matriz);
         System.out.println("Determinante: " + determinante + "\n");
         if(determinante != 0){
            return true;
         }
         else
            return false;
      }
      
      else if(verificador == 1){//Matriz 1x1 tem a determinante igual seu próprio valor.
         determinante = matriz[0][0];
         System.out.println("Determinante: " + determinante + "\n");
         return true;
      }   
      else
         return false;
   }
   private int[][] matrizInversa(){
      double aux,pivo;
      
      double [][] matrizClasse = new double [matriz.length][matriz[0].length];//Uma matriz de double que irah receber os valores da matriz da classe
      double [][] matrizInversa = new double [matriz.length][matriz[0].length];//Matriz identidade que será transformada na inversa
      int [][] matrizI = new int[matriz.length][matriz[0].length];
      
      for(int i=0;i<matrizClasse.length;i++){//Como existe a autopromoção no java, os valores int de matriz serão convertidos para double.
         for(int j=0;j<matrizClasse[0].length;j++){
            matrizClasse[i][j] = matriz[i][j];
            
            if(i==j)//Atribuindo  a matriz identidade onde a diagonal principal vale sempre 1 e o restante e 0, como no método de Gauss
               matrizInversa[i][j] = 1;
            else
               matrizInversa[i][j] = 0;   
         }
      }
      
      for(int i=0; i<matrizClasse.length;i++){
         pivo = matrizClasse[i][i]; //pivô sempre andará a diagonal principal, e será usado para "transformar" a principal em 1;
         
            for(int k=0; k<matrizClasse.length; k++){
               matrizClasse[i][k] = matrizClasse[i][k]/pivo;
               matrizInversa[i][k] = matrizInversa[i][k]/pivo;
            }
            for(int j=0;j <matrizClasse.length;j++){
               if(i != j){
               
                  aux=matrizClasse[j][i];
                  for (int k=0; k<matrizClasse.length; k++){
                     matrizClasse[j][k] = matrizClasse[j][k]-aux*matrizClasse[i][k];
                     matrizInversa[j][k] = matrizInversa[j][k]-aux*matrizInversa[i][k];
                     matrizI[j][k] = (int)Math.round(matrizInversa[j][k]);
                  }
               }
            }
      }
      
      print(matrizInversa);
      print(matrizI);
      
      return matrizI;
      
   }
   //Metodo que retorna a inversa da matriz quando ela é 2x2
   private int[][] inversa2x2(){
      boolean verificador = ehInvertivel();
      if(verificador == true){
         return matrizInversa();
      }   
      else{
         System.out.print("Matriz nao inversivel.");   
      }
   return matriz; //cod pede um retorno     
   }
   
   //Metodo que retorna a inversa da matriz quando ela é 3x3   
   private int[][] inversa3x3(){
      boolean verificador = ehInvertivel();
      if(verificador == true){
         return matrizInversa();
      }   
      else{
         System.out.print("Matriz nao inversivel.");
      } 
   return matriz;     
   }
   
    /*
   Metodo que retorna a matriz inversa da classe caso seja invertível
   Utilizar o metodo ehInvertivel para verificar se é possivel realizar a operação
   Caso não seja possível apresentar mensagem de erro
   Utilizar metodos de inversa2x2 e inversa3x3 para calculos das matrizes desse tamanho
   Caso a matriz tenha tamanho 4 ou maior retornar que o método está sendo desenvolvido e ainda não é possível calcular
   */
   public int[][] getInversa(){
   int verificador = matrizQuadrada();
   if(verificador == 2){
      return inversa2x2();
   }
   else if(verificador == 3){
      return inversa3x3();
   }
   else
      return matrizInversa();
   }

   //Metodo que retorna a oposta da matriz
   public int[][] getOposta(){
      int [][] matrizOposta = new int [matriz.length][];
      for(int i=0;i<matriz.length;i++){
         matrizOposta[i] = new int [matriz[i].length];
         for(int j=0;j<matriz[i].length;j++){
         matrizOposta[i][j] = -matriz[i][j];
         }
      }
      System.out.print("\n Oposta ");
      print(matrizOposta);
      return matrizOposta;
      
   }
   
   //Metodo que retorna a transposta da matriz
   public int[][] getTransposta(){
      int [][] matrizTransposta = new int[matriz[0].length][matriz.length];
      for(int i=0; i<matrizTransposta.length; i++){
         for(int j=0; j<matrizTransposta[0].length; j++){
            matrizTransposta[i][j] = matriz[j][i];
         } 
      }
      System.out.print("\nTransposta");
      print(matrizTransposta);
      return matrizTransposta;
   }

  
   /*
   Metodo que imprime a matriz no formato em que as linhas ficam entre colchetes e as colunas entre vírgulas
   Exemplo:
   [1,3]
   [2,4,6]
   */
   public void print(){
     System.out.println("\n Matriz da classe: ");
     for(int i=0; i<matriz.length; i++){
       System.out.print("[ ");
       for(int j=0; j<matriz[i].length; j++){
         System.out.print(matriz[i][j]);//Imprime o valor da Matriz;
         if(j+1 < matriz[i].length){ //Verifica se o laço irá acabar, caso não, printa uma virgula;
           System.out.print(" , ");
         }
        }
        System.out.print(" ]\n");
      } 
   }
   
   //Método que imprime uma Matriz que não seja da classe
   public void print(int[][] matriz){
     System.out.println("\n Matriz: ");
     for(int i=0; i<matriz.length; i++){
       System.out.print("[ ");
       for(int j=0; j<matriz[i].length; j++){
         System.out.print(matriz[i][j]);//Imprime o valor da Matriz;
         if(j+1 < matriz[i].length){ //Verifica se o laço irá acabar, caso não, printa uma virgula;
           System.out.print(" , ");
         }
        }
        System.out.print(" ]\n");
      } 
   }
   
   //Método que imprime uma Matriz que não seja da classe
   public void print(double[][] matriz){
     System.out.println("\n Matriz: ");
     for(int i=0; i<matriz.length; i++){
       System.out.print("[ ");
       for(int j=0; j<matriz[i].length; j++){
         System.out.print(matriz[i][j]);//Imprime o valor da Matriz;
         if(j+1 < matriz[i].length){ //Verifica se o laço irá acabar, caso não, printa uma virgula;
           System.out.print(" , ");
         }
        }
        System.out.print(" ]\n");
      } 
   }

}

/*
Linha 104 podeMultiplicar: coloquei 0 para pegar os numeros de colunas da primeira linha, assumindo que todas as
linhas terão o mesmo número de colunas e estarão preenchidas.

Linha 128 multiplicaMatriz: eu tive que colocar o indice 0 , pois caso a matriz da classe tivesse mais linhas que 
a matriz recebida, haveria um erro de alocação de endereço, pois eu n conseguiria checar + linhas 
do que a matriz recebida tem. Portanto, optei por colocar um indice 0 como base e tratar como se todas
as matrizes estivessem totalmente preenchidas.
*/

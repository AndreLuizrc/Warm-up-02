package Batuke;
import java.util.ArrayList;
import java.util.Scanner;

public class batuke{

    public static int caminhar(int[][] matriz,int x, int y, int N){
        int l = x;
        int c = y;
        ArrayList<Integer> celulas = new ArrayList<>();
        int cont_celulas = 0;
        int j = 1;
        
        if(l < N && c < N){
            celulas.add(matriz[l][c]);
            cont_celulas++;
        }

        while(celulas.size() < 16){

            for(int k = 0; k < j; k++){
                c++;
                if(l < N && c < N && l >= 0 && c >= 0){
                    celulas.add(matriz[l][c]);
                }

                if(celulas.size() < 16){
                    cont_celulas++;
                }
            }

            for(int k = 0; k < j; k++){
                l++;
                if(l < N && c < N && l >= 0 && c >= 0){
                    celulas.add(matriz[l][c]);
                }

                if(celulas.size() < 16){
                    cont_celulas++;
                }
            }

            j++;

            for(int k = 0; k < j; k++){
                c--;
                if(l < N && c < N && l >= 0 && c >= 0){
                    celulas.add(matriz[l][c]);
                }
                
                if(celulas.size() < 16){
                    cont_celulas++;
                }
            }

            for(int k = 0; k < j; k++){
                l--;
                if(l < N && c < N && l >= 0 && c >= 0){
                    celulas.add(matriz[l][c]);
                }
                
                if(celulas.size() < 16){
                    cont_celulas++;
                }
            }

            j++;

        }

        cont_celulas++;

        
        System.out.println(celulas.get(0)+" "+celulas.get(1)+" "+celulas.get(2)+" "+celulas.get(3)+" "+celulas.get(4)+" "+celulas.get(5)+" "+celulas.get(6)+
        " "+celulas.get(7)+" "+celulas.get(8)+" "+celulas.get(9)+" "+celulas.get(10)+" "+celulas.get(11)+" "+celulas.get(12)+" "+celulas.get(13)+" "+celulas.get(14)+
        " "+celulas.get(15));
        

        return cont_celulas;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        //System.out.println(N);
        int x = sc.nextInt();
        int y = sc.nextInt();
        //System.out.println(x);
        //System.out.println(y);
        int[][] matriz = new int[N][N];

        int cont = 1;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                matriz[i][j] = cont;
                cont++;
            }
        }

        //System.out.println(matriz[0][0]);
        int quant_celulas = caminhar(matriz, x, y, N);
        System.out.println(quant_celulas);

        sc.close();
    }
}
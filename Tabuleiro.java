public class Tabuleiro {
    private int[][] table;
    private int length;

    public Tabuleiro(String[] numbers){
        length = (int) Math.sqrt(numbers.length);
        table = new int[length][length];
        int k= 0;
        for(int i = 0; i < length; i++){
            for(int j=0; j<length; j++){
                table[i][j] = Integer.parseInt(numbers[k++]);
            }
        }
    }

    public void UpMove(){
        for(int i = 0; i < length; i++){
            for(int j=0; j<length; j++){
                if(table[i][j] == 0 && i < length-1){
                    int temp = table[i][j];
                    table[i][j] = table[i+1][j];
                    table[i+1][j] = temp;
                    return;
                }
            }
        }
    }
    public void DownMove(){
        for(int i = 0; i < length; i++){
            for(int j=0; j<length; j++){
                if(table[i][j] == 0 && i > 0){
                    int temp = table[i][j];
                    table[i][j] = table[i-1][j];
                    table[i-1][j] = temp;
                    return;
                }
            }
        }
    }
    public void LeftMove(){
        for(int i = 0; i < length; i++){
            for(int j=0; j<length; j++){
                if(table[i][j] == 0 && j < length-1){
                    int temp = table[i][j];
                    table[i][j] = table[i][j+1];
                    table[i][j+1] = temp;
                    return;
                }
            }
        }
    }
    public void RightMove(){
        for(int i = 0; i < length; i++){
            for(int j=0; j<length; j++){
                if(table[i][j] == 0 && j > 0){
                    int temp = table[i][j];
                    table[i][j] = table[i][j-1];
                    table[i][j-1] = temp;
                    return;
                }
            }
        }
    }

    public void PrintTabuleiro(){
        for(int i = 0; i < length; i++){
            for(int j = 0; j < length; j++){
                System.out.print("+------");
            }
            System.out.println("+");
            for(int j=0; j<length; j++){
                if(table[i][j] < 10){
                    System.out.print("|   ");
                }else{
                    System.out.print("|  ");
                }
                System.out.print(table[i][j]+"  ");
                if(j == length-1){
                    System.out.print("|");
                }
            }
            System.out.print("\n");
        }
        for(int j = 0; j < length; j++){
            System.out.print("+------");
        }
        System.out.println("+");
        System.out.println("");
    }

    public boolean Solucao(){
        int cont = 0;
        for(int i = 0; i < length; i++){
            for(int j=0; j<length; j++){
                if(table[i][j]!=cont++){
                    return false;
                }
            }
        }
        return true;
    }
}
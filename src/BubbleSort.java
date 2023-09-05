import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args){
        int[] nilai = {4, 6, 2, 9, 7, 5, 2, 6, 2, 8};
        bubbleSortACS(nilai);

    }

    public static void bubbleSortACS(int[] bilangan){
        for( int i = 0; i < bilangan.length; i++ ){

            for( int j = 0 ; j < bilangan.length - 1; j++ ){
                if( bilangan[j] > bilangan[j+1] ){
                    System.out.println(Arrays.toString(bilangan));

                    int temp = bilangan[j];
                    bilangan[j] = bilangan[j+1];
                    bilangan[j+1] = temp;

                }
            }
        }
    }
}//end class

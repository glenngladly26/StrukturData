import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args){
        int[] nilai = {90,80,54,67,98,76};
        insertionSortACS(nilai);
    }


    public static void insertionSortACS( int[] bilangan ){
        
        for( int i = 1; i < bilangan.length; i++ ){
            
            for( int j = i; j > 0; j-- ){
                if( bilangan[j] < bilangan[j-1] ){

                    System.out.println(Arrays.toString(bilangan));
                    int temp = bilangan[j];
                    bilangan[j] =  bilangan[j-1];
                    bilangan[j-1] = temp;
                }
            }
        }
    }
}//end class

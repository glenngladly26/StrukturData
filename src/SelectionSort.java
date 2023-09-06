import java.util.Arrays;

public class SelectionSort {
    
    public static void main(String[] args){
        int[] nilai = {11, 97, 67, 24, 1, 48, 94, 25, 33, 89, 41, 72, 18, 49, 69, 84, 96, 14, 100, 81, 78, 5, 44, 36, 30, 87, 81, 98, 14, 43, 74, 78, 10, 33, 93, 39, 100, 66, 89, 94, 7, 73, 52, 73, 81, 60, 55, 78, 48, 76, 61, 38, 27, 35, 89, 74, 58, 20, 4, 83, 79, 90, 74, 62, 53, 45, 6, 52, 87, 54, 28, 96, 55, 6, 36, 28, 33, 35, 49, 25, 34, 99, 27, 12, 74, 6, 28, 89, 77, 14, 53, 50, 99, 62, 81, 65, 64, 24, 14, 47};

        // waktu awal
        double starTime = System.nanoTime();
        selectionSortACS(nilai);

        // waktu akhir
        double endTime = System.nanoTime();
    
        // total waktu
        double totalTime = (endTime - starTime)/1000000000;
        System.out.println("\nWaktu total :" +  totalTime + " detik");
    }

    public static void selectionSortACS( int[] bilangan  ){
        // tampilan sebelum
        System.out.println("== Sebelum ==");
        System.out.println(Arrays.toString(bilangan));
        
        
        //logic
        for( int i = 0; i < bilangan.length ; i++ ){
            int indexArray = i;
            
            for( int j = i + 1; j < bilangan.length; j++ ){
                if( bilangan[indexArray] > bilangan[j] ){
                    indexArray = j;
                    }
                }
            int temp = bilangan[i];
            bilangan[i] = bilangan[indexArray];
            bilangan[indexArray] = temp;
        }

        // tampilan setelah
        System.out.println("\n== Sesudah ==");
        System.out.println(Arrays.toString(bilangan));
        }
}//end class
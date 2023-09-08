import java.util.Arrays;

public class SelectionSort {
    
    public static void main(String[] args){
        int[] nilai = {55, 45, 32, 100, 37, 5, 35, 49, 15, 7, 38, 6, 31, 67, 37, 17, 19, 15, 55, 29, 40, 75, 65, 13, 73, 89, 88, 4, 6, 17, 74, 63, 17, 100, 62, 37, 98, 99, 93, 64, 11, 28, 49, 38, 95, 59, 21, 77, 97, 19, 68, 27, 78, 88, 79, 29, 58, 29, 50, 96, 36, 84, 99, 40, 28, 61, 74, 6, 58, 33, 77, 52, 35, 15, 47, 35, 43, 29, 88, 60, 91, 30, 20, 99, 88, 7, 53, 62, 45, 56, 17, 23, 95, 74, 5, 3, 33, 55, 19, 18};

        // waktu awal
        double startTime = System.nanoTime();
        selectionSortACS(nilai);

        // waktu akhir
        double endTime = System.nanoTime();
    
        // total waktu
        double totalTime = (endTime - startTime)/1000000000;
        System.out.println("\nWaktu total :" +  totalTime + " detik");
    }

    public static void selectionSortACS( int[] bilangan  ){
        // tampilan sebelum
        System.out.println("== Sebelum ==");
        System.out.println(Arrays.toString(bilangan));
        
        
        for( int i = 0; i < bilangan.length ; i++ ){
            int minValue = i;
            
            for( int j = i; j < bilangan.length; j++ ){
                if( bilangan[minValue] > bilangan[j] ){
                    minValue = j;
                    }
                }
            int temp = bilangan[i];
            bilangan[i] = bilangan[minValue];
            bilangan[minValue] = temp;
        }

        // tampilan setelah
        System.out.println("\n== Sesudah ==");
        System.out.println(Arrays.toString(bilangan));
        }
}//end class
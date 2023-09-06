import java.util.Arrays;

public class SelectionSort {
    
    public static void main(String[] args){
        int[] nilai = {8, 68, 16, 25, 1, 64, 95, 75, 10, 34, 
            65, 15, 41, 5, 87, 56, 44, 6, 83, 16, 24, 55, 57, 
            8, 19, 38, 50, 61, 46, 78, 26, 72, 74, 68, 99, 
            67, 99, 73, 40, 71, 92, 43, 20, 14, 34, 62, 83, 
            26, 36, 64, 100, 72, 8, 86, 41, 3, 24, 84, 96, 
            57, 81, 44, 59, 41, 5, 27, 2, 10, 23, 83, 69, 3, 
            32, 52, 33, 100, 53, 82, 61, 22, 27, 48, 87, 51, 
            69, 73, 21, 85, 80, 17, 25, 1, 45, 70, 48, 84, 
            69, 88, 58, 62};

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
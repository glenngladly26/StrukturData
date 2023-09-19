import java.util.Arrays;

public class MergeSort{

    public static void main(String[] args){
        int[] Nilai = { 55, 45, 32, 100, 37, 5, 35, 49, 15, 7, 38, 6, 31, 67, 37, 17, 19, 15, 55, 29, 40, 75, 65, 13, 73, 89, 88, 4, 6, 17, 74, 63, 17, 100, 62, 37, 98, 99, 93, 64, 11, 28, 49, 38, 95, 59, 21, 77, 97, 19, 68, 27, 78, 88, 79, 29, 58, 29, 50, 96, 36, 84, 99, 40, 28, 61, 74, 6, 58, 33, 77, 52, 35, 15, 47, 35, 43, 29, 88, 60, 91, 30, 20, 99, 88, 7, 53, 62, 45, 56, 17, 23, 95, 74, 5, 3, 33, 55, 19, 18};
        mergeSort(Nilai);
    }

    public static void mergeSort( int[] value){
        System.out.println("==SEBELUM==");
        System.out.println(Arrays.toString(value));

        value = pisah(value);

        System.out.println("\n==SEBELUM==");
        System.out.println(Arrays.toString(value));
    }


    //fungsi pisah
    public static int[] pisah( int[] value ){
        if(value.length <= 1){
            return value;
        }

        //membuat array
        int nilaiTengah = value.length / 2;
        int kiri[] = new int[nilaiTengah];
        int kanan[];
        //cek apakah data array ganjil atau genap
        if(value.length % 2 == 0){
            kanan = new int[nilaiTengah];
        }else{
            kanan = new int[nilaiTengah + 1];
        }

        //masukkan nilai ke array L dan R
        for( int i = 0; i < kiri.length; i++){
            kiri[i] = value[i];
        }
        for( int j = 0; j < kanan.length; j++ ){
            kanan[j] = value[nilaiTengah + j];
        }

        kiri = pisah(kiri);
        kanan = pisah(kanan);

        //membuat array untuk menampung pengembalian array dari fungsi gabung
        int hasil[] = new int[value.length];
        hasil = gabung(kiri, kanan);
        return hasil;

    }

    //fungsi gabung
    public static int[] gabung( int[] kiri , int[] kanan){

        int[] hasilGabung = new int[kiri.length + kanan.length];
        int i = 0, j = 0, k = 0;

        while( i < kiri.length || j < kanan.length){
            
            if( i < kiri.length && j < kanan.length){
                if( kiri[i] <= kanan[j] ){
                    hasilGabung[k] = kiri[i];
                    i++;
                    k++;
                }else{
                    hasilGabung[k] = kanan[j];
                    j++;
                    k++;
                }
            }else if( i < kiri.length){
                hasilGabung[k] = kiri[i];
                i++;
                k++;
            }else if( j < kanan.length ){
                hasilGabung[k] = kanan[j];
                j++;
                k++;
            }
        }
        return hasilGabung;
    }
    
}//end class
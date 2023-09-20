import java.util.Arrays;

public class MergeSort{

    public static void main(String[] args){
        int[] Nilai = { 84, 79, 60, 43, 55, 17, 18, 34, 19, 75, 54, 66, 25, 50, 22, 88, 93, 2, 45, 87, 72, 83, 78, 97, 54, 59, 47, 97, 96, 74, 60, 53, 1, 22, 4, 50, 65, 52, 60, 94, 27, 49, 83, 94, 68, 34, 53, 22, 25, 51, 11, 55, 41, 38, 9, 32, 45, 85, 83, 64, 25, 49, 32, 87, 32, 82, 49, 31, 94, 8, 46, 91, 10, 84, 70, 5, 2, 9, 3, 58, 49, 23, 41, 63, 99, 50, 57, 81, 69, 10, 92, 68, 49, 46, 14, 25, 55, 34, 29, 43, };
        mergeSort(Nilai);
    }

    public static void mergeSort( int[] value){
        System.out.println("==SEBELUM==");
        System.out.println(Arrays.toString(value));

        value = pisah(value);

        System.out.println("\n==SESUDAH==");
        System.out.println(Arrays.toString(value) + "\n");
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

        //memanggil kembali fungsi pisah
        kiri = pisah(kiri);
        kanan = pisah(kanan);

        //membuat array untuk menampung pengembalian array dari fungsi gabung
        int hasil[] = new int[kiri.length + kanan.length];

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
                }else{
                    hasilGabung[k] = kanan[j];
                    j++;
                    
                }
            }else if( i < kiri.length){
                hasilGabung[k] = kiri[i];
                i++;
                
            }else if( j < kanan.length ){
                hasilGabung[k] = kanan[j];
                j++;
                
            }
            k++;
        }
        return hasilGabung;
    }
    
}//end class
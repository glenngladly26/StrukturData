import java.util.Arrays;

public class MergeSort{

    public static void main(String[] args){
        int[] Nilai = { 564, 123, 789, 345, 890, 234, 456, 678, 987, 654, 342, 567, 876, 109, 876, 231, 567, 987, 321, 345, 678, 234, 543, 678, 890, 123, 567, 890, 234, 567, 789, 876, 109, 876, 231, 567, 987, 321, 345, 678, 890, 123, 567 };
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
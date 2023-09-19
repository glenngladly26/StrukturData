public class MergeSort{

    public static void main(String[] args){

    }//end main

    public static void mergeSort( int[] bilangan){
        System.out.println("==SEBELUM==");
        for( int a : bilangan){
            System.out.print(a);
        }
        

        bilangan = pisah(bilangan);

        System.out.println("==SEBELUM==");
        for( int a : bilangan){
            System.out.print(a);
        }
    }//akhir method mergeSort

    //membuat fungsi pisah
    public static int[] pisah( int[] bilangan ){
        if(bilangan.length <= 1){
            return bilangan;
        }

        //membuat array
        int nilaiTengah = bilangan.length / 2;
        int L[] = new int[nilaiTengah];
        
        int R[];
        //cek apakah data array ganjil atau genap
        if(bilangan.length % 2 == 0){
            R = new int[nilaiTengah];
        }else{
            R = new int[nilaiTengah + 1];
        }

        //masukkan nilai ke array L dan R
        //masukan nilai ke arrya L
        for( int i = 0; i < L.length; i++){
            L[i] = bilangan[i];
        }
        //masukkan nilai ke array R
        for( int j = 0; j < R.length; j++ ){
            R[j] = bilangan[nilaiTengah + j];
        }

        //membagi ulang
        L = pisah(L);
        R = pisah(R);

        //menyiapkan array untuk menampung pengembalian array dari fungsi gabung
        int hasil[] = new int[bilangan.length];

        //isi array hasil dari data yang sudah di gabung
        hasil = gabung();

    }//akhir dari fumgsi pisah

    public static int[] gabung( int[] L , int[] R){

    }
    
}//end class
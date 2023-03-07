package pbo_kalkulator;
import java.util.Scanner;

public class PBO_KalkulatorMain {
    public static void main(String[] args) {
        PBO_Kalkulator kalkulator = new PBO_Kalkulator();
        Scanner input = new Scanner (System.in);
       
        String angka;
        System.out.println ("Nama \t: Yuaini Pranajelita");
        System.out.println ("NPM \t: 21081010204");
        System.out.println ("Kelas \t: PBO D081");
        System.out.println ("\t\t");
        System.out.print ("Masukkan Angka Beserta Operatornya yang Akan dihitung : " );
        angka = input.nextLine();
        
        double result = kalkulator.evaluateExpression(angka);
        System.out.println("Hasil : " +result);
        
    }  
}

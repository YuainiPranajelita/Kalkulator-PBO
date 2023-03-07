package pbo_kalkulator;
import java.util.Stack; //agar bisa melakukan pop : mengeluarkan, push : memasukkan
import java.util.ArrayList; //untuk membuat array agar berbentuk list
import java.util.Arrays; 


public class PBO_Kalkulator {
    public Double evaluateExpression (String expression){
    /*  aritmatika1 : digunakan untuk mendeteksi apakah itu angka atau operator
        s+ : space untuk mendeteksi jarak antara angka dan operator
        aritmatika2 : digunakan untuk memilah apakah operator itu di push atau pop
        save_place : digunakan untuk tempat penyimpanan operator dan angka yang telah diinput*/
    
    ArrayList <String> aritmatika1 = new ArrayList <> (Arrays.asList(expression.split("\\s+")));
    ArrayList <String> operators = new ArrayList <> (Arrays.asList ("+", "-", "*", "/"));
    Stack <Double> aritmatika2 = new Stack <> ();
    Stack <String> save_place = new Stack <> ();
    
        /*size : apabila 2 + 3 berarti size = 5
    hasprecedence merupakan prioritas operator. misal perkalian lebih tinggi dari penjumlahan
    peek : tertinggi
    empty : kosong
        operators.contains = apakah memiliki simbol prioritas atau tidak*/ 
    for (int i = 0; i<aritmatika1.size(); i++){
        String simbol = aritmatika1.get (i);
        if (operators.contains (simbol)){
            while (!save_place.empty() && hasprecedence (save_place.peek(), simbol)){
                applyoperation (aritmatika2, save_place.pop());
            }
            save_place.push (simbol); 
        } else {
            aritmatika2.push (Double.parseDouble(simbol));
        }
    }
    while (!save_place.empty()){
        applyoperation (aritmatika2, save_place.pop());
    }
    return aritmatika2.pop();
    }
    
    /*equals : sama dengan*/
    private boolean hasprecedence(String operator_1, String operator_2) {
        if (operator_1.equals ("*") || operator_1.equals("/")){
            return true;
        } else if (operator_2.equals ("+") || operator_2.equals ("-")){
            return true;
        } 
        return false;
    }

    private void applyoperation(Stack<Double> aritmatika2, String operator) {
        double operand_2 = aritmatika2.pop();
        double operand_1 = aritmatika2.pop();
        double result = 0;
        
        switch (operator){
            case "+" :
                result = operand_1 + operand_2;
                break;
                
            case "-" :
                result = operand_1 - operand_2;
                break;
                
            case "*" :
                result = operand_1 * operand_2;
                break;
                
            case "/" :
                result = operand_1 / operand_2;
                break;
        }
        aritmatika2.push (result);
    }
}


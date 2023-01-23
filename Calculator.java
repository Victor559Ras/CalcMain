public class Calculator {
    private int n1 = 0;
    private int n2 = 0;
    char mathAct;
    int result;

    Calculator (int num1, int num2, char act){
        this.n1 = num1;
        this.n2 = num2;
        mathAct = act;
    }
    int getCalc(){
        //System.out.println("На входе в getCalc " + n1 + " " + n2 + " " + mathAct);
        if (mathAct == '+'){
            result = n1 + n2;
        }
        if (mathAct == '-'){
            result = n1 - n2;
        }
        if (mathAct == '/'){
            if (n2 == 0) System.out.println("Деление на ноль недопустимо!");
            result = n1 / n2;
        }
        if (mathAct == '*'){
            result = n1 * n2;
        }
        return result;
    }



}

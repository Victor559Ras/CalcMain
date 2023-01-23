public class Converter {
    int num1 = 0; // первое слагаемое
    int num2 = 0; // второе слагаемое
    String toCompare1 = "";// переменные нужны для сличения считанных строк и введеных пользователем
    String toCompare2 = "";// переменные нужны для сличения считанных строк и введеных пользователем
    String resultToCompare = "";// переменные нужны для сличения считанных строк и введеных пользователем
    int stringLengh;

    String input; //ввод пользователя
    String userStr;
    char mathAct; // арифметическое действие


    Converter(String input) {
        this.input = input;
    }

    void numDetermine() {
        boolean counter = true; // переключатель с num1/num2
        String helpfulZero = " ";

        input = input.concat(helpfulZero); // нужен еще символ для корректной работы substring
        stringLengh = input.length();
        int k = 1; // номер второго
        int n = 0; // номер первого символа для чтения
        char charControl;
        int mathActCntrl = 0;

        do{

            userStr = input.substring(n,k); // тянем подстроку для сличения с enum вариантами чисел
            charControl = input.charAt(k-1);
            if (charControl == '+'  | charControl == '-' | charControl == '/' | charControl == '*') {
                //
                mathAct = charControl;
                mathActCntrl++;
                if (mathActCntrl == 2) {
                    System.out.println("**********Некорректный ввод - 2 арифметических символа!********");
                    break;
                }
                counter = false;
                n=k;
            }
            //System.out.println("Строка для конвертации " + userStr);
             k++;
            if (counter == true) {
                for (enumForInt x : enumForInt.values()) {
                    //System.out.println(x.getStr()+" "+userStr);

                    if (userStr.equals(x.getStr())){
                        num1 = x.getNum();
                        toCompare1 = x.getStr();
                        //System.out.println("num1 " + toCompare1 );
                    }
                }
            }
            if (counter == false){
                for (enumForInt x : enumForInt.values()) {
                    //System.out.println(x.getStr()+" "+userStr);
                    if (userStr.equals(x.getStr())){
                        num2 = x.getNum();
                        toCompare2 = x.getStr();
                        //System.out.println("num2 "+ toCompare2);
                    }
                }
            }
            //System.out.println("Положение счетчика: " + counter);
        }while(k <= stringLengh);
        //System.out.println("Считал числа: " + num1 + "&" + num2 );

    }
    boolean checkStringLengh(){ //проверяем длинну ввода пользователя и длину счтанной строки
        boolean result = true;
        resultToCompare = toCompare1.concat(toCompare2);
        resultToCompare = resultToCompare.concat("&&");
        //System.out.println("прочитанная строка " + resultToCompare + " - " + resultToCompare + " Res " + resultToCompare.length() + " Str " + stringLengh);
        if (resultToCompare.length() != stringLengh) {
            //System.out.println("Вы ввели некорректное количество символов!! Ввод обнулён!");
            result = false;
        }

        return result;
    }




    String backToStringArab(int result){
        String userString1 = "";
        userString1 = userString1.valueOf(result);

        return userString1;
    }
    String backToStringLat(int result){ // перевод в латынь
        String userString2 = "";

        int userNumToConvirt = result;
        if (userNumToConvirt < 0) System.out.println("Латинские цифры не бывают отрицательными! ");
        if (userNumToConvirt == 0) System.out.println("В латинской системе исчисления нет обозначения для цифры 0! Введите другие числа для подсчета!");
        int temp = 0;

        temp = userNumToConvirt / 100; // сколько сотен и ищем строку в списке
        temp = temp * 100;
        for (LatStrings x: LatStrings.values()){
            if(temp == x.getNum()) userString2 = userString2.concat(x.getString());
            //System.out.println("Сотни " + temp + " " + x.getNum() + " " + userString2 );
        }

        userNumToConvirt = userNumToConvirt - temp;// сколько десяткоа и ещем строку в десятках
        temp = userNumToConvirt / 10;
        temp = temp * 10;
        for (LatStrings x : LatStrings.values()) {
            if (temp == x.getNum()) userString2 = userString2.concat(x.getString());
            //System.out.println("Сработал тоже " + userString2);
        }

        userNumToConvirt = userNumToConvirt - temp; // определяем сколько единиц
        temp = userNumToConvirt / 1;
        for (LatStrings x : LatStrings.values()) {
            if (temp == x.getNum()) userString2 = userString2.concat(x.getString());
        }
        //System.out.println("Два символа - " + userString2);
        return userString2;
    }


}


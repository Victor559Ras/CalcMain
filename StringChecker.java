public class StringChecker {
    String userInput;
    boolean lat = false;
    boolean ara = false;
    char[] userChars = new char[10];// массив для сверки символов полученной строки
    StringChecker(String userInput) {
        this.userInput = userInput;
    }


    public boolean inputChecker(){// провереят корректность ввода всех символов !!! проверить
        boolean result1 = true;
        char checkToEnum;
        //System.out.println("Entered " + userInput);
        for(int i = 0; i < userInput.length(); i++){
            checkToEnum = userInput.charAt(i);
            for (enumCalc x: enumCalc.values()){ // сверяем список символов против ввода пользователя
                if (x.getCh() == checkToEnum) {
                    result1 = true;
                    break;
                }
                else result1 = false;
            }
            //System.out.println(checkToEnum + "  " + result1);
            if (result1 == false) {
                System.out.println("Введен недопустимый символ!!");
                break;
            }
        }

        return result1;
    }

    public boolean checkArabRoman(){ // проверяет что НЕ введены латинские и арабские символы
        boolean result2 = true;
        for (int i = 0; i < userInput.length(); i++) {
           userChars[i] = userInput.charAt(i);
        }
        for (int i = 0; i < userChars.length; i++) {
            if (userChars[i] == 'I' | userChars[i] == 'V' | userChars[i] == 'X') lat = true;
        }
        for (int y = 0; y < userChars.length; y++) {
            for (enumCalc ch:enumCalc.values()){
                if (ch.getCh() == 'I') break;
                if (userChars[y] == ch.getCh()) ara = true;
            }
        }

        if (lat == true & ara == true) result2 = false;
        else result2 = true;
        //System.out.println("Латынь = " + lat + " Арабские = " + ara );
        //System.out.println("Результат сверки латыни против арабских цифр: " + result2);
        return result2;
    }
}




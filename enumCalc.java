public enum enumCalc {
    ZERO('0'),
    ONE('1'),
    TWO('2'),
    THREE('3'),
    FOUR('4'),
    FIVE('5'),
    SIX('6'),
    SEVEN('7'),
    EIGHT('8'),
    NINE('9'),



    I('I'),          //10
    V('V'),          //11
    X('X'),          //12

    PLUS('+'),       //13
    MINUS('-'),      //14
    DIVIDE('/'),     //15
    MULTIP('*'),  //16

    ;
    char ch;
    enumCalc(char ch) {
        this.ch = ch;
    }

    public char getCh() {
        return ch;
    }

}

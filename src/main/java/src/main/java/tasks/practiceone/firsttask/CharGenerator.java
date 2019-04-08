package practiceone.firsttask;

// Класс генерирует символы в диапазоне [bottomLimit; topLimit]
// Если bottomLimit > topLimit, то они меняются местами

public class CharGenerator {
    private char bottomLimit;
    private char topLimit;

    public CharGenerator(char bottomLimit, char topLimit){
        this.bottomLimit = (bottomLimit < topLimit) ? bottomLimit : topLimit;
        this.topLimit = (topLimit > bottomLimit) ? topLimit : bottomLimit;
    }

    public char next() {
        int multiplier = topLimit - bottomLimit + 1;
        return (char)((Math.random()*multiplier) + bottomLimit);
    }
}

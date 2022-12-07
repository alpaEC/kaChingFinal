/* a simple "player" class, with status variables and getter/setter methods
*/


public class Player {
    private int currentNumber;
    private int wrongAnswers;
    private int correctAnswers;
    private String playerName = "No Name";

    // default cunstructor
    void Player(){
        currentNumber = 1;
        wrongAnswers = 0;
        correctAnswers = 0;
    }

    public int getCurrentNumber() {
        return currentNumber;
    }

    public void setCurrentNumber(int currentNumber) {
        this.currentNumber = currentNumber;
    }

    public int getWrongAnswers() {
        return wrongAnswers;
    }

    public void setWrongAnswers(int wrongAnswers) {
        this.wrongAnswers = wrongAnswers;
    }

    public int getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public String getName(){
        return playerName;
    }

    public void setName(String s){
        playerName = s;
    }

    public void correctAnswer(){
        correctAnswers++;
    }

    public void wrongAnswer(){
        wrongAnswers ++;
    }

}

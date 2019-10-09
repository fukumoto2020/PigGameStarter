package edu.up.cs301.pig;

import edu.up.cs301.game.infoMsg.GameState;

public class PigGameState extends GameState {
    private int playerId;
    private int player0Score;
    private int player1Score;
    private int runningTotal;
    private int dieVal;

    public PigGameState(){
        this.playerId = 0;
        this.player0Score = 0;
        this.player1Score = 0;
        this.runningTotal = 0;
        this.dieVal = 1;
    }

    PigGameState (PigGameState myCopy){
        playerId = myCopy.playerId;
        player0Score = myCopy.player0Score;
        player1Score = myCopy.player1Score;
        runningTotal = myCopy.runningTotal;
        dieVal = myCopy.dieVal;
    }

    public int getPlayerId(){
        return playerId;
    }

    public int getPlayer0Score() {
        return player0Score;
    }

    public int getPlayer1Score() {
        return player1Score;
    }

    public int getRunningTotal(){
        return runningTotal;
    }

    public int getDieVal(){
        return dieVal;
    }

    public void setPlayer0Score(int player0Score) {
        this.player0Score = player0Score;
    }

    public void setPlayer1Score(int player1Score) {
        this.player1Score = player1Score;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public void setRunningTotal(int runningTotal) {
        this.runningTotal = runningTotal;
    }

    public void setDieVal(int dieVal) {
        this.dieVal = dieVal;
    }
}

package edu.up.cs301.pig;

import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.LocalGame;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.infoMsg.GameState;

import android.util.Log;

import java.util.Random;

/**
 * class PigLocalGame controls the play of the game
 *
 * @author Andrew M. Nuxoll, modified by Steven R. Vegdahl
 * @version February 2016
 */
public class PigLocalGame extends LocalGame {
    PigGameState myGameState;
    /**
     * This ctor creates a new game state
     */
    public PigLocalGame() {
        //TODO  You will implement this constructor
        myGameState = new PigGameState();
    }

        /**
         * can the player with the given id take an action right now?
         */
        @Override
        protected boolean canMove(int playerIdx){
            //TODO  You will implement this method
            if (myGameState.getPlayerId() == playerIdx) {
                return true;
            } else {
                return false;
            }
        }

        /**
         * This method is called when a new action arrives from a player
         *
         * @return true if the action was taken or false if the action was invalid/illegal.
         */
        @Override
        protected boolean makeMove (GameAction action){
            //TODO  You will implement this method'
            if (action instanceof PigHoldAction) {
                if (myGameState.getPlayerId() == 0) {
                    myGameState.setPlayer0Score(myGameState.getPlayer0Score() + myGameState.getRunningTotal());
                    myGameState.setPlayerId(1);
                } else if (myGameState.getPlayerId() == 1) {
                    myGameState.setPlayer1Score(myGameState.getPlayer1Score() + myGameState.getRunningTotal());
                    myGameState.setPlayerId(0);
                }
                myGameState.setRunningTotal(0);
                return true;
            } else if (action instanceof PigRollAction) {
                Random random = new Random();
                myGameState.setDieVal(random.nextInt(6) + 1);
                if (myGameState.getDieVal() != 1) {
                    myGameState.setRunningTotal(myGameState.getRunningTotal() + myGameState.getDieVal());
                } else {
                    myGameState.setRunningTotal(0);
                    if (myGameState.getPlayerId() == 0) {
                        myGameState.setPlayerId(1);
                    } else if (myGameState.getPlayerId() == 1) {
                        myGameState.setPlayerId(0);
                    }
                }
                return true;
            }
            return false;
        }//makeMove

        /**
         * send the updated state to a given player
         */
        @Override
        protected void sendUpdatedStateTo (GamePlayer p){
            PigGameState copy = new PigGameState(myGameState);

            p.sendInfo(copy);

        }
        //TODO  You will implement this method
    //sendUpdatedSate

    /**
     * Check if the game is over
     *
     * @return
     * 		a message that tells who has won the game, or null if the
     * 		game is not over
     */
    @Override
    protected String checkIfGameOver() {
        //TODO  You will implement this method
        if(myGameState.getPlayer0Score() >= 50){
            return ("Player 0 won with score " + myGameState.getPlayer0Score());
        }
        else if(myGameState.getPlayer1Score() >= 50){
            return "Player 1 won with score " + myGameState.getPlayer1Score();
        }
        return null;
    }

}// class PigLocalGame

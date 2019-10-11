package edu.up.cs301.pig;

import java.util.Random;

import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.infoMsg.GameInfo;

public class PigSmartComputerPlayer extends GameComputerPlayer {

    PigHoldAction myHold = new PigHoldAction(this);
    PigRollAction myRoll = new PigRollAction(this);
    /**
     * ctor does nothing extra
     */
    public PigSmartComputerPlayer(String name) {

        super(name);
    }

    /**
     * callback method--game's state has changed
     *
     * @param info
     * 		the information (presumably containing the game's state)
     */
    @Override
    protected void receiveInfo(GameInfo info) {
        // TODO  You will implement this method
        if(info instanceof PigGameState) {
            if (super.playerNum == ((PigGameState) info).getPlayerId()) {
                if (((PigGameState) info).getRunningTotal() >10 || ((PigGameState) info).getPlayer1Score()-((PigGameState) info).getPlayer0Score()>0
                        || 50- ((PigGameState) info).getPlayer1Score() < 40) {
                    super.game.sendAction(myHold);
                } else {
                    super.game.sendAction(myRoll);
                }
            } else {
                return;
            }
        }
    }//receiveInfo


}

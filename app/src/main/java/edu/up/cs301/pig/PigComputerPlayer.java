package edu.up.cs301.pig;

import android.util.Log;

import java.util.Random;

import edu.up.cs301.game.Game;
import edu.up.cs301.game.GameComputerPlayer;
import edu.up.cs301.game.GamePlayer;
import edu.up.cs301.game.actionMsg.GameAction;
import edu.up.cs301.game.infoMsg.GameInfo;
import edu.up.cs301.game.util.Tickable;

/**
 * An AI for Pig
 *
 * @author Andrew M. Nuxoll
 * @version August 2015
 */
public class PigComputerPlayer extends GameComputerPlayer {

    PigHoldAction myHold = new PigHoldAction(this);
    PigRollAction myRoll = new PigRollAction(this);
    /**
     * ctor does nothing extra
     */
    public PigComputerPlayer(String name) {

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
                Random rand = new Random();
                int randomAction = rand.nextInt(2);
                if (randomAction == 0) {
                    super.game.sendAction(myHold);
                } else {
                    super.game.sendAction(myRoll);
                }
              //  super.myTimer.setInterval(10);
            } else {
                return;
            }
        }
    }//receiveInfo


}

package io.zipcoder.casino;

import static io.zipcoder.casino.Card.FaceValue.ACE;

public class BlackJackPlayer extends CardPlayer<BlackJack> {

    public BlackJackPlayer(String name) {
        super(name);
    }

    public boolean hasAceInHand() {
        return hasCardsOfRank(ACE);
    }
}

import berkTheFaith.duel.Deck;
import berkTheFaith.duel.Player;
import berkTheFaith.card.NormalMonsterCard;
import org.junit.Before;

import berkTheFaith.card.*;
import org.junit.Test;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PlayerTest {

    private String deckTextFileAddress;
    private Player playerBerk, playerRival;
    private Card vorseRaider, blueEyesWhiteDragon;
    private Deck testHand;

    @Before
    public void init() {
        initCards();
        initDeckAddress();
        initPlayers();
        initTestHand();
    }


    public void initCards() {

        vorseRaider = new NormalMonsterCard(14898066, "Vorse Raider",
                "This wicked Beast-Warrior does every horrid thing imaginable, and loves it! " +
                        "His axe bears the marks of his countless victims.", CardTypes.NORMALMONSTER,
                "DARK", "Beast-Warrior", 1900, 1200, 4);

        blueEyesWhiteDragon = new NormalMonsterCard(89631139, "Blue-Eyes White Dragon",
                "This legendary dragon is a powerful engine of destruction. Virtually invincible, " +
                        "very few have faced this awesome creature and lived to tell the tale.",
                CardTypes.NORMALMONSTER, "LIGHT", "Dragon", 3000,
                2500, 8);
    }

    public void initDeckAddress() {
        deckTextFileAddress = "/3VorseRaider3BlueEyesDeck";
    }

    public void initPlayers() {
        String playerName = "Berk";
        playerBerk = new Player(playerName, deckTextFileAddress);
    }

    public void initTestHand() {
        testHand = new Deck();
        testHand.addCardToBottomOfDeck(vorseRaider);
        testHand.addCardToBottomOfDeck(vorseRaider);
        testHand.addCardToBottomOfDeck(vorseRaider);
        testHand.addCardToBottomOfDeck(blueEyesWhiteDragon);
        testHand.addCardToBottomOfDeck(blueEyesWhiteDragon);
    }

    @Test
    public void drawSingleCardFromDeckTest() {
        playerBerk.drawCardFromDeck();

        assert(playerBerk.getPlayerHand().revealTopCard().equals(vorseRaider));
        assert(playerBerk.getPlayerHand().getTopCardAndRemoveFromDeck().equals(vorseRaider));
    }

    @Test
    public void drawStartingHandTest() {

        Card expectedCard, actualCard;

        playerBerk.drawStartingHand();

        for (int i = 0; i < 5; i++) {

            expectedCard = playerBerk.getPlayerHand().getTopCardAndRemoveFromDeck();
            actualCard = testHand.getTopCardAndRemoveFromDeck();
            assert(expectedCard.equals(actualCard));
        }
    }

    //@Test
    public void startingHandToImageTest() throws InterruptedException, IOException {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation
                (JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(new FlowLayout());
        frame.setSize(2000,2000);
        JLabel label;

        BufferedImage cardImage;
        String cardName;

        for (int i = 0; i < 5; i++) {
            cardName = testHand.getTopCardAndRemoveFromDeck().getCardName();
            System.out.println(cardName);
            cardImage = ImageIO.read(new File("cardPictures/".concat(cardName).concat(".jpg")));
            ImageIcon icon = new ImageIcon(cardImage);
            label = new JLabel(icon);
            frame.add(label);
        }

        Thread.sleep(2000);

    }
}
package berkTheFaith;

import berkTheFaith.cardCreation.CardFileReader;

import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {

        CardFileReader cardFileReader;

        Scanner scanner = new Scanner(System.in);
        String cardName;

        while(true) {
            System.out.println("Enter card name to add to database: ");
            cardName = scanner.nextLine();

            if (cardName.equals("0"))
                break;
            cardFileReader = new CardFileReader(cardName);
            System.out.println(cardFileReader.readSingleCard());
        }
    }
}

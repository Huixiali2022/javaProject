import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CardDao {

    private File file;
    private static String SPILT_STRING = ";";

    public CardDao() {
    }

    public ArrayList<Card> createCards() {
        ArrayList<Card> cardList = new ArrayList<>();
        file = new File("./JavaQuestionsOrignal.txt");
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                String[] question = sc.nextLine().split(SPILT_STRING);
                Card card = new Card(question[0], question[1]);
                cardList.add(card);
            }
            sc.close();
            Collections.shuffle(cardList);

        } catch (Exception ex) {
            System.out.println("Oops, create cardList unsuccessful!");
        }
        return cardList;
    }

    public ArrayList<Card> AddCardInList(Card card, ArrayList<Card> cardList) {
        cardList.add(card);
        Collections.shuffle(cardList);
        return cardList;
    }

    public Card getNextCard(ArrayList<Card> cardList, int nowIndex) {
        return cardList.get(nowIndex + 1);
    }

    public Card getLastCard(ArrayList<Card> cardList, int nowIndex) {
        return cardList.get(nowIndex - 1);
    }
}

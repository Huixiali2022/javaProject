import java.util.ArrayList;
import java.util.Collections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class FlashCardController {
    int order = 0;
    ArrayList<Card> cardList = new CardDao().createCards();
    final int MAX_CARD_NUM = 50;

    @FXML
    private Button addNewCard;

    @FXML
    private Button doNotShowButton;

    @FXML
    private Button lastCard;

    @FXML
    private Button nextCard;

    @FXML
    private Button noShowAnswerButton;

    @FXML
    private Text numOfCard;

    @FXML
    private TextArea questionBack;

    @FXML
    private TextArea questionFront;

    @FXML
    private Button saveNewCardButton;

    @FXML
    private Button showAnswerButton;

    @FXML
    private Button startToStudyButton;

    @FXML
    void addNewCardButton(ActionEvent event) {
        questionBack.setText("");
        questionFront.setText("");
    }

    @FXML
    void deleteCardButton(ActionEvent event) {
        if (order > 0 && order < cardList.size()) {
            cardList.remove(order - 1);
            questionFront.setText(cardList.get(order - 1).frontString);
            questionBack.setText("");
            numOfCard.setText(order + "/" + cardList.size());
        } else if (order == cardList.size() && order != 1) {
            cardList.remove(order - 1);
            order--;
            questionFront.setText(cardList.get(order - 1).frontString);
            questionBack.setText("");
            numOfCard.setText(order + "/" + cardList.size());
        } else if (order == cardList.size() && order == 1) {
            cardList.remove(order - 1);
            questionBack.setText("");
            questionFront.setText("");
            numOfCard.setText("0/0");
        }
    }

    @FXML
    void lastCardButton(ActionEvent event) {
        if (cardList.size() != 0) {
            if (order > 1 && order <= cardList.size()) {
                order--;
                questionFront.setText(cardList.get(order - 1).frontString);
                questionBack.setText("");
                numOfCard.setText(order + "/" + cardList.size());
            } else if (order == 1) {
                questionFront.setText(cardList.get(order - 1).frontString);
                questionBack.setText("");
                numOfCard.setText(order + "/" + cardList.size());
            }
        } else {
            questionFront.setText("");
            questionBack.setText("");
            numOfCard.setText("0/0");
        }
    }

    @FXML
    void nextCardButton(ActionEvent event) {
        if (cardList.size() != 0) {
            if (order >= 0 && order < cardList.size()) {
                order++;
                questionFront.setText(cardList.get(order - 1).frontString);
                questionBack.setText("");

            } else if (order == cardList.size()) {
                questionFront.setText(cardList.get(cardList.size() - 1).frontString);
                questionBack.setText("");
            }
            numOfCard.setText(order + "/" + cardList.size());
        } else {
            questionBack.setText("");
            questionFront.setText("");
            numOfCard.setText("0/0");
        }
    }

    @FXML
    void noAnswerButton(ActionEvent event) {
        questionBack.setText("");
    }

    @FXML
    void saveNewCardButton(ActionEvent event) {
        if (cardList.size() < MAX_CARD_NUM) {
            Card newcard = new Card(questionFront.getText(), questionBack.getText());
            cardList.add(newcard);
            numOfCard.setText(order + "/" + cardList.size());
        } else {
            questionFront.setText("There are " + MAX_CARD_NUM + " cards, sorry, you can not add new cards!");
            questionBack.setText("");
        }
    }

    @FXML
    void showAnswerButton(ActionEvent event) {
        if (cardList.size() != 0 && order >= 1) {
            questionBack.setText(cardList.get(order - 1).getBackString());
        } else {
            questionBack.setText("");
        }
    }

    @FXML
    void startButton(ActionEvent event) {
        if (cardList.size() != 0) {
            Collections.shuffle(cardList);
            order = 1;
            questionFront.setText(cardList.get(order - 1).getFrontString());
            questionBack.setText("");
            numOfCard.setText(order + "/" + cardList.size());
        } else {
            questionFront.setText("No cards, please click 'Add A New Card' button to create a new card!");
        }
    }
}

public class Card {

    String frontString;
    String backString;

    public Card(String frontString, String backString) {
        this.frontString = frontString;
        this.backString = backString;
    }

    public String getFrontString() {
        return frontString;
    }

    public void setFrontString(String frontString) {
        this.frontString = frontString;
    }

    public String getBackString() {
        return backString;
    }

    public void setBackString(String backString) {
        this.backString = backString;
    }

}

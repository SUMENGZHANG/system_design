package Entity;

public class Card {

    private String type;
    private String rank;


    public Card(String type, String rank) {
        this.type = type;
        this.rank = rank;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}

package Backend;
public class Card {
    private String cardNumber;
    private String expirationDate;
    private int cvv;

    // Constructor
    public Card(String cardNumber, String expirationDate, int cvv) {
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
    }

    // Getter methods
    public String getCardNumber() {
        return cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public int getCvv() {
        return cvv;
    }

    // Setter methods
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }
}

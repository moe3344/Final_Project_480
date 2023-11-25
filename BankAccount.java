package package1;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
	private String cardNumber;
	private String expDate;
	private int CVV; 
	
    private static List<Card> cardList;
    private static List<String> expirationDate;
    private static List<Integer> cvv;

    static {
        // Initialize and populate the lists with sample values
        cardList = new ArrayList<>();
        expirationDate = new ArrayList<>();
        cvv = new ArrayList<>();

        for (int i = 1; i <= 8; i++) {
            cardList.add(new Card("1234-5678-9012-345" + i,"09/23",075));  // Sample card numbers
            expirationDate.add("0"+i+"/23");
            cvv.add(150+ i);  // Sample addresses
        }
    }
	
	public BankAccount(Card card) {
		this.cardNumber=card.getCardNumber();
		this.expDate=card.getExpirationDate();
		this.CVV=card.getCvv();
	}
	
	public boolean checkInfo() {
		int index=-1;
	
        for (int i = 0; i < cardList.size(); i++) {
            if (cardList.get(i).equals(cardNumber) && expirationDate.get(i).equals(expDate) && cvv.get(i).equals(CVV)) {
                index = i;
                System.out.println("Information is valid.");
                return true;
            }
            
        }
        return false;
		
	}
}

package package1;

public class Payment {
    private double FlightCost;
    private Card paymentCard;
    private boolean paymentStatus=false;

    // Constructor
    public Payment(double ticketPrice, Card userCard) {
        FlightCost = ticketPrice;
        paymentCard = userCard;
    }

    // Getter methods
    public double getAmount() {
        return FlightCost;
    }

    public Card getPaymentCard() {
        return paymentCard;
    }

    // Setter methods (if needed)
    public void setAmount(double amount) {
        this.FlightCost = amount;
    }

    public void setPaymentCard(Card paymentCard) {
        this.paymentCard = paymentCard;
    }

    // Other methods if needed
    // e.g., a method to process the payment
    public boolean processPayment() {
        
    	BankAccount user=new BankAccount(paymentCard);
    	if(user.checkInfo()==true) {
    		System.out.println("Payment processed successfully.");
    		paymentStatus=true;
    		return paymentStatus;
    	}
    	else {
    		System.out.println("Payment failed.");
    		return paymentStatus;
    	}
   
    }
}

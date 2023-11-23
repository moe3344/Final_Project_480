import java.util.Date;

public class Receipt {
    private int receiptNumber;
    private Date paymentDate;
    private double totalAmount;
    private String paymentMethod;

    // Constructor
    public Receipt(int receiptNumber, Date paymentDate, double totalAmount, String paymentMethod) {
        this.receiptNumber = receiptNumber;
        this.paymentDate = paymentDate;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
    }

    // Getter methods
    public int getReceiptNumber() {
        return receiptNumber;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    // Setter methods
    public void setReceiptNumber(int receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}

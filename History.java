package kataSG;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class History {
    private Calendar date;
    private String transaction;
    private double amount;
    private double balance;

    public History(Calendar date, String transaction, double amount, double balance) {
        this.date = date;
        this.transaction = transaction;
        this.amount = amount;
        this.balance = balance;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public String getTransaction() {
        return transaction;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        
        SimpleDateFormat format = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
        String formatted = format.format(date.getTime());

        return "{"+
                " date=" + formatted +"\r\n"+
                " transaction='" + transaction +"\r\n"+
                " amount=" + amount +"\r\n"+
                " balance=" + balance +
                '}';
    }
}

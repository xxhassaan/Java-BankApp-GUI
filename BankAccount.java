public interface BankAccount {
    String getAccountNumber();
    String getName();
    void setName(String name);
    double getBalance();
    void deposit(double amount);
    void withdraw(double amount);
}

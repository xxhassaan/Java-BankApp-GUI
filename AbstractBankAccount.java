import java.util.Random;

public abstract class AbstractBankAccount implements BankAccount {
    protected String accountNumber;
    protected String name;

    public AbstractBankAccount(String name) {
        this.name = name;
        this.accountNumber = generateAccountNumber();
    }

    private String generateAccountNumber() {
        Random random = new Random();
        int number = 10000000 + random.nextInt(90000000);
        return String.valueOf(number);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

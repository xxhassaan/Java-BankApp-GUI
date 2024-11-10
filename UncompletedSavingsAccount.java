public class UncompletedSavingsAccount extends AbstractBankAccount {
    private double balance;
    private boolean isSuspended;
    private double overdraftLimit;
    private Person person;  // Add Person object

    // Constructor that initializes the name, person, and calls the super constructor
    public UncompletedSavingsAccount(String name, Person person) {
        super(name);  // Calls AbstractBankAccount's constructor to initialize name and accountNumber
        this.person = person;
        this.balance = 0.0;
        this.isSuspended = false;
        this.overdraftLimit = 100.0;  // Set default overdraft limit
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be greater than zero.");
        } else {
            balance += amount;
            System.out.println("Deposited: " + amount + ". New Balance: " + balance);
        }
    }

    @Override
    public void withdraw(double amount) {
        if (isSuspended) {
            System.out.println("Account is suspended. Withdrawal not allowed.");
            return;
        }
        if (amount <= balance + overdraftLimit) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ". New Balance: " + balance);
            if (balance < 0) {
                System.out.println("Overdraft limit exceeded. Please contact your bank for assistance and interest rates.");
            }
        } else {
            System.out.println("Insufficient funds, even with overdraft.");
        }
    }

    @Override
    public double getBalance() {
        return balance;
    }

    public void suspend() {
        isSuspended = true;
        System.out.println("Account suspended.");
    }

    public void resume() {
        isSuspended = false;
        System.out.println("Account resumed.");
    }

    public Person getPerson() {
        return person;  // Getter for Person object
    }
}

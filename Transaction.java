abstract class Transaction {
    protected String accountNumber;
    protected BankService bankService;

    public Transaction(String accountNumber, BankService bankService) {
        this.accountNumber = accountNumber;
        this.bankService = bankService;
    }

    public abstract void execute();

    public abstract void printReceipt();
}
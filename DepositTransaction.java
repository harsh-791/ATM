class DepositTransaction extends Transaction {
    private int amount;

    public DepositTransaction(String accountNumber, BankService bankService, int amount) {
        super(accountNumber, bankService);
        this.amount = amount;
    }

    @Override
    public void execute() {
        bankService.credit(accountNumber, amount);
        printReceipt();
    }

    @Override
    public void printReceipt() {
        System.out.println("Receipt: Deposit of " + amount + " successful.");
    }
}

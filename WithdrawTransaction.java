class WithdrawTransaction extends Transaction {
    private int amount;
    private CashDispenser cashDispenser;

    public WithdrawTransaction(String accountNumber, BankService bankService, int amount, CashDispenser cashDispenser) {
        super(accountNumber, bankService);
        this.amount = amount;
        this.cashDispenser = cashDispenser;
    }

    @Override
    public void execute() {
        if (bankService.debit(accountNumber, amount)) {
            cashDispenser.dispense(amount);
            printReceipt();
        } else {
            System.out.println("Insufficient funds or daily limit reached.");
        }
    }

    @Override
    public void printReceipt() {
        System.out.println("Receipt: Withdrawal of " + amount + " successful.");
    }
}

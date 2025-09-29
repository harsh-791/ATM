class BankStatementTransaction extends Transaction {
    public BankStatementTransaction(String accountNumber, BankService bankService) {
        super(accountNumber, bankService);
    }

    @Override
    public void execute() {
        String statement = bankService.getStatement(accountNumber);
        System.out.println(statement);
        printReceipt();
    }

    @Override
    public void printReceipt() {
        System.out.println("Receipt: Bank statement printed.");
    }
}

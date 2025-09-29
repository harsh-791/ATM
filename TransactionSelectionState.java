class TransactionSelectionState implements State {
    private ATM atm;
    private String accountNumber;

    public TransactionSelectionState(ATM atm, String accountNumber) {
        this.atm = atm;
        this.accountNumber = accountNumber;
    }

    public void startInteraction() {
        while (true) {
            System.out.println("Select Transaction: 1) Withdraw 2) Deposit 3) Statement 4) Eject");
            String choice = atm.getInputDevice().getInput();
            if (choice == null) {
                System.out.println("Invalid input.");
                continue;
            }
            choice = choice.trim();
            if ("1".equals(choice)) {
                System.out.println("Enter amount to withdraw:");
                String amtStr = atm.getInputDevice().getInput();
                try {
                    int amount = Integer.parseInt(amtStr.trim());
                    Transaction withdraw = new WithdrawTransaction(accountNumber, atm.getBankService(), amount,
                            atm.getCashDispenser());
                    selectTransaction(withdraw);
                    return;
                } catch (Exception e) {
                    System.out.println("Invalid amount.");
                }
            } else if ("2".equals(choice)) {
                System.out.println("Enter amount to deposit:");
                String amtStr = atm.getInputDevice().getInput();
                try {
                    int amount = Integer.parseInt(amtStr.trim());
                    Transaction deposit = new DepositTransaction(accountNumber, atm.getBankService(), amount);
                    selectTransaction(deposit);
                    return;
                } catch (Exception e) {
                    System.out.println("Invalid amount.");
                }
            } else if ("3".equals(choice)) {
                Transaction statement = new BankStatementTransaction(accountNumber, atm.getBankService());
                selectTransaction(statement);
                return;
            } else if ("4".equals(choice)) {
                ejectCard();
                return;
            } else {
                System.out.println("Please select a valid option.");
            }
        }
    }

    @Override
    public void selectTransaction(Transaction transaction) {
        transaction.execute();
        atm.setState(new IdleState(atm));
    }

    public void insertCard(String cardNumber) {
        System.out.println("Card already inserted.");
    }

    public void enterPin(String pin) {
        System.out.println("PIN already entered.");
    }

    public void ejectCard() {
        System.out.println("Card ejected.");
        atm.setState(new IdleState(atm));
    }
}
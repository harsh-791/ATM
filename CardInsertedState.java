class CardInsertedState implements State {
    private ATM atm;
    private String cardNumber;

    public CardInsertedState(ATM atm, String cardNumber) {
        this.atm = atm;
        this.cardNumber = cardNumber;
    }

    @Override
    public void enterPin(String pin) {
        if (atm.getBankService().validatePin(cardNumber, pin)) {
            System.out.println("PIN validated.");
            TransactionSelectionState selectionState = new TransactionSelectionState(atm, cardNumber);
            atm.setState(selectionState);
            selectionState.startInteraction();
        } else {
            System.out.println("Invalid PIN. Try again.");
        }
    }

    public void insertCard(String cardNumber) {
        System.out.println("Card already inserted.");
    }

    public void selectTransaction(Transaction transaction) {
        System.out.println("Enter PIN first.");
    }

    public void ejectCard() {
        System.out.println("Card ejected.");
        atm.setState(new IdleState(atm));
    }
}
class IdleState implements State {
    private ATM atm;

    public IdleState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void insertCard(String cardNumber) {
        if (atm.getCardReader().validateCard(cardNumber)) {
            System.out.println("Card accepted.");
            atm.setState(new CardInsertedState(atm, cardNumber));
            System.out.println("Enter PIN:");
            String pin = atm.getInputDevice().getInput();
            atm.enterPin(pin);
        } else {
            System.out.println("Invalid or expired card.");
        }
    }

    public void enterPin(String pin) {
        System.out.println("Insert card first.");
    }

    public void selectTransaction(Transaction transaction) {
        System.out.println("Insert card first.");
    }

    public void ejectCard() {
        System.out.println("No card to eject.");
    }
}
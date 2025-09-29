interface State {
    void insertCard(String cardNumber);

    void enterPin(String pin);

    void selectTransaction(Transaction transaction);

    void ejectCard();
}
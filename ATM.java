class ATM {
    private State state;
    private CardReader cardReader;
    private CashDispenser cashDispenser;
    private InputDevice inputDevice;
    private BankService bankService;

    public ATM(CardReader cardReader, CashDispenser cashDispenser, InputDevice inputDevice, BankService bankService) {
        this.cardReader = cardReader;
        this.cashDispenser = cashDispenser;
        this.inputDevice = inputDevice;
        this.bankService = bankService;
        this.state = new IdleState(this);
    }

    public void setState(State state) {
        this.state = state;
    }

    public void insertCard(String cardNumber) {
        state.insertCard(cardNumber);
    }

    public void enterPin(String pin) {
        state.enterPin(pin);
    }

    public void selectTransaction(Transaction transaction) {
        state.selectTransaction(transaction);
    }

    public void ejectCard() {
        state.ejectCard();
    }

    public BankService getBankService() {
        return bankService;
    }

    public CashDispenser getCashDispenser() {
        return cashDispenser;
    }

    public InputDevice getInputDevice() {
        return inputDevice;
    }

    public CardReader getCardReader() {
        return cardReader;
    }
}

public class Main {
    public static void main(String[] args) {
        CardReader cardReader = new CardReader();
        CashDispenser cashDispenser = new CashDispenser();
        InputDevice inputDevice = new ConsoleInput();
        BankService bankService = new HDFCService();

        ATM atm = new ATM(cardReader, cashDispenser, inputDevice, bankService);

        atm.insertCard("123456789");
    }
}

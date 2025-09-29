interface BankService {
    boolean validateCard(String cardNumber);

    boolean validatePin(String cardNumber, String pin);

    boolean debit(String accountNumber, int amount);

    void credit(String accountNumber, int amount);

    String getStatement(String accountNumber);
}

class SBIService implements BankService {
    public boolean validateCard(String cardNumber) {
        return cardNumber.startsWith("5678");
    }

    public boolean validatePin(String cardNumber, String pin) {
        return pin.equals("1111");
    }

    public boolean debit(String accountNumber, int amount) {
        if (amount <= 7000) {
            System.out.println("[SBI] Debited " + amount + " from " + accountNumber);
            return true;
        }
        return false;
    }

    public void credit(String accountNumber, int amount) {
        System.out.println("[SBI] Credited " + amount + " to " + accountNumber);
    }

    public String getStatement(String accountNumber) {
        return "[SBI] Statement for account " + accountNumber + ": Balance = 15000";
    }
}

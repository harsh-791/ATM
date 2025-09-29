class HDFCService implements BankService {
    public boolean validateCard(String cardNumber) {
        return cardNumber.startsWith("1234");
    }

    public boolean validatePin(String cardNumber, String pin) {
        return pin.equals("0000");
    }

    public boolean debit(String accountNumber, int amount) {
        if (amount <= 5000) {
            System.out.println("[HDFC] Debited " + amount + " from " + accountNumber);
            return true;
        }
        return false;
    }

    public void credit(String accountNumber, int amount) {
        System.out.println("[HDFC] Credited " + amount + " to " + accountNumber);
    }

    public String getStatement(String accountNumber) {
        return "[HDFC] Statement for account " + accountNumber + ": Balance = 10000";
    }
}

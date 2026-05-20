class Solution {
    public List<String> invalidTransactions(String[] transactions) {
    List<String> list = new ArrayList<>();
    // 1. Change Set to hold the custom Transaction objects instead of Strings
    Set<Transaction> invalidSet = new HashSet<>(); 
    Map<String, List<Transaction>> map = new HashMap<>();

    for (String transaction : transactions) {
        Transaction t = new Transaction(transaction);

        if (t.amount > 1000) {
            invalidSet.add(t); // Track the object reference
        }

        final List<Transaction> existingTrans = map.getOrDefault(t.name, new ArrayList<>());

        for (Transaction oldTrans : existingTrans) {
            if (!t.city.equals(oldTrans.city) && Math.abs(t.time - oldTrans.time) <= 60) {
                invalidSet.add(t);        // Track current
                invalidSet.add(oldTrans); // Track historical match
            }
        }

        existingTrans.add(t);
        map.put(t.name, existingTrans);
    }

    // 2. Simply map the unique invalid objects back to their original strings
    for (Transaction t : invalidSet) {
        list.add(t.ogTransaction);
    }
    
    return list;
}
}

class Transaction {
    String name;
    int time;
    int amount;
    String city;
    String ogTransaction;

    public Transaction(String transaction) {
        ogTransaction = transaction;
        String[] split = transaction.split(",");
        name = split[0];
        time = Integer.parseInt(split[1]);
        amount = Integer.parseInt(split[2]);
        city = split[3];
    }

}
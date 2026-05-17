class RandomizedSet {

    private final Map<Integer, Integer> valueMap;
    private final List<Integer> list;
    private final Random random;

    public RandomizedSet() {
        valueMap = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if(valueMap.containsKey(val)){
            return false;
        }
        list.add(val);
        valueMap.put(val,list.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!valueMap.containsKey(val)){
            return false;
        }
        int indexToRemove = valueMap.remove(val);
        if(indexToRemove == list.size()-1){
            list.remove(list.size()-1);
            return true;
        }
        list.set(indexToRemove,list.get(list.size()-1));
        int lastValue = list.remove(list.size()-1);
        valueMap.put(lastValue,indexToRemove);
        return true;
    }
    
    public int getRandom() {
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
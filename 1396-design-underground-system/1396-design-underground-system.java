class UndergroundSystem {

    Map<Integer, Customer> map = new HashMap<>();
    Map<String, Average> avgMap = new HashMap<>();

    public UndergroundSystem() {
        
    }
    
    public void checkIn(int id, String stationName, int t) {
        Customer customer = new Customer();
        
        customer.id = id;
        customer.checkinStation = stationName;
        customer.checkinTime = t;

        map.put(id, customer);
    }
    
    public void checkOut(int id, String stationName, int t) {
        Customer customer = map.get(id);

        customer.checkoutStation = stationName;
        customer.checkoutTime = t;

        String key = customer.checkinStation + "-->" + customer.checkoutStation;
        int totalTime = customer.checkoutTime - customer.checkinTime;

        if(avgMap.containsKey(key)){
            
            Average avg = avgMap.get(key);
            avg.count += 1;
            avg.total += totalTime; 

        }else{
            
            Average avg = new Average();
            avg.count = 1;
            avg.total = totalTime; 

            avgMap.put(key,avg);

        }

    }
    
    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "-->" + endStation;
        Average averageObj = avgMap.get(key);
        double avg = (averageObj.total * 1.0) / averageObj.count;
        return avg;
    }

    class Customer {

        int id;

        String checkinStation;
        int checkinTime;

        String checkoutStation;
        int checkoutTime;    
        
    }

    class Average {

        int count;
        int total;
    }


}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
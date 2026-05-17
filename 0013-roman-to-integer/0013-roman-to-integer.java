class Solution {
    public int romanToInt(String s) {
        final Map<String,Integer> refMap = buildRefMap();

        int index = 0;
        int count = 0;

        while(index < s.length()){
            char ch = s.charAt(index);
            switch(ch){
                case 'I':
                    if(index + 1 < s.length()){
                        if(s.charAt(index + 1) == 'V' || s.charAt(index + 1) == 'X' ){
                            count += refMap.get(ch + "" + s.charAt(index+1));
                            index +=2;
                            break;
                        } else{
                            count += refMap.get(ch+"");
                        }
                    }else{
                        count += refMap.get(ch+"");
                    }
                    index++;
                    break;
                case 'X':
                    if(index + 1 < s.length()){
                        if(s.charAt(index + 1) == 'L' || s.charAt(index + 1) == 'C' ){
                            count += refMap.get(ch + "" + s.charAt(index+1));
                            index +=2;
                            break;
                        }
                        else{
                            count += refMap.get(ch+"");
                        }
                    }else{
                        count += refMap.get(ch+"");
                    }
                    index++;
                    break;
                case 'C':
                    if(index + 1 < s.length()){
                        if(s.charAt(index + 1) == 'D' || s.charAt(index + 1) == 'M' ){
                            count += refMap.get(ch + "" + s.charAt(index+1));
                            index +=2;
                            break;
                        }else{
                            count += refMap.get(ch+"");
                        }
                    }else{
                        count += refMap.get(ch+"");
                    }
                    index++;
                    break;
                default:
                    count += refMap.get(ch+"");
                    index++;
                    break;
            }
        }

        return count;

    }

    public Map<String,Integer> buildRefMap(){
        final Map<String,Integer> refMap = new HashMap<>();
        refMap.put("I",1);
        refMap.put("V",5);
        refMap.put("X",10);
        refMap.put("L",50);
        refMap.put("C",100);
        refMap.put("D",500);
        refMap.put("M",1000);
        
        refMap.put("IV",4);
        refMap.put("IX",9);
        refMap.put("XL",40);
        refMap.put("XC",90);
        refMap.put("CD",400);
        refMap.put("CM",900);
        return refMap;
    }
}
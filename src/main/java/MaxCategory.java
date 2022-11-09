import java.util.*;
import java.util.stream.Stream;

public class MaxCategory {
   private Map<String,Integer> ages = new HashMap<>();
    private Map<String,Integer> agesYear = new HashMap<>();
    private Map<String,Integer> agesMount = new HashMap<>();
    private Map<String,Integer> agesDay = new HashMap<>();
    private String category;
    private Integer sum;

    public MaxCategory() {
        this.category = category;
        this.sum = sum;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }


    public void People (String category1, Integer sum1) {
        if (ages.get(category1) == null) {
            ages.put(category1, sum1);
        } else {
            int sum2 = ages.get(category1) + sum1;
            ages.put(category1, sum2);
            System.out.println(ages);
        }
        Collection<String> collection= ages.keySet();
        String maxtitle = ages.entrySet().stream()
       .filter(entry -> Collections.max(ages.values()).equals(entry.getValue()))
            .findFirst().map(Map.Entry::getKey)
                .orElse(null);
//        map.keySet()
//                .stream()
//                .filter(key -> value.equals(map.get(key)))
//                .findFirst().get();
        System.out.println(maxtitle + " " + Collections.max(ages.values()));
        Calendar calendar = Calendar.getInstance();
        String data = calendar.get(Calendar.YEAR) + "." + (calendar.get(Calendar.MONTH) + 1) + "." + calendar.get(Calendar.DAY_OF_MONTH);
}
public void PeopleYear(String category1,int data, Integer sum1){
    Calendar calendar = Calendar.getInstance();
        if(data==calendar.get(Calendar.YEAR) ) {
            if (agesYear.get(category1) == null) {
                agesYear.put(category1, sum1);
            } else {
                int sum2 = agesYear.get(category1) + sum1;
                agesYear.put(category1, sum2);
                System.out.println(agesYear);
            }
            Collection<String> collection = agesYear.keySet();
            String maxtitle = agesYear.entrySet().stream()
                    .filter(entry -> Collections.max(agesYear.values()).equals(entry.getValue()))
                    .findFirst().map(Map.Entry::getKey)
                    .orElse(null);
//        map.keySet()
//                .stream()
//                .filter(key -> value.equals(map.get(key)))
//                .findFirst().get();
            System.out.println("maxYear "+ maxtitle + " " + Collections.max(agesYear.values()));
        }else{
            System.out.println("not this maxYear");
    }
}
    public void PeopleMount(String category1,int data, Integer sum1){
        Calendar calendar = Calendar.getInstance();
        if(data==(calendar.get(Calendar.MONTH) +1)) {
            if (agesMount.get(category1) == null) {
                agesMount.put(category1, sum1);
            } else {
                int sum2 = agesMount.get(category1) + sum1;
                agesMount.put(category1, sum2);
                System.out.println(agesMount);
            }
            Collection<String> collection = agesMount.keySet();
            String maxtitle = agesMount.entrySet().stream()
                    .filter(entry -> Collections.max(agesMount.values()).equals(entry.getValue()))
                    .findFirst().map(Map.Entry::getKey)
                    .orElse(null);
//        map.keySet()
//                .stream()
//                .filter(key -> value.equals(map.get(key)))
//                .findFirst().get();
            System.out.println("maxMount "+ maxtitle + " " + Collections.max(agesMount.values()));
        }else{
            System.out.println("not this maxMount");
        }
    }
    public void PeopleDays(String category1,int data, Integer sum1){
        Calendar calendar = Calendar.getInstance();
        if(data==(calendar.get(Calendar.DATE) +1)) {
            if (agesDay.get(category1) == null) {
                agesDay.put(category1, sum1);
            } else {
                int sum2 = agesDay.get(category1) + sum1;
                agesDay.put(category1, sum2);
                System.out.println(agesDay);
            }
            Collection<String> collection = agesDay.keySet();
            String maxtitle = agesDay.entrySet().stream()
                    .filter(entry -> Collections.max(agesDay.values()).equals(entry.getValue()))
                    .findFirst().map(Map.Entry::getKey)
                    .orElse(null);
//        map.keySet()
//                .stream()
//                .filter(key -> value.equals(map.get(key)))
//                .findFirst().get();
            System.out.println("maxDate "+ maxtitle + " " + Collections.max(agesDay.values()));
        }else{
            System.out.println("not this dateMount");
        }
    }

}

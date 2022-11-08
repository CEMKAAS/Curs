import java.util.*;
import java.util.stream.Stream;

public class MaxCategory {
   private Map<String,Integer> ages = new HashMap<>();
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
    }





}

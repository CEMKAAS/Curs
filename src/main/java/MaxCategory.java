import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class MaxCategory {

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


    public void People (String category1, Integer sum1){
        Map<String,Integer> ages = new HashMap<>();
        Integer sum2 = 0;
        sum2 += sum1;
        ages.put(category1, sum2);

       

        Collections.sort(people, comparator1);
        System.out.println(people);
        System.out.println(ages. Collections.max(ages.values()));
        System.out.println(ages);
    }






}

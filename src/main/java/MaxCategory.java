import com.google.gson.Gson;

import java.util.*;

public class MaxCategory {
    private Map<String, Integer> ages = new HashMap<>();
    private ArrayList<MaxTime> arraysDays = new ArrayList<>();
    private ArrayList<MaxTime> arraysMount = new ArrayList<>();
    private ArrayList<MaxTime> arraysYear = new ArrayList<>();


    public MaxJson People(String category1, Integer sum1) {
        if (ages.get(category1) == null) {
            ages.put(category1, sum1);
        } else {
            int sum2 = ages.get(category1) + sum1;
            ages.put(category1, sum2);
        }
        String maxtitle = ages.entrySet().stream()
                .filter(entry -> Collections.max(ages.values()).equals(entry.getValue()))
                .findFirst().map(Map.Entry::getKey)
                .orElse(null);
        return new MaxJson("maxCategory", maxtitle, Collections.max(ages.values()));
    }

    public MaxJson People3 (String category1, String data2, Integer sum1) {
        arraysDays.add(new MaxTime(category1, data2, sum1));
        String[] string1 = add(data2,arraysDays).split(" ");
        String maxtitle = string1[0];
        Integer maxSumm = Integer.valueOf(string1[1]);
        return new MaxJson("maxDayCategory", maxtitle, maxSumm);
    }

    public MaxJson  People4(String category1, String data2, Integer sum1) {
        arraysMount.add(new MaxTime(category1, data2, sum1));
        String[] string1 = add(data2,arraysMount).split(" ");
        String maxtitle =string1[0];
        Integer maxSumm = Integer.valueOf(string1[1]);
        return new MaxJson("maxMonthCategory", maxtitle, maxSumm);
}

    public MaxJson People5 (String category1, String data2, Integer sum1) {
        arraysYear.add(new MaxTime(category1, data2, sum1));
        String[] string1 = add(data2,arraysYear).split(" ");
        String maxtitle =string1[0];
        Integer maxSumm = Integer.valueOf(string1[1]);
        return new MaxJson("maxYearCategory", maxtitle, maxSumm);
    }

    public String  add(String data2, ArrayList list) {
        Map<String, Integer> days = new HashMap<>();
        Iterator<MaxTime> maxTimeIterator = list.iterator();
        while (maxTimeIterator.hasNext()) {
            MaxTime max = maxTimeIterator.next();
            if (max.getDate().equals(data2)) {
                if (days.get(max.getTitle()) == null) {
                    days.put(max.getTitle(), max.getSum());
                } else {
                    int sum2 = days.get(max.getTitle()) + max.getSum();
                    days.put(max.getTitle(), sum2);
                }
            }
        }
        String maxtitle = days.entrySet().stream()
                .filter(entry -> Collections.max(days.values()).equals(entry.getValue()))
                .findFirst().map(Map.Entry::getKey)
                .orElse(null);

        System.out.println("Год" + maxtitle + " " + Collections.max(days.values()));
        return maxtitle+" "+Collections.max(days.values());
    }



}
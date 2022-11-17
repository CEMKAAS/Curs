import com.google.gson.Gson;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        MaxCategory maxCategory = new MaxCategory();
        try (ServerSocket serverSocket = new ServerSocket(8080);) {
            while (true) { // в цикле(!) принимаем подключени€
                try (
                        Socket socket = serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                ) {

                    out.println("Start Server");
                    String serverResponseTwo = in.readLine();
                    Gson gson = new Gson();
                    Category category = gson.fromJson(serverResponseTwo, Category.class);
                    System.out.println(category.getTitle());

                    CSVParser parser = new CSVParserBuilder()
                            .withSeparator('\t')
                            .build();
                    CSVReader reader = new CSVReaderBuilder(new FileReader("categories.tsv"))
                            .withCSVParser(parser)
                            .build();

                    String[] nextLine;

                    Map<String, String> days = new HashMap<>();
                    List<String[]> time = reader.readAll();
                    for (String[] num : time
                    ) {
                        String two = num[0];
                        String sum = num[1];
                        days.put(two, sum);
                    }

                    System.out.println(days.get(category.getTitle()));
                    if (days.get(category.getTitle()) != null) {
                        String[] mount = category.getDate().split("\\.");
                        String mountTwo = mount[1];
                        String mountTrne = mount[2];
                        String sum = days.get(category.getTitle());
                        String sd = gson.toJson(maxCategory.People(sum, category.getSum()));
                           String sd1 =     gson.toJson(maxCategory.People3(sum, category.getDate(), category.getSum()));
                                String sd2 =        gson.toJson(maxCategory.People4(sum, mountTwo + "." + mountTrne, category.getSum()));
                                String sd3 =       gson.toJson(maxCategory.People5(sum, mountTrne, category.getSum()));

                        out.println(
                                sd + sd1 + sd2 + sd3
                        );
                    } else {
                        String sum = "другое";
                        String[] mount = category.getDate().split("\\.");
                        String mountTwo = mount[1];
                        String mountTrne = mount[2];

                        MaxJson maxCategot = (maxCategory.People(sum, category.getSum()));
                        maxCategot.getCategory();
                        maxCategot.getSum();

                        out.println(gson.toJson(maxCategot.getCategory()));
//                        out.println(
//                                gson.toJson(maxCategory.People(sum, category.getSum())) + "\n" +
//                                        gson.toJson(maxCategory.People3(sum, category.getDate(), category.getSum())) + "\n" +
//                                        gson.toJson(maxCategory.People4(sum, mountTwo + "." + mountTrne, category.getSum())) + "\n" +
//                                        gson.toJson(maxCategory.People5(sum, mountTrne, category.getSum())));
                    }


//                    Iterator<CategoryTSV> maxTimeIterator = sda.iterator();
//                    while (maxTimeIterator.hasNext()) {
//                        CategoryTSV max = maxTimeIterator.next();
//                      if(max.getCategotyTSV().equals(category.getTitle())){
//                            String[] mount = category.getDate().split("\\.");
//                            String mountTwo = mount[1];
//                            String mountTrne = mount[2];
//                            String title = max.getName();
//                            String sum = max.getCategotyTSV();
//                            if (two.equals(category.getTitle())) {
//                                out.println(
//                                        gson.toJson(maxCategory.People(sum, category.getSum())) + "\n" +
//                                                gson.toJson(maxCategory.People3(sum, category.getDate(), category.getSum())) + "\n" +
//                                                gson.toJson(maxCategory.People4(sum, mountTwo + "." + mountTrne, category.getSum())) + "\n" +
//                                                gson.toJson(maxCategory.People5(sum, mountTrne, category.getSum())));
//                                break;
//                            }
//                        }
//                    }
//
//
//
//                    if (sda.contains(category.getTitle())) {
//                        String[] mount = category.getDate().split("\\.");
//                        String mountTwo = mount[1];
//                        String mountTrne = mount[2];
//                        String title = sda.;
//                        String sum = nextLine[1];
//                        if (two.equals(category.getTitle())) {
//                            out.println(
//                                    gson.toJson(maxCategory.People(sum, category.getSum())) + "\n" +
//                                            gson.toJson(maxCategory.People3(sum, category.getDate(), category.getSum())) + "\n" +
//                                            gson.toJson(maxCategory.People4(sum, mountTwo + "." + mountTrne, category.getSum())) + "\n" +
//                                            gson.toJson(maxCategory.People5(sum, mountTrne, category.getSum())));
//                            break;
//                        } else {
//                            sum = "другое";
//                            out.println(
//                                    gson.toJson(maxCategory.People(sum, category.getSum())) + "\n" +
//                                            gson.toJson(maxCategory.People3(sum, category.getDate(), category.getSum())) + "\n" +
//                                            gson.toJson(maxCategory.People4(sum, mountTwo + "." + mountTrne, category.getSum())) + "\n" +
//                                            gson.toJson(maxCategory.People5(sum, mountTrne, category.getSum())));
//                        }
//                    }

//                    while ((nextLine = reader.readNext()) != null) {
//                        String title = nextLine[0];
//                        String[] mount = category.getDate().split("\\.");
//                        String mountTwo = mount[1];
//                        String mountTrne = mount[2];
//                        String sum = nextLine[1];
//                        if (title.equals(category.getTitle())) {
//                            out.println(
//                                    gson.toJson(maxCategory.People(sum, category.getSum())) + "\n" +
//                                            gson.toJson(maxCategory.People3(sum, category.getDate(), category.getSum())) + "\n" +
//                                            gson.toJson(maxCategory.People4(sum, mountTwo + "." + mountTrne, category.getSum())) + "\n" +
//                                            gson.toJson(maxCategory.People5(sum, mountTrne, category.getSum())));
//                            break;
//                        } else if(category.getTitle()) {
//
//                            sum = "другое";
//                            out.println(
//                                    gson.toJson(maxCategory.People(sum, category.getSum())) + "\n" +
//                                            gson.toJson(maxCategory.People3(sum, category.getDate(), category.getSum())) + "\n" +
//                                            gson.toJson(maxCategory.People4(sum, mountTwo + "." + mountTrne, category.getSum())) + "\n" +
//                                            gson.toJson(maxCategory.People5(sum, mountTrne, category.getSum())));

                }
            }
        } catch (
                IOException e) {
            System.out.println("Ќе могу стартовать сервер");
            e.printStackTrace();
        }
    }
}
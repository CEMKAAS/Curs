import com.google.gson.Gson;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private MaxCategory maxCategory = new MaxCategory();

    public void server() {
        try (ServerSocket serverSocket = new ServerSocket(8080);) {
            while (true) { // в цикле(!) принимаем подключения
                try (
                        Socket socket = serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                ) {
                    out.println("Start!" + " Введите покупку и сумму в таком формате " + "пример: булка 03.10.2022 300");

                    String dataEntry = in.readLine();
                    Gson gson = new Gson();
                    Category category = gson.fromJson(dataEntry, Category.class);

                    System.out.println(category.getTitle());//можно удалить

                    //парсим
                    CSVParser parser = new CSVParserBuilder()
                            .withSeparator('\t')
                            .build();
                    CSVReader reader = new CSVReaderBuilder(new FileReader("categories.tsv"))
                            .withCSVParser(parser)
                            .build();

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

                        out.println(
                                output(category, days.get(category.getTitle()))
                        );

//                        String[] mount = category.getDate().split("\\.");
//                        String mountTwo = mount[1];
//                        String mountTrne = mount[2];
//                        String sum = days.get(category.getTitle());
//                        String sd = gson.toJson(maxCategory.People(sum, category.getSum()));
//                        String sd1 = gson.toJson(maxCategory.People3(sum, category.getDate(), category.getSum()));
//                        String sd2 = gson.toJson(maxCategory.People4(sum, mountTwo + "." + mountTrne, category.getSum()));
//                        String sd3 = gson.toJson(maxCategory.People5(sum, mountTrne, category.getSum()));
//
//                        out.println(
//                                sd + sd1 + sd2 + sd3
//                        );
                    } else {
                        out.println(
                                output(category, "другое")
                        );
//                        String sum = "другое";
//                        String[] mount = category.getDate().split("\\.");
//                        String mountTwo = mount[1];
//                        String mountTrne = mount[2];
//
//                        MaxJson maxCategot = (maxCategory.People(sum, category.getSum()));
//                        maxCategot.getCategory();
//                        maxCategot.getSum();
//
//                        out.println(gson.toJson(maxCategot.getCategory()));
                    }
                }
            }
        } catch (
                IOException e) {
            System.out.println("Не могу стартовать сервер");
            e.printStackTrace();
        }
    }

    public String output(Category category, String sum) {
        Gson gson = new Gson();
        String[] mount = category.getDate().split("\\.");
        String mountTwo = mount[1];
        String mountTrne = mount[2];
        String sd = gson.toJson(maxCategory.People(sum, category.getSum()));
        String sd1 = gson.toJson(maxCategory.People3(sum, category.getDate(), category.getSum()));
        String sd2 = gson.toJson(maxCategory.People4(sum, mountTwo + "." + mountTrne, category.getSum()));
        String sd3 = gson.toJson(maxCategory.People5(sum, mountTrne, category.getSum()));
        return sd + sd1 + sd2 + sd3;
    }
}
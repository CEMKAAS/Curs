import com.google.gson.Gson;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(8080);) {
//String[] tsv = "булка'\t'еда'\t'колбаса'\t'еда'\t'сухарики'\t'еда'\t'курица'\t'еда'\t'тапки'\t'одежда'\t'шапка'\t'одежда'\t'мыло'\t'быт'\t'акции'\t'финасы".split(String.valueOf('\t'));
//        String[] tsv1 = "булка|еда".split(String.valueOf('|'));
//
//            try (CSVWriter writer = new CSVWriter(new FileWriter("categories.tsv", true))) {
//                writer.writeNext(tsv);
//                writer.writeNext(tsv1);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            File tsvFile = new File("categories.tsv");
//            PrintWriter tsv = new PrintWriter(tsvFile);
//            tsv.print("булка" + '\t' + "eда");
//            tsv.println("колбаса" + '\t' + "eда");
//            tsv.println("сухарики" + '\t' + "eда");
//            tsv.println("курица" + '\t' + "eда");
//            tsv.println("тапки" + '\t' + "одежда");
//            tsv.println("шапка" + '\t' + "одежда");
//            tsv.println("мыло" + '\t' + "быт");
//            tsv.println("акции" + '\t' + "финансы");

            while (true) { // в цикле(!) принимаем подключения
                try (
                        Socket socket = serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                ) {
                    MaxCategory maxCategory = new MaxCategory();
                    out.println("Start Server");
                    String serverResponseTwo = in.readLine();
                    Gson gson = new Gson();
                    Category category = gson.fromJson(serverResponseTwo, Category.class);
                    System.out.println(category.getTitle());

//                    try (CSVReader csvReader = new CSVReader(new FileReader("categories.tsv"))){
//                        ColumnPositionMappingStrategy<TsvCategories> strategy = new ColumnPositionMappingStrategy<>();
//                        strategy.setType(TsvCategories.class);
//                        strategy.setColumnMapping(new String[]{"title", "titleCategory"});
//                        CsvToBean<TsvCategories> csv = new CsvToBeanBuilder<TsvCategories>(csvReader)
//                                .withMappingStrategy(strategy)
//                                .build();
//                        List<TsvCategories> list = csv.parse();
//                        list.forEach(System.out::println);
//
//                    }catch (IOException e){
//                        e.printStackTrace();
//                    }
                    CSVParser parser = new CSVParserBuilder()
                            .withSeparator('\t')
                            .build();
                    CSVReader reader = new CSVReaderBuilder(new FileReader("categories.tsv"))
                            .withCSVParser(parser)
                            .build();

                    String[] nextLine;
                    while ((nextLine= reader.readNext()) != null){
                        String title = nextLine[0];
                        String  sum = nextLine[1];
                        if (title.equals(category.getTitle())){
                            maxCategory.People(sum, category.getSum());
                            System.out.println(title +" " + sum);
                            break;
                        }else {
                            //TODO категория другая
                        }

                    }

                }
            }
        } catch (IOException e) {
            System.out.println("Не могу стартовать сервер");
            e.printStackTrace();
        }
    }

}

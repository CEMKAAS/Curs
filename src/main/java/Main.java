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
import java.util.Calendar;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MaxCategory maxCategory = new MaxCategory();
        try (ServerSocket serverSocket = new ServerSocket(8080);) {
//String[] tsv = "�����'\t'���'\t'�������'\t'���'\t'��������'\t'���'\t'������'\t'���'\t'�����'\t'������'\t'�����'\t'������'\t'����'\t'���'\t'�����'\t'������".split(String.valueOf('\t'));
//        String[] tsv1 = "�����|���".split(String.valueOf('|'));
//
//            try (CSVWriter writer = new CSVWriter(new FileWriter("categories.tsv", true))) {
//                writer.writeNext(tsv);
//                writer.writeNext(tsv1);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            File tsvFile = new File("categories.tsv");
//            PrintWriter tsv = new PrintWriter(tsvFile);
//            tsv.print("�����" + '\t' + "e��");
//            tsv.println("�������" + '\t' + "e��");
//            tsv.println("��������" + '\t' + "e��");
//            tsv.println("������" + '\t' + "e��");
//            tsv.println("�����" + '\t' + "������");
//            tsv.println("�����" + '\t' + "������");
//            tsv.println("����" + '\t' + "���");
//            tsv.println("�����" + '\t' + "�������");

            while (true) { // � �����(!) ��������� �����������
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
                    while ((nextLine = reader.readNext()) != null) {
                        String title = nextLine[0];
                        String sum = nextLine[1];
                        if (title.equals(category.getTitle())) {
                            maxCategory.People(sum, category.getSum());
                            maxCategory.PeopleYear(sum, 2022, category.getSum());
                            maxCategory.PeopleMount(sum, 11, category.getSum());
                            maxCategory.PeopleDays(sum, 9, category.getSum());

//                            System.out.println(title +" " + sum);
                            break;
                        } else {
                            //TODO ��������� ������
                        }

                    }

                }
            }
        } catch (IOException e) {
            System.out.println("�� ���� ���������� ������");
            e.printStackTrace();
        }
    }

}

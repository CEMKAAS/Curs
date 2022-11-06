import au.com.bytecode.opencsv.CSVWriter;
import com.google.gson.Gson;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(8080);) {
String[] tsv = "булка'\t'еда'\t'колбаса'\t'еда'\t'сухарики'\t'еда'\t'курица'\t'еда'\t'тапки'\t'одежда'\t'шапка'\t'одежда'\t'мыло'\t'быт'\t'акции'\t'финасы".split(String.valueOf('\t'));
        String[] tsv1 = "булка|еда".split(String.valueOf('|'));

            try (CSVWriter writer = new CSVWriter(new FileWriter("categories.tsv", true))) {
                writer.writeNext(tsv);
                writer.writeNext(tsv1);
            } catch (IOException e) {
                e.printStackTrace();
            }
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
                    out.println("Start Server");
                    String serverResponseTwo = in.readLine();
                    Gson gson = new Gson();
                    Category category = gson.fromJson(serverResponseTwo, Category.class);

                    System.out.println(category.toString());

                }
            }
        } catch (IOException e) {
            System.out.println("Не могу стартовать сервер");
            e.printStackTrace();
        }
    }

}

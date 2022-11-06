import au.com.bytecode.opencsv.CSVWriter;
import com.google.gson.Gson;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(8080);) {
String[] tsv = "�����'\t'���'\t'�������'\t'���'\t'��������'\t'���'\t'������'\t'���'\t'�����'\t'������'\t'�����'\t'������'\t'����'\t'���'\t'�����'\t'������".split(String.valueOf('\t'));
        String[] tsv1 = "�����|���".split(String.valueOf('|'));

            try (CSVWriter writer = new CSVWriter(new FileWriter("categories.tsv", true))) {
                writer.writeNext(tsv);
                writer.writeNext(tsv1);
            } catch (IOException e) {
                e.printStackTrace();
            }
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

                    System.out.println(category.toString());

                }
            }
        } catch (IOException e) {
            System.out.println("�� ���� ���������� ������");
            e.printStackTrace();
        }
    }

}

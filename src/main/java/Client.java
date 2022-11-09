import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Calendar;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (
                Socket socket = new Socket("localhost", 8080);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {
            String serverResponse = in.readLine();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Start введите покупку и сумму");
            System.out.println(serverResponse);
            String json1 = scanner.nextLine();
            String[] parts = json1.split(" ");
            String title = parts[0];
            String data = parts[1];
            Integer sum = Integer.valueOf(parts[2]);
//            Calendar calendar = Calendar.getInstance();
//            String data = calendar.get(Calendar.YEAR) + "." + (calendar.get(Calendar.MONTH) + 1) + "." + calendar.get(Calendar.DAY_OF_MONTH);

            Gson gson = new Gson();
            Category category = new Category(title, data, sum);
            out.println(gson.toJson(category));

        } catch (
                IOException e) {
            System.out.println("Не могу стартовать сервер");
            e.printStackTrace();
        }
    }
}
//булка 09.11.2022 200
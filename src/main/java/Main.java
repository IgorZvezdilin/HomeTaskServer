import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Main {

    public static final String FILE_NAME = "D:\\IdeaProjects\\HomeTaskServer\\"; //Вне зависимоти от пути вылетает "Отказано в доступе"

    public static void main(String[] args) {
        System.out.println("Устанавливаю соединение...");
        createServer();
    }

    private static void createServer() {
        try (ServerSocket serverSocket = new ServerSocket(1999)) {
            while (true) {
                Socket socket = serverSocket.accept();
                Request request = HttpUtils.readRequestFromInputStream(socket.getInputStream());
                String resource = request.getResource();
                try (FileInputStream fileInputStream = new FileInputStream(FILE_NAME + resource)) {
                    byte[] responseContent = new byte[fileInputStream.available()];
                    fileInputStream.read(responseContent, 0, responseContent.length);
                    ByteArrayOutputStream responseContentString = new ByteArrayOutputStream();
                    responseContentString.write(responseContent);
                    Response response = new Response(200, "OK", responseContent.length);
                    String responseInString = response.setHeaders() + responseContentString.toString();
                    System.out.println(responseInString); //для проверки, посмотреть, что выводится
                    System.out.println(FILE_NAME + resource); //
                    socket.getOutputStream().write(responseInString.getBytes());


                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}




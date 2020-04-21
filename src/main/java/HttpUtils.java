

import java.io.InputStream;

import java.util.Scanner;

public class HttpUtils {

    public static Request readRequestFromInputStream(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        StringBuilder requestStory = new StringBuilder();
        while (scanner.hasNext()) {
            requestStory.append(scanner.next());
            requestStory.append(" ");

        }
        return new Request(requestStory.toString());
    }
}

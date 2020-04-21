import java.util.Date;

public class Response {
    public final String HEADERS = "HTTP/1.1 %d %s\n" +
            "Date: %s\n" +
            "Server: Apache/2.2.14 (win32)\n" +
            "Last-Modified: Mon, 20 Apr 15:44:25 MSK\n" +
            "Content-Length: %d\n" +
            "Content-Type: text/html\n" +
            "Connection: Closed" +
            "\r\n\r\n";
    int connectStatus;
    String commentConnectStatus;
    int connectLength;

    public Response(int connectStatus, String commentConnectStatus, int connectLength) {
        this.connectStatus = connectStatus;
        this.commentConnectStatus = commentConnectStatus;
        this.connectLength = connectLength;
    }

    public String setHeaders() {
        Date date = new Date();
        return String.format(HEADERS, connectStatus, commentConnectStatus, date.toString(), connectLength);
    }

}



public class Request {
    String requestData;

    public Request(String requestData) {
        this.requestData = requestData;
    }

    public String getResource() {
        if (!requestData.equals("")) {
            return requestData.substring(requestData.indexOf("/") + 1, requestData.indexOf("H") - 1);
        }


        return "";
    }
}

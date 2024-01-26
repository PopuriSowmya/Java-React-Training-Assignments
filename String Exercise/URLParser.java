package some;

import java.util.HashMap;
import java.util.Map;

public class URLParser {
    private String url;

    public URLParser(String url) {
        this.url = url;
    }

    public String getProtocol() {
        int endIndex = url.indexOf(':');
        if (endIndex != -1) {
            return url.substring(0, endIndex);
        }
        return null;
    }

    public String getHost() {
        int startIndex = url.indexOf("://");
        if (startIndex != -1) {
            int endIndex = url.indexOf('/', startIndex + 3);
            if (endIndex != -1) {
                return url.substring(startIndex + 3, endIndex);
            }
            return url.substring(startIndex + 3);
        }
        return null;
    }

    public String getPath() {
        int startIndex = url.indexOf("://");
        if (startIndex != -1) {
            int pathStartIndex = url.indexOf('/', startIndex + 3);
            if (pathStartIndex != -1) {
                int pathEndIndex = url.indexOf('?', pathStartIndex);
                if (pathEndIndex == -1) {
                    pathEndIndex = url.indexOf('#', pathStartIndex);
                }
                if (pathEndIndex != -1) {
                    return url.substring(pathStartIndex, pathEndIndex);
                } else {
                    return url.substring(pathStartIndex);
                }
            }
        }
        return null;
    }



    public Map<String, String[]> getQueryParameters() {
        Map<String, String[]> queryParams = new HashMap<>();
        int startIndex = url.indexOf('?');
        if (startIndex != -1) {
            String queryString = url.substring(startIndex + 1);
            String[] params = queryString.split("&");
            for (String param : params) {
                String[] keyValue = param.split("=");
                String key = keyValue[0];
                String value = keyValue.length > 1 ? keyValue[1] : "";
                queryParams.put(key, new String[]{value});
            }
        }
        return queryParams;
    }

    public static void main(String[] args) {
        String url = "https://www.w3schools.com/java/java_ref_string.asp";
        URLParser parser = new URLParser(url);
        System.out.println("Protocol: " + parser.getProtocol());
        System.out.println("Host: " + parser.getHost());
        System.out.println("Path: " + parser.getPath());
        System.out.println("Query Parameters: " + parser.getQueryParameters());
    }
}

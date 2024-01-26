package some;

import java.util.*;
import java.lang.StringBuilder;

public class URLBuilder {
    private String protocol;
    private String host;
    private String path;
    private Map<String, String[]> queryParams;

    public URLBuilder() {
        this.queryParams = new HashMap<>();
    }

    public URLBuilder setProtocol(String protocol) {
        this.protocol = protocol;
        return this;
    }

    public URLBuilder setHost(String host) {
        this.host = host;
        return this;
    }

    public URLBuilder setPath(String path) {
        this.path = path;
        return this;
    }

    public URLBuilder addQueryParam(String key, String value) {
        if (!queryParams.containsKey(key)) {
            queryParams.put(key, new String[]{value});
        } else {
            String[] existingValues = queryParams.get(key);
            String[] newValues = Arrays.copyOf(existingValues, existingValues.length + 1);
            newValues[newValues.length - 1] = value;
            queryParams.put(key, newValues);
        }
        return this;
    }

    public String build() {
        StringBuilder urlBuilder = new StringBuilder();
        if (protocol != null) {
            urlBuilder.append(protocol).append("://");
        }
        if (host != null) {
            urlBuilder.append(host);
        }
        if (path != null) {
            urlBuilder.append(path);
        }
        if (!queryParams.isEmpty()) {
            urlBuilder.append("?");
            for (Map.Entry<String, String[]> entry : queryParams.entrySet()) {
                String key = entry.getKey();
                String[] values = entry.getValue();
                for (String value : values) {
                    urlBuilder.append(key).append("=").append(value).append("&");
                }
            }
            urlBuilder.setLength(urlBuilder.length() - 1);
        }
        return urlBuilder.toString();
    }

    public static void main(String[] args) {
        URLBuilder builder = new URLBuilder()
                .setProtocol("https")
                .setHost("www.w3schools.com")
                .setPath("/java/java_ref_string.asp");

        String constructedUrl = builder.build();
        System.out.println("Constructed URL: " + constructedUrl);
    }
}

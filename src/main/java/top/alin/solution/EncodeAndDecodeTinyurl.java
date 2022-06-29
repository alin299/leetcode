package top.alin.solution;

import java.util.HashMap;
import java.util.Map;

public class EncodeAndDecodeTinyurl {
    Map<String, String> map = new HashMap<>();
    int idx;
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String shortUrl = String.valueOf(idx++);
        map.put(shortUrl, longUrl);
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}

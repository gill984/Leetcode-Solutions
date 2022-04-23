public class Codec {
    Map<String, String> map = new HashMap<>();
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String res = genShortUrl(longUrl);
        map.put(res, longUrl);
        return res;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
    
    private String genShortUrl(String longUrl) {
        return "http://tinyurl.com/" + longUrl.hashCode();
    }
}
package utils;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Map;

/**
 * Created by luokai on 2017/8/1.
 */
public class JsoupUtils {
    private static final String USERAGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36";

    public static Document getDocument(String url, Map<String, String> map) {
        Document document = null;
        try {
            Connection connection = Jsoup.connect(url);
            connection.userAgent(USERAGENT);
            if (map != null) {
                connection.data(map);
            }
            connection.get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }

    public static Document getDocument(String url) {
        Document document = null;
        try {
            Connection connection = Jsoup.connect(url);
            connection.userAgent(USERAGENT);
            document = connection.get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }
}

package test1;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Created by luokai on 2017/7/29.
 *
 * jsoup 获取网站 baidu.com
 */
public class Test1 {
    public static void main(String[] args) {
        try {
            String url = "http://www.baidu.com";
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36")
                    .get();
            System.out.println(document);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

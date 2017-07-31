package test1;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * Created by luokai on 2017/7/29.
 * <p>
 * jsonp 获取网站
 *
 */
public class Test3 {
    public static void main(String[] args) {
        try {
            String url = "https://www.oschina.net/action/ajax/get_more_news_list?newsType=industry&p=2";
            Document document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36")
                    .get();
            //css选择器 .表示类 #表示id
            Elements elements = document.select(".news-list-item>div");
            System.out.println(document);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

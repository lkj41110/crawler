package test1;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by luokai on 2017/7/29.
 * <p>
 * jsoup 获取网站 开源中国
 * 翻页内容
 */
public class Test2 {
    public static void main(String[] args) {
        try {
            int size = 0;
            for (int page = 1; ; page++) {
                String url = "https://www.oschina.net/action/ajax/get_more_news_list?newsType=&p=" + page;
                Document document = Jsoup.connect(url)
                        .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36")
                        .get();
                //css选择器 .表示类 #表示id
                Elements elements = document.select("[class=item box]");
                if (elements.size() <= 0) {
                    System.out.println("******结束******");
                    break;
                }
                parseDocument(elements);
                size += elements.size();
                System.out.println("第" + page + "页有" + elements.size() + "条，一共" + size + "条");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void parseDocument(Elements elements) {
        for (Element element : elements) {
            //处理链接
            Elements mainInfoElements = element.select(".title");
            String link = mainInfoElements.attr("href").trim();
            System.out.println("链接：" + parseUrl(link));
            //TODO 处理一些绝对路径

            //处理标题
            Elements titleElements = element.select(".text-ellipsis");
            String title = titleElements.text();
            System.out.println("标题：" + title);

            //主页的内容 用了另一种class的筛选
            Elements contentElements = element.select("[class=sc sc-text text-gradient wrap summary]");
            String content = contentElements.text();
            System.out.println("摘要:" + content);

            //作者相关的东西，正则解析作者相关信息
            Elements authorElements = element.select("[class=mr]");
            System.out.println("作者资料：" + authorElements.select("a").attr("href"));
            String str = authorElements.text();
            String pattern = "(\\D*)\\s+发布于\\s+([0-9]{4}-[0-9]{1,2}-[0-9]{1,2})\\s+(.*)";
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(str);
            if (m.find()) {
                System.out.println("作者: " + m.group(1));
                System.out.println("日期: " + m.group(2));
                System.out.println("评论: " + m.group(3));
            } else {
                System.out.println("不符合格式");
            }

            System.out.println();
        }
    }

    private static String parseUrl(String url) {
        if (!url.startsWith("https://")) {
            System.out.println(url);
            return "https://www.oschina.net/" + url;
        }
        return url;
    }
}

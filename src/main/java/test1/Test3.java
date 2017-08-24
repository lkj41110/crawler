package test1;

import org.jsoup.nodes.Document;
import utils.JsoupUtils;

/**
 * Created by luokai on 2017/7/29.
 * <p>
 * jsonp 获取网站 微博
 *
 */
public class Test3 {
    public static void main(String[] args) {
        /**
         *
         */
        try {
            String url = "https://www.zhihu.com";
            Document document = JsoupUtils.getDocument(url);
            System.out.println(document);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

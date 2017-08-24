package test1;

import org.jsoup.nodes.Document;
import utils.HttpUtils;
import utils.JsoupUtils;

/**
 * Created by luokai on 2017/8/5.
 * 通过抓取ip代理网站来获取ip代理
 */
public class IpTest {
    public static void main(String[] args) {
        test2();
    }

    private static void test1() {
        String url="http://1212.ip138.com/ic.asp";
        while(true) {
            try {
                HttpUtils.setProxyIp();
                Document document = JsoupUtils.getDocument(url);
                String center = document.select("center").toString();
                System.out.println(center);
            }catch (Exception e){

            }

        }
    }
    private static void test2(){
        System.setProperty("http.maxRedirects", "50");
        System.getProperties().setProperty("proxySet", "true");
        // 如果不设置，只要代理IP和代理端口正确,此项不设置也可以
        String ip = "183.222.102.102";
        System.getProperties().setProperty("http.proxyHost", ip);
        System.getProperties().setProperty("http.proxyPort", "80");

        //确定代理是否设置成功
        String url="http://1212.ip138.com/ic.asp";
        Document document = JsoupUtils.getDocument(url);
        String center = document.select("center").toString();
        System.out.println(center);
    }

}

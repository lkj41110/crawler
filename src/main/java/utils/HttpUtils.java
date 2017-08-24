package utils;


import domain.IP;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * 给出一种代理ip解决方案
 *
 * 动态代理网站：
 */
public class HttpUtils {
    private static List<IP> ips;
//    /**
//     * 设置代理ip
//     *
//     * @throws IOException
//     */
//    public static void setProxyIp() {
//        try {
//            List<String> ipList = new ArrayList<String>();
//            BufferedReader proxyIpReader = new BufferedReader(new InputStreamReader(HttpUtils.class.getResourceAsStream("/proxyip.txt")));
//
//            String ip = "";
//            while ((ip = proxyIpReader.readLine()) != null) {
//                ipList.add(ip);
//            }
//
//            Random random = new Random();
//            int randomInt = random.nextInt(ipList.size());
//            String ipport = ipList.get(randomInt);
//            String proxyIp = ipport.substring(0, ipport.lastIndexOf(":"));
//            String proxyPort = ipport.substring(ipport.lastIndexOf(":") + 1, ipport.length());
//
//            System.setProperty("http.maxRedirects", "50");
//            System.getProperties().setProperty("proxySet", "true");
//            System.getProperties().setProperty("http.proxyHost", proxyIp);
//            System.getProperties().setProperty("http.proxyPort", proxyPort);
//
//            System.out.println("设置代理ip为：" + proxyIp + "端口号为：" + proxyPort);
//        } catch (Exception e) {
//            System.out.println("重新设置代理ip");
//            setProxyIp();
//        }
//    }

    public static void setProxyIp() {
        if (ips == null || ips.isEmpty()) {
            ips = getIPList2();
        }
        Random random = new Random();
        int randomInt = random.nextInt(ips.size());
        String proxyIp = ips.get(randomInt).getIp();
        int proxyPort = ips.get(randomInt).getPort();

        System.out.println("IP:" + proxyIp + "  Port:" + proxyPort);
        System.setProperty("http.maxRedirects", "50");
        System.getProperties().setProperty("proxySet", "true");
        System.getProperties().setProperty("http.proxyHost", proxyIp);
        System.getProperties().setProperty("http.proxyPort", proxyPort + "");

    }


    /**
     * 抓取动态Ip
     *
     * @return
     */
    public static List<IP> getIPList1() {
        Document document = JsoupUtils.getDocument("http://www.kuaidaili.com/free/intr/");
        Elements elements = document.select("tr");
        List<IP> ips = new ArrayList<IP>();
        for (Element ele : elements) {
            System.out.println(ele);
            IP ip = new IP();
            ip.setIp(ele.select("td[data-title=IP]").text());
//            Integer.parseInt(ele.select("td[data-title=PORT]").text());
            System.out.println(ele.select("td[data-title=PORT]").text());
            if (!ele.select("td[data-title=PORT]").text().equals("")) {
                ip.setPort(Integer.parseInt(ele.select("td[data-title=PORT]").text()));
            }
            ips.add(ip);
        }
        System.out.println(ips);
        return ips;
    }

    /**
     * 抓取动态Ip
     *
     * @return
     */
    public static List<IP> getIPList2() {
        Document document = JsoupUtils.getDocument("http://www.xicidaili.com/nn");
        Elements elements = document.select("tr");

        System.out.println(elements);
        List<IP> ips = new ArrayList<IP>();
        for (Element element : elements) {
            Elements es= element.select("td");
            for(Element e:es){
                String ip;
            }
//            ips.add(ip);
        }
        System.out.println(ips);
        return ips;
    }
}

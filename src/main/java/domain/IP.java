package domain;

/**
 * Created by luokai on 2017/8/6.
 */
public class IP {
    private String ip;
    private int port;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "IP{" +
                "ip='" + ip + '\'' +
                ", port=" + port +
                '}';
    }
}

package com.cstcen.core.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * @author Chester
 **/
public class NetUtil {
    public static final String MY_IP = getSiteLocalIp();

    private NetUtil() {
        throw new IllegalStateException("Utility class");
    }

    private static String getSiteLocalIp() {
        Enumeration<NetworkInterface> netList;
        try {
            netList = NetworkInterface.getNetworkInterfaces();

            List<NetworkInterface> downIfList = new ArrayList<>();
            while (netList.hasMoreElements()) {
                NetworkInterface netif = netList.nextElement();
                if (netif.isLoopback() || netif.isPointToPoint()
                        || netif.isVirtual()) {
                    continue;
                }

                if (netif.isUp()) {
                    String ip = findSiteLocalAddress(netif.getInetAddresses());
                    if (ip != null) {
                        return ip;
                    }
                } else {
                    downIfList.add(netif);
                }
            }

            for (NetworkInterface downIf : downIfList) {
                String ip = findSiteLocalAddress(downIf.getInetAddresses());
                if (ip != null) {
                    return ip;
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
            return "172.0.0.1";
        }
        return "172.0.0.1";
    }

    private static String findSiteLocalAddress(Enumeration<InetAddress> addrList) {
        while (addrList.hasMoreElements()) {
            String ip = addrList.nextElement().getHostAddress();
            if (ip.startsWith("10.")) {
                return ip;
            }
            if (ip.startsWith("172.")) {
                return ip;
            }
            if (ip.startsWith("192.")) {
                return ip;
            }
        }
        return null;
    }

}

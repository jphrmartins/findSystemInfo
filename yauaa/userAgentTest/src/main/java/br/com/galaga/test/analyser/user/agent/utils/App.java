package br.com.galaga.test.analyser.user.agent.utils;

import eu.bitwalker.useragentutils.UserAgent;

public class App {

    public static void main(String[] args) {
        UserAgent userAgent = UserAgent.parseUserAgentString("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36");
        System.out.println(userAgent.getBrowser().getGroup().getName());
        System.out.println(userAgent.getBrowser().getRenderingEngine().getName());
        System.out.println(userAgent.getBrowserVersion().getMinorVersion());
        System.out.println(userAgent.getOperatingSystem().getManufacturer().getName());
        System.out.println(userAgent.getOperatingSystem().getDeviceType().getName());
        System.out.println(userAgent.getOperatingSystem().getName());
    }
}

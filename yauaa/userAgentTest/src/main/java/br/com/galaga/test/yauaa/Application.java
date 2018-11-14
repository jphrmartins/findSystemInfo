package br.com.galaga.test.yauaa;

import nl.basjes.parse.useragent.UserAgent;
import nl.basjes.parse.useragent.UserAgentAnalyzer;

public class Application {
    public static void main(String[] args) {
        long init = System.currentTimeMillis();
        UserAgentAnalyzer userAgentAnalyzer = UserAgentAnalyzer
                .newBuilder()
                .withoutCache()
                .build();
        long afterBuilder = System.currentTimeMillis();
        UserAgent userAgent = userAgentAnalyzer.parse("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36");
        for (String field : userAgent.getAvailableFieldNames()){
            System.out.println(field + " : " + userAgent.getValue(field));
        }
        long end = System.currentTimeMillis();
        System.out.println("todo o processo: " + (end - init));
        System.out.println("Após construção: " + (end - afterBuilder));
    }
}

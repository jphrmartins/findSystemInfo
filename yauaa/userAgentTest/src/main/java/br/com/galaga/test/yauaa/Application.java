package br.com.galaga.test.yauaa;

import nl.basjes.parse.useragent.UserAgent;
import nl.basjes.parse.useragent.UserAgentAnalyzer;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long init = System.currentTimeMillis();
        UserAgentAnalyzer userAgentAnalyzer = UserAgentAnalyzer
                .newBuilder()
                .withoutCache()
                .withAllFields()
                .build();
        long afterBuilder = System.currentTimeMillis();
        UserAgent userAgent = userAgentAnalyzer.parse("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36");
        for (String field : userAgent.getAvailableFieldNames()){
            System.out.println(field + " : " + userAgent.getValue(field));
        }
        long end = System.currentTimeMillis();
        System.out.println("todo o processo: " + (end - init));
        System.out.println("Após construção: " + (end - afterBuilder));
        System.out.println("+1 Busca?");
        boolean var = true;
        String sc = scanner.next();
        while (var){
            if (sc.equals("n")){
                var = false;
                break;
            } else {
                afterBuilder = System.currentTimeMillis();
                userAgent = userAgentAnalyzer.parse("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36");
                for (String field : userAgent.getAvailableFieldNames()){
                    System.out.println(field + " : " + userAgent.getValue(field));
                }
                end = System.currentTimeMillis();
                System.out.println("Após construção: " + (end - afterBuilder));
                System.out.println("+1 Busca?");
                sc = scanner.next();
            }

        }

    }
}

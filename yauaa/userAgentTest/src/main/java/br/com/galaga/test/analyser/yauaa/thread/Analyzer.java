package br.com.galaga.test.analyser.yauaa.thread;

import nl.basjes.parse.useragent.UserAgent;
import nl.basjes.parse.useragent.UserAgentAnalyzer;

import java.util.HashMap;
import java.util.Map;

public class Analyzer {
    private UserAgentAnalyzer userAgentAnalyzer;

    public Analyzer(UserAgentAnalyzer userAgentAnalyzer) {
        this.userAgentAnalyzer = userAgentAnalyzer;
    }

    public Map<String, String> consult(String name) {
        UserAgent userAgent = userAgentAnalyzer.parse("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.102 Safari/537.36");
        Map<String, String> map = new HashMap<>();
        userAgent.getAvailableFieldNames().forEach(it ->
                map.put(it, userAgent.getValue(it))
        );
        return map;
    }
}

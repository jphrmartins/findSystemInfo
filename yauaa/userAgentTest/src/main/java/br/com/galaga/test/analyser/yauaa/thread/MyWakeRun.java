package br.com.galaga.test.analyser.yauaa.thread;

import java.util.Map;

public class MyWakeRun extends Thread {
    private Analyzer userAgentAnalyzer;
    private String name;

    public MyWakeRun(Analyzer userAgentAnalyzer, String name) {
        this.userAgentAnalyzer = userAgentAnalyzer;
        this.name = name;
    }

    public void run() {
        System.out.println("Starting thread " + name);
        long init = System.currentTimeMillis();
        Map<String, String> values = userAgentAnalyzer.consult(name);
        for (Map.Entry<String, String> value : values.entrySet()){
            System.out.println(name + " -> " + value.getKey() + " : " + value.getValue());
        }
        long end = System.currentTimeMillis();
        System.out.println("EXECUTION TIME = " + (end - init));
    }
}

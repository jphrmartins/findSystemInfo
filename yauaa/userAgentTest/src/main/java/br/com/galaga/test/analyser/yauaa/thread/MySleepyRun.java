package br.com.galaga.test.analyser.yauaa.thread;

import java.util.Map;

public class MySleepyRun extends Thread {
    private Analyzer userAgentAnalyzer;
    private String name;
    private long timer;

    public MySleepyRun(Analyzer userAgentAnalyzer, String name, long timer) {
        this.userAgentAnalyzer = userAgentAnalyzer;
        this.name = name;
        this.timer = timer;
    }

    @Override
    public void run() {
        try {
            System.out.println("Starting thread " + name);
            Thread.sleep(timer);
            long init = System.currentTimeMillis();
            Map<String, String> values = userAgentAnalyzer.consult(name);
            for (Map.Entry<String, String> value : values.entrySet()) {
                System.out.println(name + " -> " + value.getKey() + " : " + value.getValue());
            }
            long end = System.currentTimeMillis();
            System.out.println("Execution time = " + (end - init));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

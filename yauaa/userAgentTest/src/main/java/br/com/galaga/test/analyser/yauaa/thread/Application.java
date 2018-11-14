package br.com.galaga.test.analyser.yauaa.thread;

import br.com.galaga.test.analyser.yauaa.thread.Analyzer;
import br.com.galaga.test.analyser.yauaa.thread.MySleepyRun;
import br.com.galaga.test.analyser.yauaa.thread.MyWakeRun;
import nl.basjes.parse.useragent.UserAgentAnalyzer;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        long init = System.currentTimeMillis();
        UserAgentAnalyzer userAgentAnalyzer = UserAgentAnalyzer
                .newBuilder()
                .withCache(100)
                .withAllFields()
                .build();
        long end = System.currentTimeMillis();
        System.out.println("Builder time = " + (end - init));
        Analyzer analyzer = new Analyzer(userAgentAnalyzer);
        new MyWakeRun(analyzer, "STARTER_THREAD").run();
        List<Thread> threads = Arrays.asList(
                new MyWakeRun(analyzer, "1 Wake"),
                new MyWakeRun(analyzer, "2 Wake"),
                new MySleepyRun(analyzer, "3 Sleep", 3000),
                new MyWakeRun(analyzer, "4 Wake"),
                new MySleepyRun(analyzer, "5 Sleep", 100),
                new MySleepyRun(analyzer, "6 Sleep", 6500),
                new MyWakeRun(analyzer, "7 Wake"),
                new MyWakeRun(analyzer, "8 Wake")
        );

        threads.forEach(Thread::start);
        new MyWakeRun(analyzer, "Intercepter").run();
    }
}

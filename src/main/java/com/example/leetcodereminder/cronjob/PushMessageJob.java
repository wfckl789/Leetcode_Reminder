package com.example.leetcodereminder.cronjob;

import com.alibaba.fastjson.JSONObject;
import com.example.leetcodereminder.model.LCProblem;
import com.example.leetcodereminder.service.LeetcodePusher;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Component
public class PushMessageJob {

    static List<String> xinOpenIds = new ArrayList<>(Arrays.asList("oS40l6XW0iEnZpZzoqvCSzDnhN3c", "oS40l6Qq8r55t2OCPXpS2-X4MNto"));
    //推送模版id
    static String xinTemplateId = "A-RT1xEwJMkd8JfxHwxQqIrM-AbSdtVvOkF-vlpcXWI";

    static List<String> jieOpenIds = new ArrayList<>(Arrays.asList("oS40l6XW0iEnZpZzoqvCSzDnhN3c", "oS40l6eYcan4NQaCi5cv7k6o1STU"));
    static String jieTemplateId = "wywsWyyNXBV7iYPDrR08QyCUgxL87d98wL9ZKDahjMA";

    static List<String> tingOpenIds = new ArrayList<>(Arrays.asList("oS40l6XW0iEnZpZzoqvCSzDnhN3c"
            , "oS40l6SbOx2G0jHv_OHeRtFXCI1E"
    ));
    static String tingTemplateId = "hcULDXTBrDYNWyVGSB32igYiHQkSbBZJ8XDdggTm0v8";


    private static final int MAX_THREADS = 3;

    private static final Executor exec = Executors.newFixedThreadPool(MAX_THREADS);

//    @Scheduled(cron = "0 0 19 * * ?")
    public void reminderToXin() {
        LCProblem lc = new LCProblem("partition-equal-subset-sum", "Medium");
        for (int i = 0; i < xinOpenIds.size(); i++) {
            String id = xinOpenIds.get(i);
            Runnable task = new Runnable() {
                @Override
                public void run() { LeetcodePusher.push(id, xinTemplateId, lc); }
            };
            exec.execute(task);
        }
    }

//    @Scheduled(cron = "0 30 10,15,20 * * ?")
    public void reminderToJie() {
        LCProblem lc = new LCProblem("majority-element", "Easy");
        for (int i = 0; i < jieOpenIds.size(); i++) {
            String id = jieOpenIds.get(i);
            Runnable task = new Runnable() {
                @Override
                public void run() { LeetcodePusher.push(id, jieTemplateId, lc); }
            };
            exec.execute(task);
        }
    }

//    @Scheduled(cron = "0 0 19 * * ?")
    public void reminderToTing() {
        LCProblem lc = new LCProblem("flood-fill", "Easy");
        for (int i = 0; i < tingOpenIds.size(); i++) {
            String id = tingOpenIds.get(i);
            Runnable task = new Runnable() {
                @Override
                public void run() { LeetcodePusher.push(id, tingTemplateId, lc); }
            };
            exec.execute(task);
        }
    }

    @Scheduled(cron = "0 */15 * * * ?")
    public void renderServerTrigger1() throws IOException {
        HttpClient client = HttpClients.createDefault();
        // 要调用的接口方法
        String url = "https://kanbas-node-server-app-a4m7.onrender.com/a5/welcome";
        HttpGet trigger = new HttpGet(url);
        trigger.addHeader("content-type", "text/html");
        HttpResponse res = client.execute(trigger);
        String response1 = EntityUtils.toString(res.getEntity());
        System.out.println(response1);
    }

    @Scheduled(cron = "0 */15 * * * ?")
    public void renderServerTrigger2() throws IOException {
        HttpClient client = HttpClients.createDefault();
        // 要调用的接口方法
        String url = "https://final-project-node-server-ubcd.onrender.com/project/teams";
        HttpGet trigger = new HttpGet(url);
        trigger.addHeader("content-type", "text/html");
        HttpResponse res = client.execute(trigger);
        String response1 = EntityUtils.toString(res.getEntity());
        System.out.println(response1);
    }
}

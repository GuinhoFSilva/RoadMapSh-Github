package com.guinho.activities.github;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import javax.xml.transform.Source;
import java.util.*;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print(">> GitHub username:");
        String username = scanner.next();
        fetch(username);
    }

    public static void fetch(String username) {
        try {
            System.out.println("Loading data from GitHub, please wait...");
            RestTemplate rest = new RestTemplate();
            InfoUser[] info = rest.getForObject(String.format("https://api.github.com/users/%s/events", username), InfoUser[].class);
            if (info == null || info.length == 0) {
                System.out.println("Usuário não encontrado");
            } else {
                Map<String, Integer> commits = new TreeMap<>();
                Map<String, Integer> events = new TreeMap<>();
                for(InfoUser actualInfo : info){
                    if(actualInfo.getType().equalsIgnoreCase("PushEvent")){
                        commits.put(actualInfo.getRepo().getName(), commits.getOrDefault(actualInfo.getRepo().getName(), 0) + 1);
                    }
                    events.put(actualInfo.getType(), events.getOrDefault(actualInfo.getType(), 0) + 1);
                }
                events.forEach((event, qtd) -> System.out.printf("%s: %s\n", event, qtd));
                commits.forEach((repo, qtd) -> System.out.printf("Pushed %d commits in %s\n", qtd, repo));
            }
        } catch (RestClientException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}

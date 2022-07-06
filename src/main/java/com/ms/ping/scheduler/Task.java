package com.ms.ping.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@Component
@Slf4j
public class Task {


    @Scheduled(fixedRate = 1000)
    public void testSchedule() {
        long time = new Date().getTime();
        String fileName = "D:\\message\\" + time + ".txt";
        try {
            Path path = Paths.get(fileName);
            try (BufferedWriter writer =
                         Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
                writer.write("hello");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

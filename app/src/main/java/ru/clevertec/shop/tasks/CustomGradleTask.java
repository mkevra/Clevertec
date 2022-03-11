package ru.clevertec.shop.tasks;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.OutputFile;
import org.gradle.api.tasks.TaskAction;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class CustomGradleTask extends DefaultTask {
    @Input
    String sourceUrl;

    @OutputFile
    File target;

    @TaskAction
    void downoload() throws IOException {
        try {
            URL url = new URL(sourceUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            try (BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                 FileOutputStream fileOutputStream = new FileOutputStream(target);
                 BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream, 1024)) {


                byte[] buffer = new byte[1024];
                int read = 0;

                while ((read = bufferedInputStream.read(buffer, 0, 1024)) >= 0) {
                    bufferedOutputStream.write(buffer, 0, read);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
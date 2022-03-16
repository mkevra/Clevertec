package ru.clevertec.shop.plugins;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.Task;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public abstract class FileDownoloaderPlugin implements Plugin<Project> {
    String sourceUrl = "https://drive.google.com/file/d/1clwNxdkHsIvYdD7ET5XgqyaQbOwOruzk/view?usp=sharing";
    File target = new File("src/main/resources/check.jpg");

    @Override
    public void apply(Project project) {

        Task downloadFilePlugin = project.task("downloadFilePlugin").doLast(
                task -> {
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
                });
    }
}
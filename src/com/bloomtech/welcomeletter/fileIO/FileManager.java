package com.bloomtech.welcomeletter.fileIO;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileManager {
    public FileManager() {
    }

    public String getTextFromFile(String filename) throws IOException {
        Path path = Path.of("src/resources/" + filename);
        StringBuilder builder = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(path.toUri()), StandardCharsets.UTF_8)) {
            stream.forEach(s -> builder.append(s).append("\n"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public void writeTextToFile(String outFileName, String text) {
        File file = new File("./src/resources/out/" + outFileName);
        try(FileOutputStream fos = new FileOutputStream(file);
                BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            byte[] bytes = text.getBytes();
            bos.write(bytes);
            bos.close();
            fos.close();
            System.out.println("Data written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
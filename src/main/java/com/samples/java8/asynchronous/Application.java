package com.samples.java8.asynchronous;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Alakus on 12/3/2015.
 */
public class Application {

    public static void main(String[] args) {
        /*CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            fetchFromDatabase();
        });
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            readFiles();
        });

        // FORK JOIN
        future1.join();
        future2.join();
        future1.runAfterBoth(future2, () -> System.out.println("Both DONE"));
        future1.runAfterEither(future2, () -> System.out.println("Either DONE")); */


        /*CompletableFuture<Void> allOf = CompletableFuture.allOf(future1, future2);
        System.out.println("All together");
        allOf.join();
        System.out.println("DONE.");*/

        /*CompletableFuture<Object> anyOf = CompletableFuture.anyOf(future1, future2);
        System.out.println("Any of");
        anyOf.join();
        System.out.println("DONE.");*/


        /*CompletableFuture<List<Path>> future = CompletableFuture.supplyAsync(() -> {
            Stream<Path> list = Stream.of();
            try {
                list = Files.list(Paths.get("."));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return list.collect(Collectors.toList());
        });

        List<Path> paths = future.join();
        future.thenAccept((List<Path> pathList) -> {
        });*/


        CompletableFuture.supplyAsync(() -> {
            Stream<Path> list = Stream.of();
            try {
                list = Files.list(Paths.get("."));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return list.collect(Collectors.toList());
        }).handleAsync((paths, throwable) -> {
            Map<Path, Long> pathSizeMap = new HashMap<Path, Long>();
            try {
                for (Path path : paths) {
                    long size = Files.size(path);
                    pathSizeMap.put(path, size);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return pathSizeMap;
        }).thenAccept(map -> {
            for (Map.Entry<Path, Long> entry : map.entrySet()) {
                System.out.printf("%s | %d bytes %n", entry.getKey(), entry.getValue());
            }
        }).join();
    }


    private static List<String> fetchFromDatabase() {
        try {
            System.out.println("fetchFromDatabase starting");
            Thread.sleep(5000);
            System.out.println("fetchFromDatabase done");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static List<byte[]> readFiles() {
        try {
            System.out.println("readFiles starting");
            Thread.sleep(3000);
            System.out.println("readFiles done");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}

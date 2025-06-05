/*
 * GraalVM - Lab 03-02 - Advanced GraalVM JIT vs Regular JIT
 *
 * Goal: Measure Performance of Advanced GraalVM JIT vs Regular JIT
 *
 * Steps:
 * 1) Measure performance on Regular JIT
 * 2) Measure performance on Advanced GraalVM JIT using Community Edition
 * 3) Measure performance on Advanced GraalVM JIT using Enterprise Edition
 *
 * Example measurements:
 *
 * Java 11
 *      Temurin-11.0.14.1+1 build 11.0.14.1+1
 *      Total Time = PT1M34.0939603S
 *
 *      GraalVM CE 22.0.0.2 build 11.0.14+9-jvmci-22.0-b05
 *      Total Time = PT1M36.4823488S
 *
 *      GraalVM EE 22.0.0.2 build 11.0.14+8-LTS-jvmci-22.0-b05
 *      Total Time = PT57.38602S
 *
 * Java 17
 *      Temurin-17.0.2+8 build 17.0.2+8
 *      Total Time = PT1M20.4154036S
 *
 *      GraalVM CE 22.0.0.2 build 17.0.2+8-jvmci-22.0-b05
 *      Total Time = PT1M19.7422666S
 *
 *      GraalVM EE 22.0.0.2 build 17.0.2+8-LTS-jvmci-22.0-b05
 *      Total Time = PT46.1420501S
 *
 */

import java.time.Duration;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {

    private static final int ASCII_STREAM_SIZE = 100;
    private static final int ASCII_LOWER_BOUND = 48;
    private static final int RANDOM_UPPER_BOUND = 123;

    public static void main(String[] args) {
        List<Long> numberOfAlphabeticCharsList = new LinkedList<>();

        Instant startTime = Instant.now();

        for (int i = 0; i < 20000000; i++) {
            String randomString = getRandomString();
            long numberOfAlphabeticChars = calculateNumberOfAlphabeticChars(randomString);

            numberOfAlphabeticCharsList.add(numberOfAlphabeticChars);
        }

        Instant endTime = Instant.now();

        System.out.println("Total Time = " + Duration.between(startTime, endTime));
    }

    private static String getRandomString() {
        return new Random().ints(ASCII_STREAM_SIZE, ASCII_LOWER_BOUND, RANDOM_UPPER_BOUND)
                .mapToObj(ch -> String.valueOf((char) ch))
                .collect(Collectors.joining());
    }

    private static long calculateNumberOfAlphabeticChars(String randomString) {
        return randomString.chars()
                .filter(Character::isAlphabetic)
                .count();
    }
}

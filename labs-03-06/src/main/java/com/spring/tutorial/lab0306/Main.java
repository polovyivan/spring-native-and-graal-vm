/*
 * GraalVM - Lab 03-06 - Runtime vs Build-Time Initialization Lab
 *
 * Goal: Use Build-Time Initialization to optimize application startup time
 *
 * Steps:
 * 1) Build module with "mvn clean install"
 * 2) Execute module using "java -jar target/labs-03-06.jar"
 * 3) Observe how long computation during startup affects startup time
 * 4) Build module with "mvn clean install -Pnative"
 * 5) Execute module using "labs-03-06" native executable located under "target" folder
 * 6) Observe default native image behavior of initialize at run time for application code
 * 7) Build module with "mvn clean install -Pnative-initialize-at-build-time"
 * 8) While module builds, observe that static initializer is executed during built time
 * 9) Execute module using "labs-03-06" native executable located under "target" folder
 * 10) Observe how initialize at build time optimizes startup performance
 *
 * Resources:
 * https://www.graalvm.org/22.0/reference-manual/native-image/ClassInitialization/
 *
 */

package com.spring.tutorial.lab0306;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        main.printResults();
    }

    private static int precomputedValue;

    static {
        precomputedValue = calculatePrecomputedValue();
    }

    private static int calculatePrecomputedValue() {
        System.out.println("Static initializer => running long calculation...");

        try {
            TimeUnit.SECONDS.sleep(5);  // simulate long computation
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }

        System.out.println("Static initializer => finished long calculation.");

        return 0x7f1a;
    }

    private void printResults() {
        System.out.println("Precomputed value = " + precomputedValue);
    }
}

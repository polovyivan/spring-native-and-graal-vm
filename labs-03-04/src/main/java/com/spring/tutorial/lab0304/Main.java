/*
 * GraalVM - Lab 03-04 - Native-Image Maven Plugin
 *
 * Goal: Use Native Image Maven Plugin to create native executable
 *
 * Steps:
 * 1) Analyze pom.xml and native-maven-plugin setup
 * 2) Execute mvn clean install -Pnative
 * 3) Execute native executable located in target folder
 *
 * Resources:
 * https://graalvm.github.io/native-build-tools/latest/maven-plugin.html
 *
 */

package com.spring.tutorial.lab0304;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        int r = main.getRandomFactor();
        int z = main.performCalculations(r);
        main.printResults(z);
    }

    private int getRandomFactor() {
        return (int) (Math.random() * 10);
    }

    private int performCalculations(int r) {
        int x;
        int y;
        int z;

        x = 0x7f1a * r;
        y = 0x7f1b * r;

        z = x + y;

        return z;
    }

    private void printResults(int z) {
        System.out.println("x + y = " + z);
    }
}

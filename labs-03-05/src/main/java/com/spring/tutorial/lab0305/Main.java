/*
 * GraalVM - Lab 03-05 - Native Image Build Configuration Options
 *
 * Goal: Use "native-image.properties" to configure native-image build process
 *
 * Steps:
 * 1) Use "mvn clean install" to build module
 * 2) Use "native-image --verbose -jar target/labs-03-05.jar" to build native image from jar
 * 3) Notice native image created with custom name, using custom options
 * 4) Analyze pom.xml setup, notice that non-default plugin configuration was required to process "native-image.properties"
 * 5) Execute "mvn clean install -Pnative"
 * 6) Notice native image created using custom options
 *
 * Note:
 * Since "native-maven-plugin" had to be configured in a non-default way for "native-image.properties" to be processed,
 * I do not recommend using "native-maven-plugin" this way. My recommendation is to perform required native image configuration
 * using plugin configuration section in pom.xml.
 *
 * Resources:
 * https://graalvm.github.io/native-build-tools/latest/maven-plugin.html
 *
 */

package com.spring.tutorial.lab0305;

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

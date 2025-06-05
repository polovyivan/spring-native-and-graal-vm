/*
 * GraalVM - Lab 03-07 - Tracing Agent
 *
 * Goal: Use Tracing Agent to correctly handle resources loading
 *
 * Steps:
 * 1) Build module using "mvn clean install"
 * 2) Execute module using command "java -jar target/labs-03-07.jar"
 * 3) Notice that "db.properties" are read correctly
 * 4) Build module using "mvn clean install -Pnative"
 * 5) Execute produced native executable file
 * 6) Notice "NullPointerException: inStream parameter is null" being thrown
 * 7) Execute tracing agent to generate config json files for dynamic features
 *    java -agentlib:native-image-agent=config-output-dir=src/main/resources/META-INF/native-image -jar target/labs-03-07.jar
 * 8) Notice "META-INF/native-image" being produced with config files
 * 9) Rebuild native image using "mvn clean install -Pnative"
 * 10) Execute produced native executable file
 * 11) Notice that now "db.properties" are read correctly
 *
 * Resources:
 * https://www.graalvm.org/22.0/reference-manual/native-image/Agent/
 *
 */

package com.spring.tutorial.lab0307;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().execute();
    }

    private void execute() throws IOException {
        Properties dbProperties = getDbProperties();

        dbProperties.list(System.out);
    }

    private Properties getDbProperties() throws IOException {
        Properties dbProperties = new Properties();

        try (InputStream resourceAsStream = Main.class.getResourceAsStream("/db.properties")) {
            dbProperties.load(resourceAsStream);
        }

        return dbProperties;
    }
}

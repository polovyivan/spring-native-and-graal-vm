/*
 * GraalVM - Lab 03-01 - HostSpot VM
 *
 * Goal: Compile Java Code to Bytecode, use javap to observe bytecode
 *
 * Steps:
 * 1) Compile java code using javac
 * 2) Use javap to decompile .class file into bytecode
 * 3) Compare bytecode with Java Virtual Machine Specification
 *
 * Resources:
 * Java Virtual Machine Specification - https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-2.html#jvms-2.11
 *
 */

public class Main {
    public static void main(String[] args) {
        int x;
        int y;
        int z;

        x = 59;
        y = 61;

        z = x + y;
    }
}

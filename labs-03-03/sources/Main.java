/*
 * GraalVM - Lab 03-04 - Native Image Compiler
 *
 * Goal: Use Native Image Compiler to create native executable and compare bytecode with native code
 *
 * Steps:
 * 1) Use javac to compile java code to bytecode - javac Main.java
 * 2) Use javap to disassembly compiled bytecode - javap -c -p Main
 * 3) Use native-image to compile code to native code - native-image Main
 * 4) Notice native executable was produced, execute it
 * 5) Use native-image to compile code to native code with debugging symbols - native-image -O0 -g Main
 * 6) Use Ghidra to disassembly compiled native code
 * 7) Search for JavaMainWrapper_runCore
 * 8) Search for Main_performCalculations
 * 9) Compare bytecode and native code
 * 10) Notice that bytecode follows Java Virtual Machine Specification while native code follows Native Instruction Set specification
 *
 * Resources:
 * Java Virtual Machine Specification - https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-2.html#jvms-2.11
 * x86 instruction listings - https://en.wikipedia.org/wiki/X86_instruction_listings#Original_8086/8088_instructions
 * Intel® 64 and IA-32 Architectures Software Developer’s Manual Volume 1: Basic Architecture - Chapter 5 Instruction Set Summary - https://www.intel.pl/content/dam/www/public/us/en/documents/manuals/64-ia-32-architectures-software-developer-vol-1-manual.pdf
 *
 */

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

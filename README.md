# Java to Native Image (GraalVM) on Ubuntu

## Commands

```bash
# Compile Java source
javac Main.java

# Inspect bytecode
xxd Main.class

# Compile to native image (with debug info, no optimizations)
native-image -O0 -g Main

# Run native image
./main

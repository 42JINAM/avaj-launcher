
# Makefile

# Java Compiler
JC = javac

# Java Runtime
JAVA = java

# Source file list
SOURCES = $(shell cat sources.txt)

# Class files generated from source files
CLASSFILES = $(patsubst %.java, $(OUTPUT_DIR)/%.class, $(SOURCES))

# Output directory for class files
OUTPUT_DIR = bin

# Default target
all: $(OUTPUT_DIR) $(CLASSFILES)

# Create output directory if it doesn't exist
$(OUTPUT_DIR):
	mkdir -p $(OUTPUT_DIR)

# Rule to compile .java files to .class files in the output directory
$(OUTPUT_DIR)/%.class: %.java
	$(JC) -d $(OUTPUT_DIR) $<

# Rule to run the main class (adjust 'MainClass' to your main class name)
run: all
	$(JAVA) -cp $(OUTPUT_DIR) simulator.Simulator

# Clean up generated class files
clean:
	rm -rf $(OUTPUT_DIR)

.PHONY: all clean run

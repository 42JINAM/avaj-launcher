
FILE_NAME ?= scenario.txt
JC = javac
JAVA = java

# Output directory for class files
OUTPUT_DIR = bin

# Source file list
SOURCES = $(shell cat sources.txt 2>/dev/null)

# Generate sources.txt with all .java files
sources.txt:
	find src -name "*.java" > sources.txt

# Class files generated from source files
CLASSFILES = $(patsubst src/%.java, $(OUTPUT_DIR)/%.class, $(SOURCES))

# Default target
all: $(OUTPUT_DIR) $(CLASSFILES)

# Create output directory if it doesn't exist
$(OUTPUT_DIR):
	mkdir -p $(OUTPUT_DIR)

# Rule to compile .java files to .class files in the output directory
$(OUTPUT_DIR)/%.class: src/%.java
	$(JC) -d $(OUTPUT_DIR) -sourcepath src $<

# Rule to run the main class
run: all
	$(JAVA) -cp $(OUTPUT_DIR) simulator.Simulator $(FILE_NAME)

# Clean up generated class files
clean:
	rm -rf $(OUTPUT_DIR) sources.txt

# Generate sources.txt and then build
re: clean sources.txt all

.PHONY: all clean run sources.txt re

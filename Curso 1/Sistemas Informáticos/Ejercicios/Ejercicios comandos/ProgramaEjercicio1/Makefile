# program source file name here
PROGRAM_NAME_C = maker.c

# program binary output name
OUT_BINARY = run

# compiler flags
C_COMPILER_OPTIONS_DEBUG = -pedantic-errors -g -fsanitize=address -Wextra -Wall

# compile all
all: build

build: $(PROGRAM_NAME_C)
	gcc -o $(OUT_BINARY) $(C_COMPILER_OPTIONS_DEBUG) $(PROGRAM_NAME_C) $(MATH_LIB)

clean:
	rm main


# Makefile para usar en entorno linux con G++
CXX_COMPILER = g++
CXX_STANDARD = -std=c++17
COMPILER_ARGUMENTS = -Wall -Wextra -Wpedantic -fsanitize=address
EXECUTABLE = -o main
INCLUDE_FILES = Hormiga.hh Reina.hh Pila.hh
SOURCES = main.cpp
OPTIMIZATION_LEVEL = -Og

all: main

main: main.cpp Hormiga.hh Reina.hh Pila.hh
	$(CXX_COMPILER) $(CXX_STANDARD) $(COMPILER_ARGUMENTS) $(EXECUTABLE) $(INCLUDE_FILES) $(SOURCES) $(OPTIMIZATION_LEVEL)

clean:
	rm main

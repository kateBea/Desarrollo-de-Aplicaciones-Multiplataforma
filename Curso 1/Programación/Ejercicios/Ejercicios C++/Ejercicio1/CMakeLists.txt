cmake_minimum_required(VERSION 3.18)

# CXX Lang Requirements
set(CMAKE_CXX_STANDARD 20)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

# Project List
project(Ejercicio1)
project(Ejercicio2)
project(Ejercicio3)

# Compiler flags
if (MSVC)
    # Compile commands for Windows
    # Add similar compile options
else()
    # Compile commands for Linux
    add_compile_options(-fsanitize=address -D_DEBUG -Wall -Wextra -Wpedantic -Werror -D_GLIBCXX_DEBUG)

    # Sanitize AddressSanitizer for memory bugs
    add_link_options(-fsanitize=address)
endif()

# Executable List
add_executable(Ejercicio1 Ejercicio1.cpp)
add_executable(Ejercicio2 Ejercicio2.cpp)
add_executable(Ejercicio3 Ejercicio3.cpp)
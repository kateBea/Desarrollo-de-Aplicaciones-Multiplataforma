cmake_minimum_required(VERSION 3.18)

# Project List
project(Algoritmos)

# CXX Lang Requirements
set(CMAKE_CXX_STANDARD 20)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

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
add_executable(Algoritmos main.cpp)
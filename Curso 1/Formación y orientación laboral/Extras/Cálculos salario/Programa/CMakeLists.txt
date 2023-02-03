cmake_minimum_required(VERSION 3.2)

set(MY_PROJECT_NAME "Salario")
set(EXEC_NAME "salario")
set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

project(${MY_PROJECT_NAME})

include_directories(${PROJECT_SOURCE_DIR}/include)
add_executable(${EXEC_NAME} main.cc)

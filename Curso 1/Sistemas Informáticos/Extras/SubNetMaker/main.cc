#include <iostream>
#include <string>
#include <vector>
#include <iterator>

// GLOBALS
static std::string g_ip{};
static std::string g_ip_mask{};

static int g_subredes{};

// Split string by substrings using by delimiter
std::vector<std::string>
split(const std::string& str, const char delimiter) {
    std::vector<std::string> result{};
 
    auto iter{ str.begin() };
    auto first{ str.begin() };

    for ( ; iter != str.end(); ++iter) {
        if (*iter == delimiter) {
            result.push_back(std::string(first, iter));
            first = std::next(iter);
        } // 123.255.234.12
    }
    
    // insertar último bloque
    result.push_back(std::string(first, iter));
    return result;
}

// lee los datos necesarios
void
init() {
    std::cout << "Enter ip: ";
    std::cin >> g_ip;
    
    std::cout << "Enter subredes: ";
    std::cin >> g_subredes;

    std::cout << "\n--------------------------------------\n";
    std::cout << "Dirección ip: " << g_ip << std::endl;
    std::cout << "Subredes a generar: " << g_subredes << std::endl;
}

int 
main(int, char**) {
    init();


    return 0;
}

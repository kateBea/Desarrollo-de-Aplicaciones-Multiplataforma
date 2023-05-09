#ifndef REINA_HH
#define REINA_HH

#include <string>
#include <memory>

#include "Hormiga.hh"

template<typename T>
class Pila {
public:
    Pila() = default;

    void pop() {
        m_Root = m_Root->m_Next;
    }

    const T& peek() {
        return m_Root->m_Info;
    }

    void push(const T& info) {
        auto temp{ std::make_shared<Node>(info, m_Root) };
        m_Root->m_Next = temp;
    }

private:
    struct Node {
        T m_Info{};
        std::shared_ptr<T> m_Next{};

        Node() = default;
        Node(const T& info, shared_ptr<T> next)
            :   m_Info{ info }, m_Next{ next } 
        {} 
    };

    std::shared_ptr<Node> m_Root{};
};


#endif
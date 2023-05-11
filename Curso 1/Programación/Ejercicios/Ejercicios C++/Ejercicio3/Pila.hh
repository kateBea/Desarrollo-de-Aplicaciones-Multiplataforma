#ifndef PILA_HH
#define PILA_HH

#include <stdexcept>
#include <utility>

template<typename T>
class Pila {
public:
    explicit Pila() = default;

    Pila(const Pila& other) {
        m_root = copyNodes(other.m_root);
        m_depth = other.size();
    }

    template<typename... Args>
    Pila(Args... args) {
        auto temp{ new Node(std::forward<Args>(args)...) };

        temp->m_next = m_root;
        m_root = temp;

        ++m_depth;
    }

    auto pop() -> void {
        if (isEmpty())
            throw std::runtime_error("Error en llamada a pop(). La pila está vacía.");

        auto temp{ m_root };
        m_root = m_root->m_next;

        delete temp;
        --m_depth;
    }

    auto peek() const -> const T& {
        return m_root->m_info;
    }

    auto push(const T& info) -> void {
        auto temp{ new Node(info) };

        temp->m_next = m_root;
        m_root = temp;

        ++m_depth;
    }
    
    auto size() const -> int {
        return m_depth;
    }

    auto isEmpty() const -> bool {
        return m_depth == 0;
    }

    ~Pila() {
        destroyNodes(m_root);
    }

private:
    struct Node {
        T m_info{};
        Node* m_next{};

        Node() = default;

        Node(const T& info, Node* next)
            :   m_info{ info }, m_next{ next }
        {}

        Node(const T& info)
            :   m_info{ info }, m_next{ nullptr }
        {}
        template<typename... Args>
        Node(Args... args)
            : m_info{ std::forward<Args>(args)... }, m_next{ nullptr }
        {}
    };

    static auto destroyNodes(Node* node) -> void{
        if (node) {
            destroyNodes(node->m_next);
            delete node;
        }
    }

    static auto copyNodes(const Node* node) -> Node* {
        if (node) 
            return new Node(node->m_info, copyNodes(node->m_next));

        return nullptr;
    }

    Node* m_root{};
    int m_depth{};
};


#endif
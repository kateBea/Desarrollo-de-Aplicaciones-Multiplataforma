#ifndef CONST_ITERATOR_HH
#define CONST_ITERATOR_HH

#include <cstdint>
#include <cstddef>

template<typename T>
class const_iterator
{
public:
    using iterator_category = std::input_iterator_tag;
    using value_type = T;
    using difference_type = std::ptrdiff_t;
    using pointer_type = T*;
    using size_type             = std::size_t;
    using const_reference_type  = const T&;

    explicit const_iterator(pointer_type ptr)
        :   p{ ptr }
    {}

    // prefix increment
    auto operator++() -> const_iterator
    {
        ++p;
        return *this;
    }

    // postfix increment
    auto operator++(int) -> const_iterator
    {
        auto res{ p };
        ++p;
        return const_iterator{ res };
    }

    // prefix increment
    auto operator--() -> const_iterator
    {
        --p;
        return *this;
    }

    // postfix increment
    auto operator--(int) -> const_iterator
    {
        auto res{ p };
        --p;
        return const_iterator{ res };
    }

    auto operator+(size_type count) const -> const_iterator
    {
        return const_iterator{ this->p + count };
    }

    auto operator-(size_type count) const -> const_iterator
    {
        return const_iterator{ this->p - count };
    }

    auto operator-(const_iterator other) -> size_type
    {
        return this->p > other.p ?
               (this->p - other.p) : (other.p - this->p);
    }

    auto operator!=(const const_iterator& other) const -> bool
    {
        return this->p != other.p;
    }

    auto operator==(const const_iterator& other) const -> bool
    {
        return this->p == other.p;
    }

    auto operator*() const -> const_reference_type { return *p; }
    auto operator->() const -> pointer_type { return p; }

    auto raw() const -> pointer_type { return p; }

private:
    pointer_type p{};
};

#endif // CONST_ITERATOR_HH

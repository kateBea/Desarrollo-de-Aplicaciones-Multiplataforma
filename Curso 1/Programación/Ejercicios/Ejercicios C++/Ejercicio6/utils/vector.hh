#ifndef VECTOR_HH
#define VECTOR_HH

#include "common.hh"
#include "iterator.hh"
#include "const_iterator.hh"

NAMESPACE_KT_BEG

template <typename T>
class vector
{
public:
    using value_type            = T;
    using size_type             = std::size_t;
    using reference_type        = T&;
    using pointer_type          = T*;
    using const_reference_type  = const T&;
    using iterator_type         = iterator<T>;
    using const_iterator_type   = const_iterator<T>;

    /**
     * Default constructs this vector with initial size of 0
     * and initial capacity of 0.
     * */
    explicit
    vector() noexcept
        :   m_array{ nullptr }, m_count{ 0 }, m_capacity{ 0 }
    {}

    /**
     * Initializes this vector with <code>count</code> copies of
     * the value <code>value</code>
     * @param count amount of copies to be made
     * @param value initial value for ech copy
     */
    explicit
    vector(size_type count, const value_type& value = value_type())
        :   m_array{ nullptr }, m_count{ count }, m_capacity{ count }
    {
        if (m_count != 0) {
            this->m_array = static_cast<pointer_type>(::operator new(sizeof(value_type) * count, std::nothrow));

            // if we managed to allocate space, we fill the array with the provided value
            if (this->m_array != nullptr)
                std::uninitialized_fill(this->m_array, this->m_array + m_count, value);
        }
        if (not this->m_array)
        {
#if !defined(NDEBUG)
            std::printf("could not allocate block of memory...");
#endif
            this->m_capacity = 0;
        }
    }

    /**
     * Constructs and initializes this vector with the elements with in the
     * range of the <b>std::initializer_list</b>.
     * @param content range of elements to initialize this vector with
     * */
    vector(std::initializer_list<value_type>&& content)
        :   m_array{ static_cast<pointer_type>(::operator new(sizeof(value_type) * content.size(), std::nothrow)) }
        ,   m_count{ content.size() }, m_capacity{ content.size() }
    {
        if (this->m_array)
            std::uninitialized_copy(content.begin(), content.end(), this->m_array);
#if !defined(NDEBUG)
        else
        {
            std::printf("could not allocate block of memory...");
        }
#endif
    }

    /**
     * Initialize this vector with the elements from the range within
     * first and last (exclusive) iterators, i.e. copies [first, last)
     * to this vector.
     * @param first first elements from the range of elements to be copied
     * @param last last element from the range (not copied)
     * @tparam InputIterator iterator that allows to read the referenced content
     * */
    template<typename InputIterator>
    vector(InputIterator first, InputIterator last)
        :   m_array{ nullptr }, m_count{}, m_capacity{}
    {
        // represents the number of bytes between first and last
        size_type new_block_size{ sizeof(value_type) * (last - first) };

        if (new_block_size != 0)
        {
            // new_block_size represents the size in bytes of the new block
            this->m_array = static_cast<pointer_type>(::operator new(new_block_size, std::nothrow));

            if (this->m_array)
            {
                for (auto start{ begin() }; first != last; ++first, ++start)
                    new (start.raw()) value_type(*first);

                this->m_count = new_block_size / sizeof(value_type);
                this->m_capacity = new_block_size / sizeof(value_type);
            }
#if !defined(NDEBUG)
            else
            {
                std::printf("could not allocate block of memory...");
            }
#endif
        }
    }

    /**
     * Initialize this vector with <code>count</code> elements from
     * range of elements starting at <code>first</code>. If the range contains
     * less than <code>count</code> elements the behaviour of this method is undefined.
     * @param first starting point of the range of elements
     * @param count amount of elements to be copied
     * @tparam InputIterator iterator that allows to read the referenced content
     * */
    template<typename InputIterator>
    vector(InputIterator first, size_type count)
        :   m_array{ nullptr }, m_count{ count }, m_capacity{ count }
    {
        if (m_count != 0)
        {
            this->m_array = static_cast<pointer_type>(::operator new(sizeof(value_type) * count, std::nothrow));

            if (this->m_array)
            {
                for (auto start{ begin() }; start != end(); ++first, ++start)
                    new (start.raw()) value_type(*first);

                this->m_count = count;
                this->m_capacity = count;
            }
#if !defined(NDEBUG)
            else
            {

                std::printf("could not allocate block of memory...");
            }
#endif
        }
    }

    /**
     * Copies contents from <code>other</code> into this vector.
     * @param other copied from vector
     * */
    vector(const vector& other)
        :   m_array{ nullptr }, m_count{}, m_capacity{}
    {
        if (other.size() != 0)
        {
            this->m_array = static_cast<pointer_type>(::operator new(sizeof(value_type) * other.m_count, std::nothrow));

            if (this->m_array)
            {
                std::copy(other.begin().raw(), other.end().raw(), this->m_array);
                this->m_count = other.size();
                this->m_capacity = other.capacity();
            }
#if !defined(NDEBUG)
            else
            {
                std::printf("could not allocate block of memory...");
            }
#endif
        }
    }

    /**
     * Copy the contents of <code>other</code> into this vector.
     * @param other copied from vector
     * @returns <code>*this</code>
     * */
    auto operator=(const vector& other) -> vector&
    {
        if (this != &other)
        {
            for (size_type index{}; index < m_count; ++index)
                this->m_array[index].~value_type();

            ::operator delete(this->m_array);
            this->m_array = static_cast<pointer_type>(::operator new(sizeof(value_type) * other.m_count, std::nothrow));

            if (this->m_array)
            {
                std::copy(other.m_array, other.m_array + other.m_count, this->m_array);
                this->m_count = other.m_count;
                this->m_capacity = other.m_capacity;
            }
#if !defined(NDEBUG)
            else
            {
                std::printf("could not allocate block of memory...");
            }
#endif
        }

        return *this;
    }

    /**
     * Moves the contents of the <code>other</code> vector into this vector.
     * After this operation <code>other</code> is put into an invalid state.
     * @param other moved from vector
     * */
    vector(vector&& other) noexcept
        :   m_array{ other.m_array }, m_count{ other.m_count }, m_capacity{ other.m_capacity }
    {
        if (other.m_capacity != 0)
        {
            other.m_array = nullptr;
            other.m_count = 0;
            other.m_capacity = 0;
        }
    }

    /**
     * Moves the contents of the <code>other</code> vector into this vector.
     * After this operation <code>other</code> is put into an invalid state.
     * @param other moved from vector
     * @returns <code>*this</code>
     * */
    auto operator=(vector&& other) noexcept -> vector&
    {
        if (this != &other)
        {
            this->m_array = other.m_array;
            this->m_count = other.size();
            this->m_capacity = other.capacity();

            other.m_array = nullptr;
            other.m_count = 0;
            other.m_capacity = 0;
        }

        return *this;
    }

    /**
     * Returns a pointer to the block holding the underlying buffer of data
     * @returns pointer to the underlying block of data
     * */
    constexpr auto data() -> pointer_type
    {
        return m_array;
    }

    /**
     * Calls the destructor for all the elements
     * in this vector and frees the underlying buffer of memory
     * */
    ~vector()
    {
        // pre clean-up
        for (size_type index{}; index < m_count; ++index)
            this->m_array[index].~T();

        ::operator delete(this->m_array);
    }

    /**
     * Returns the count of elements in this vector
     * @returns amount of elements contained within this vector
     * */
     [[nodiscard]]
    auto size() const -> size_type
    {
        return this->m_count;
    }

    /**
     * Returns the number of elements this vector has allocated space for.
     * @returns capacity of this vector
     * */
    [[nodiscard]]
    auto capacity() const -> size_type
    {
        return this->m_capacity;
    }

    /**
     * Returns <code>true</code> if this vector has no elements, <code>false</code> otherwise.
     * @returns if this vector is empty or not
     * */
    [[nodiscard]]
    auto empty() const -> bool
    {
        return size() == 0;
    }

    /**
     * Returns a reference to the first element of this vector.
     * @param index index of the element to be returned
     * @returns reference to the element at the specified index
     * */
    [[nodiscard]]
    auto operator[](size_type index) -> reference_type
    {
#if defined(NDEBUG)
        assert(index < size() && "Attempting to access out of bounds element...");
#endif
        return this->m_array[index];
    }

    /**
     * Returns a constant reference to the element at index <code>index</code>.
     * @param index index of the element to be returned
     * @returns reference to the element at the given index
     * */
    auto operator[](size_type index) const -> const_reference_type
    {
#if !defined(NDEBUG)
        assert(index < size() && "Attempting to access out of bounds element...");
#endif
        return this->m_array[index];
    }

    /**
     * Return reference to element at position <code>index</code>.
     * @param index index of the element to be returned
     * @returns reference to the element at the given index
     * @throws std::runtime_error if this vector is empty or the index is out of bounds
     * */
    auto at(size_type index) -> reference_type
    {
        if (size() == 0)
            throw std::runtime_error("This vector has no elements");

        if (index >= size())
            throw std::out_of_range("Attempting to access an element out of range");

        return (*this)[index];
    }

    /**
     * Return constant reference to element at position <code>index</code>.
     * @param index index of the element to be returned
     * @returns constant reference to the element at the given index
     * @throws std::runtime_error if this vector is empty or the index is out of bounds
     * */
    auto at(size_type index) const -> const_reference_type
    {
        if (size() == 0)
            throw std::runtime_error("This vector has no elements");

        if (index >= size())
            throw std::out_of_range("Attempting to access an element out of range");

        return (*this)[index];
    }

    /**
     * Reserve a block of memory to hold at least count elements. Has no
     * effect if the container can already hold <code>new_count</code>extra  elements.
     * <code>new_count</code> just tells how many elements we want in this vector besides
     * the ones currently stored.
     * @param new_count how many extra elements we may want in this vector
     * */
    auto reserve(size_type new_count) -> void
    {
        // TODO: not fully implemented yet
        if (new_count > capacity())
        {
            this->m_capacity = new_count;
            reallocate();
        }
    }

    /**
     * After this operation, this vector may have <code>count</code> elements.
     * If count is greater than <code>size()</code> the necessary amount of elements
     * are appended to this vector to have count elements, these are default initialized,
     * otherwise the user can specify the object the additional elements must be copied from.
     * If count is smaller than <code>size()</code> the required amount of elements are
     * deleted from this vector.
     * */
    auto resize(size_type count, const value_type& info = value_type()) -> void
    {

    }

    /**
     * Construct element in place, in this case, right
     * at the end of this vector. This function takes the necessary
     * arguments to construct a new object of the type held by this vector.
     * @param args arguments to construct the new object
     * @tparam types of the parameters of this function
     * */
    template <typename... Args>
    auto emplace_back(Args&&... args) -> void
    {
        if (size() == capacity())
            reallocate();

        new(&this->m_array[this->m_count++]) value_type(std::forward<Args>(args)...);
    }

    /**
     * Concatenates the contents of this vector and <code>other</code>, i.e. inserts
     * all the elements of <code>other</code> at the end of this vector.
     * @param other has the contents to be appended at the end of this vector
     * */
    auto append(const vector& other) -> void
    {
        if (!other.empty())
        {
            pointer_type new_block{ static_cast<pointer_type>
                (::operator new(sizeof(value_type) * (size() + other.size()), std::nothrow)) };

            if (new_block != nullptr)
            {
                // Move this vector's memory block data to the newly allocated block
                std::memcpy(static_cast<void*>(new_block), static_cast<const void*>(this->m_array),size() * sizeof(value_type));

                // Copy the contents of other at the end of this vector
                auto it{ new_block + size() };
                for (const auto& item : other)
                    new (it++) value_type(item);

                ::operator delete(static_cast<void*>(this->m_array));

                this->m_array = new_block;
                this->m_count = this->m_count + other.m_count;
                this->m_capacity = this->m_count;

            }
            else
            {
#if !defined(NDEBUG)
                std::printf("failed to concatenate. Could not allocate block of memory...");
#endif
            }
        }
    }

    /**
     * Destroy the last <code>count</code> elements from
     * this vector. If there's  less than <code>count</code> elements,
     * the effects of this function are the same as <code>clear()</code>.
     * @param count number of elements to be deleted
     * */
    auto remove_n(size_type count) -> void
    {
        if (count < size())
        {
            // if we have more than count elements
            std::for_each(begin(),
                          end(),
                          [](reference_type info) -> void { info.~value_type(); });

            this->m_count = size() - count;
        }
        else
        {
            clear();
        }
    }

    /**
     * Insert <code>elem</code> at the end of this vector.
     * @param elem new element to be inserted
     * */
    auto push_back(const_reference_type elem) -> void
    {
        if (capacity() > size())
        {
            new(&this->m_array[this->m_count]) value_type(elem);
            this->m_count += 1;
        }
        else
        {
            reallocate();

            // if reallocate fails, m_count will remain the same as m_capacity
            // preventing from appending elements any further
            if (this->m_capacity == this->m_count)
            {
#if !defined(NDEBUG)
                std::printf("could not insert new element due to error while reallocating...");
#endif
                return;
            }

            new(&this->m_array[this->m_count]) value_type(elem);
            this->m_count += 1;
        }
    }

    /**
     * Insert <code>elem</code> at the end of this vector
     * using move semantics.
     * @param elem new element
     * */
    auto push_back(value_type&& elem) -> void
    {
        if (capacity() > size())
        {
            new(&this->m_array[this->m_count]) value_type(std::move(elem));
            this->m_count += 1;
        }
        else
        {
            reallocate();

            // if reallocate fails, size() will be same as capacity()
            // preventing from appending elements any further
            if (this->m_capacity == this->m_count)
            {
#if !defined(NDEBUG)
                std::printf("could not insert new element due to error while reallocating...");
#endif
                return;
            }

            new(&this->m_array[this->m_count]) value_type(std::move(elem));
            ++(this->m_count);
        }
    }

    /**
     * Remove the last element of this vector. If this vector is empty this operation has no effect.
     * */
    auto pop_back() -> void
    {
        if (this->m_count != 0)
        {
            (*this)[size() - 1].~value_type();
            --(this->m_count);
        }
    }

    /**
     * Remove all the elements from this vector
     * */
    auto clear() -> void
    {
        std::for_each(begin(),
                      end(),
                      [](reference_type info) -> void { info.~value_type(); });
        this->m_count = 0;
    }

    /**
     * Returns an iterator to the beginning of the vector.
     * @returns access to the elements at the beginning
     * */
     [[nodiscard]]
    constexpr auto begin() noexcept -> iterator_type
    {
        return iterator_type{ this->m_array };
    }

    /**
     * Returns an iterator past the last element of the vector.
     * @returns access to the element past the end of this vector
     * */
    [[nodiscard]]
    constexpr auto end() noexcept -> iterator_type
    {
        return iterator_type{ this->m_array + this->m_count };
    }

    /**
     * Returns a constant iterator to the beginning of the vector.
     * @returns read-only access to the elements at the beginning
     * */
    [[nodiscard]]
    constexpr auto begin() const noexcept -> const_iterator_type
    {
        return const_iterator_type{ this->m_array };
    }

    /**
     * Returns a constant iterator past the last element of the vector.
     * @returns read-only access to the element past the end of this vector
     * */
    [[nodiscard]]
    constexpr auto end() const noexcept -> const_iterator_type
    {
        return const_iterator_type{ this->m_array + this->m_count };
    }

    /**
     * Returns a constant iterator to the beginning of the vector.
     * @returns read-only access to the elements at the beginning
     * */
    [[nodiscard]]
    constexpr auto cbegin() const noexcept -> const_iterator_type
    {
        return const_iterator_type{ this->m_array };
    }

    /**
     * Returns a constant iterator past the last element of the vector.
     * @returns read-only access to the element past the end of this vector
     * */
    [[nodiscard]]
    constexpr auto cend() const noexcept -> const_iterator_type
    {
        return const_iterator_type{ this->m_array + this->m_count };
    }

    /**
     * Returns a reference to the first element of this vector.
     * @returns front element
     * */
    [[nodiscard]]
    auto front() noexcept -> reference_type
    {
        return *this->m_array;
    }

    /**
     * Returns a reference to the last element of this vector.
     * @return last element
     * */
    auto back() noexcept -> reference_type 
    {
#if !defined(NDEBUG)
        assert(!empty() && "Attempting to retrieve back element of empty vector");
#endif
        return *(this->m_array + this->m_count - 1);
    }

    /**
     * Returns a constant reference to the first element of this vector.
     * @return front element
     * */
    auto front() const noexcept -> const_reference_type 
    {
#if !defined(NDEBUG)
        assert(!empty() && "Attempting to retrieve front element of empty vector");
#endif
        return *this->m_array;
    }

    /**
     * Returns a constant reference to the last element of this vector.
     * @returns last element
     * */
    auto back() const noexcept -> const_reference_type 
    {
#if !defined(NDEBUG)
        assert(!empty() && "Attempting to retrieve back element of empty vector");
#endif
        return *(data() + size() - 1);
    }

private:
    static constexpr size_type GROW_FACTOR{ 2 };

    auto reallocate() -> void
    {
        // we reserve space for one element if the vector is empty when reallocate() is called
        size_type new_block_count{ (this->m_capacity == 0) ? 1 : (this->m_capacity * GROW_FACTOR) };
        pointer_type new_block{ static_cast<pointer_type>(::operator new(sizeof(T) * new_block_count, std::nothrow)) };

        if (new_block == nullptr)
        {
#if !defined(NDEBUG)
            std::printf("Failed to allocate new block of memory");
#endif
            return;
        }

        // we just want to move the contents from one block of memory to another
        std::memcpy(static_cast<void*>(new_block), static_cast<const void*>(this->m_array),
            this->m_count * sizeof(value_type));

        ::operator delete(static_cast<void*>(this->m_array));

        this->m_array = new_block;
        this->m_capacity = new_block_count;
    }
    
    pointer_type    m_array;
    size_type       m_count;
    size_type       m_capacity;

    /**
     * <h3>CONSTRAINTS: m_capacity >= m_count >= 0</h3>
     *
     * <h3>SOME DETAILS:</h3>
     * <p><code>value_type</code> must support the operations of <strong>copy assignment/copy construction or move assigment/move construction</strong></p>
     *
     * <p><code>m_array</code> points to the underlying memory buffer owned by this vector or its value is nullptr</br></p>
     * <p><code>m_capacity</code> is increased by a growth factor to minimise the number of call to reallocate()</br></p>
     * <p><code>m_count</code> keeps track of the amount of valid elements in this vector inside the vector</br></p>
     * */


};  // CLASS VECTOR

NAMESPACE_KT_END   // END KT NAMESPACE

#endif

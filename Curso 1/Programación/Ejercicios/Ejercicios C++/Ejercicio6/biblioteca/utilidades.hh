#if !defined(BIBLIO_UTILIDADES_HH)
#define BIBLIO_UTILIDADES_HH

#define DISABLE_COPY_AND_MOVE_FOR(CLASS_NAME)       \
    CLASS_NAME(const CLASS_NAME&)       = delete;   \
    auto operator=(const CLASS_NAME&)   = delete;   \
    CLASS_NAME(CLASS_NAME&&)            = delete;   \
    auto operator=(CLASS_NAME&&)        = delete
    
#endif
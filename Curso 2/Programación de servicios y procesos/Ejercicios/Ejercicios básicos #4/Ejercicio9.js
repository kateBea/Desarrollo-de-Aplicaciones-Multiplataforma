function suma(lowerBound, upperBound) {
    let result = 0;

    for ( ; lowerBound <= upperBound; ++lowerBound) {
        result += lowerBound;
    }

    return result;
}

exports.suma = suma;
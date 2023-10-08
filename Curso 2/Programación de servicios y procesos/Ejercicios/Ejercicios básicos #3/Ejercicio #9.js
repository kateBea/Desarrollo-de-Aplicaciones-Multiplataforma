function Pair(firstElem, secondElem) {
    this.first = firstElem;
    this.second = secondElem;
}

let operations = {
    '+': (a, b) => { return a+b; },
    '-': (a, b) => { return a-b; },
    '*': (a, b) => { return a*b; },
    '/': (a, b) => { return a/b; },

    'sqrt': (a, b = null) => { return Math.sqrt(a); },
    'sin': (a, b = null) => { return Math.sin(a); },
    'cos': (a, b = null) => { return Math.cos(a); },
    'tan': (a, b = null) => { return Math.tan(a); },
};

function getOprationFromOperator(op) {
    console.log("Debug: op ->" + op);
    if (op in operations) {
        return new Pair(true, operations[op]);
    } else {
        return new Pair(false, 'Operación desconocida');
    }
}

function compute(op1, op2, op) {
    const result = getOprationFromOperator(op);
    if (result.first) {
        console.log(result.second(parseFloat(op1), parseFloat(op2)));
    }
    else {
        console.log(result.second);
    }
}

function tests() {
    compute(process.argv[3], process.argv[1], process.argv[2]);
}

tests();


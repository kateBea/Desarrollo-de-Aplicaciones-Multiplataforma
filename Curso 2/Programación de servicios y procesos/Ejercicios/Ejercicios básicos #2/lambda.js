// función lambda que suma dos números

const numero1 = 44.32;
const numero2 = 52.46;

const sumar = (num1, num2) => { return num1 + num2; }
const sumarRef = (num1, num2) => { return num1 + num2; }

const resultado = sumar(numero1, numero2)
const resultado2 = sumar(numero1 + 2, numero2 - 22)

console.log(resultado)
console.log(resultado2)
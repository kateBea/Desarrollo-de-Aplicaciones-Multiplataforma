def to_binary(number):
    if number == 0: return "0"
    if number == 1: return "1"
        
    return to_binary(number // 2) + ("0" if number % 2 == 0 else "1")
    
if __name__ == "__main__":
    numero = int(input("Entra un número entero: "))
    print(f"{numero} en binario es:  {to_binary(numero)}")
fn main() {
    println!("--- Lectura de la entrada estándar ---");

    // Aquí use eprint! porque la salida estándar de error
    // acostumbra a no estar "buffered". Si uso print! "Entra tu nombre: " puede no
    // mostrarse hasta la siguiente vez que se tenga que mostrar algo por consola
    eprint!("Entra tu nombre: ");

    let mut input = String::new();

    std::io::stdin().read_line(&mut input).expect("Error al leer línea");
    print!("Te llamas: {}", input);
}

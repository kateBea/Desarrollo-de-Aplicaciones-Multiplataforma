use rand::Rng;
use std::cmp::Ordering;

fn main() {
    println!("Bienvenido al juego de la adivinanza");
    println!("Tu misión es adivinar el número secreto (entre 0 y 25, ambos inclusos)\n");

    // Inicializar número
    let mut rng = rand::thread_rng();
    let secret_num = rng.gen_range(0..=25);
    // let secret_num = rng.gen_range(0..25); // rango exclusivo (25 no incluido)

    // Leer del usuario
    let mut input = String::new();
    eprint!("Entra un valor: ");
    std::io::stdin().read_line(&mut input).expect("Error al leer datos");
    let user_guess: u32 = input.trim().parse().expect("Error al convertir a entero");

    match user_guess.cmp(&secret_num) {
        Ordering::Less => { println!("Valor muy pequeño"); }
        Ordering::Greater => { println!("Valor muy grande"); }
        Ordering::Equal => { println!("Hay coincidencia"); }
    }

    println!("Has introducido: {}", user_guess);
    println!("EL número secreto es: {}", secret_num);
}

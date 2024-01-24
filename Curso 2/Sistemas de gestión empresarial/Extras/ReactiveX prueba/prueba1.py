# Script Prueba ReactiveX
# autor: Hugo Pelayo
# fecha: Enero 24 2024

from reactivex import of

source = of("Aarón", "Hugo", "Carlos", "Lucas");

source.subscribe(
    on_next=lambda param: print(f"Received: {param}")
)
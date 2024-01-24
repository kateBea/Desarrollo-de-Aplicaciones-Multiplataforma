# Script Prueba ReactiveX
# autor: Hugo Pelayo
# fecha: Enero 24 2024

import reactivex

def string_generator(observer, scheduler):
    observer.on_next("Aarón")
    observer.on_next("Pedro")
    observer.on_next("Mario")

source = reactivex.create(string_generator)

source.subscribe(
    on_next=lambda param: print(f"Received: {param}"),
    on_completed=lambda: print(f"Everything OK!")
)
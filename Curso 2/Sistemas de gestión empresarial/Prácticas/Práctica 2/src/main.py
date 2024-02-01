import multiprocessing

from interfaz import GUI
from servidor import Server
from threading import current_thread
from reactivex.scheduler import ThreadPoolScheduler

def run():
    # Thread pool init
    optimal_thread_count = multiprocessing.cpu_count() + 1
    pool_scheduler = ThreadPoolScheduler(optimal_thread_count)

    # Creamos el servidor (observable)
    server = Server(pool_scheduler)    
    
    # Creamos la interfaz
    gui = GUI()
    
    # Nos suscribimos al obervable para recibir datos de forma periódica
    server.subscribe(gui.procesar_dato)
    gui.run()
    


if __name__ == "__main__":
    run()
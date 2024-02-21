import time
import random

from threading import Thread
from threading import current_thread

def first_task(lower, upper):
    limit = 5
    id = current_thread().native_id
    
    while True:
        print(f"Thread {id} generated {random.randint(lower, upper)} and sleeping for 1 second")
        time.sleep(1)
        
        limit = limit - 1
        
        if limit == 0:
            break
        
    
def second_task(lower, upper):
    limit = 8
    id = current_thread().native_id
    
    while True:
        print(f"Thread {id} generated {random.randint(lower, upper)} and sleeping for 1 second")
        time.sleep(1)
        
        limit = limit - 1
        
        if limit == 0:
            break

def run():
    hilo1 = Thread(target=first_task, args=(1, 55))
    hilo2 = Thread(target=second_task, args=(1, 44))
    
    hilo1.start()
    hilo2.start()
    
    hilo1.join()
    hilo2.join()

if __name__ == "__main__":
    run()
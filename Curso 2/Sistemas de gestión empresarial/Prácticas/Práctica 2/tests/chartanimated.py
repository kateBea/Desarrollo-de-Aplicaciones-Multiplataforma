import tkinter
from matplotlib.backends.backend_tkagg import (
    FigureCanvasTkAgg, NavigationToolbar2Tk)
from matplotlib.backend_bases import key_press_handler
from matplotlib import pyplot as plt, animation
import numpy as np
import random 

MAX_TEMPERATURA = 50.0
MIN_TEMPERATURA = 20

TIME_INTERVAL = 5

nums = []

def random_ints():
    global nums

    if len(nums) == 0:
        nums = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

    nums.append(random.random() * (MAX_TEMPERATURA - MIN_TEMPERATURA) + MIN_TEMPERATURA)

    nums = nums[-10:]

    return np.array(nums)


def init():
    line.set_data([], [])
    return line,

def animate(i):
    x = np.linspace(0, 2, 10)
    y = random_ints() #np.sin(2 * np.pi * (x - 0.01 * i))
    line.set_data(x, y)
    return line,

# Setup plot look
plt.rcParams["figure.figsize"] = [7.00, 3.50]
plt.rcParams["figure.autolayout"] = True
plt.rcParams['lines.linewidth'] = 2
plt.rcParams['lines.linestyle'] = ':'

# Create a TK window
root = tkinter.Tk()
root.wm_title("Embedding in Tk")

plt.axes(xlim=(0, TIME_INTERVAL), ylim=(MIN_TEMPERATURA, MAX_TEMPERATURA))

fig = plt.Figure(dpi=100)
ax = fig.add_subplot(xlim=(0, TIME_INTERVAL), ylim=(MIN_TEMPERATURA, MAX_TEMPERATURA))
line, = ax.plot([], [], lw=2)

# Create and setup the canvas
canvas = FigureCanvasTkAgg(fig, master=root)
canvas.draw()

# Make the canvas visible in the frame
canvas.get_tk_widget().pack(side=tkinter.TOP, fill=tkinter.BOTH, expand=1)

# Create and animation by repeatedlly calling animate()
anim = animation.FuncAnimation(fig, animate, init_func=init,frames=200, interval=50, blit=True)

# Call the main tkinter loop
tkinter.mainloop()
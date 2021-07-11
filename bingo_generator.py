'''
Programmer: Trevor Bushnell
v1.0: 07/10/2021

Code for a program that randomly chooses 25 goals to be used in nsmb2 bingo. 
Outputs a .txt file with the goals in JSON format to be copy/pasted right into bingosync.com
'''


# import the required packages

import random


# MAIN FUNCTION

def __main__():
    print("Hello world")

# Function that generates 25 random seeds
def generate_seeds():
    seeds = []
    is_found = False;

    for i in range(25):
        counter = 0

        while not is_found:
            rand_seed = random.randint(1,132) # change when you get goals list

            while counter < len(seeds):
                if rand_seed == seeds[counter]:
                    break

                if counter == len(seeds) - 1:
                    seeds.append(rand_seed)
                    is_found = True

                counter += 1


    return seeds



# Tester function that prints out the seeds array
def print_seeds(seeds):
    for i in range(len(seeds)):
        print(seeds[i])







'''
import tkinter as tk

root= tk.Tk()

canvas1 = tk.Canvas(root, width = 300, height = 300)
canvas1.pack()

def hello ():  
    label1 = tk.Label(root, text= 'Hello World!', fg='green', font=('helvetica', 12, 'bold'))
    canvas1.create_window(150, 200, window=label1)
    
button1 = tk.Button(text='Click Me',command=hello, bg='brown',fg='white')
canvas1.create_window(150, 150, window=button1)

root.mainloop()
'''



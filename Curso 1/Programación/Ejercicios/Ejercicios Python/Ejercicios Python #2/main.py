# FILE MAIN_1 CONTAINING THE MAIN PROGRAM
# FILE ENCODING: UTF-8

import utils
from data import products_name
from data import products_price
from data import the_menu
from data import options

print('******* WELCOME TO SIMPLE MACHINE EXPENDING *******\n')

user_name   = input("Please enter your name: ")
money       = float(input("Please enter an amount of money: "))
bought_prod = list()
spent_money = 0

print(f'Please make a choice, {user_name}')
print(options)
command = input()

while True:
    if command == '0':
        product_code = input("Please enter a product code number: ")

        if int(product_code) in products_name:
            item_price  = products_price[int(product_code)]
            item_name   = products_name[int(product_code)]
            if item_price > money:
                print(f'you do not have enough money to buy {item_name}')
            else:
                money       = money - item_price
                spent_money = spent_money + item_price
                print(f'you bought {item_name} for ${item_price}')
                bought_prod.append(item_name)
        else:
            print('product code not valid.')

    elif command == '1':
        print(the_menu)

    elif command == '2':
        print(f'total amount of credit left: ${money}')

    elif command == '3':
        print(f'you have spent a total of: ${spent_money}')

    elif command == '4':
        if len(bought_prod) == 0:
            print("you haven't bought any products yet")
        else:
            item_number = 1
            for item in bought_prod:
                print(f'{item_number}. {item}')
                item_number = item_number + 1

    elif command == '5':
        print(options)

    elif command == "6" or command == "exit":
        print("exiting program...")
        utils.return_money(money)
        break

    command = input("what would you like to do? "
                    "(Reminder: you can enter the '5' command "
                    "to display again help on program usage): ")
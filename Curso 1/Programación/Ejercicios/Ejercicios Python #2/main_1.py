# FILE MAIN_1 CONTAINING THE MAIN PROGRAM
# FILE ENCODING: UTF-8

import money_management

# this variable contains all the items the expending machine is elling
the_menu = """
ItemName	ItemCode	ItemPrice	ItemExpDate
--------	--------	---------	------------
Coca-Cola          11             $2.77          20.03.2022
Twizzlers          13             $3.22          17.05.2022
Ham                10             $5.67          01.01.2025
Pepsi              15             $3.11          12.10.2022
KAS Orange         17             $2.99          11.06.2022
KAS Lemon          19             $2.99          21.03.2023
KAS Ananas         25             $1.99          20.03.2024
Water              12             $1.59          21.11.2022
"""

products_name   = { 11:"Coca-Cola", 13:"Twizzlers", 10:"Ham", 15:"Pepsi",
                   17:"KAS Orange", 19:"KAS Lemon", 25:"KAS Ananas", 12:"Water" }

products_price  = { 11:2.77, 13:3.22, 10:5.67, 15:3.11,
                   17:2.99, 19:2.99, 25:1.99, 12:1.59 }

# possible options
options = """
Please to select one of the options enter the number:
NOTE: To exit machine enter either 6 or type 'exit'

    0. buy product (user may check on machine available products)
    1. check machine products 
    2. check current credit
    3. check spent credit
    4. check bought products
    5. display this help
    6. exit
"""

# print welcome message
print("----------> WELCOME TO SIMPLE MACHINE EXPENDING <----------\n")

your_name   = input("Please enter your name: ")
money       = float(input("Please enter an amount of money: "))
spent_money = 0
bought_prod = []

print('All right {name}, please choose one of the following number '
      'to access the service.'.format(name = your_name))
print(options)
command = input()

while True:
    if command == '0':
        product_code = input("please enter a product code number: ")

        # if the entered value is a valid command code and the user has enough money
        if type(product_code) == type(" "):
            # find the product by its code in the product's dictionary
            # subtract the product cost from user current credit
            item_price  = products_price[int(product_code)]
            item_name   = products_name[int(product_code)]
            if item_price > money:
                print("you don't have enough money to buy {it_name}\n".format(it_name=item_name))
            else:
                money       = money - item_price
                spent_money = spent_money + item_price
                print("you bought {it_name} for ${amount}\n".format(it_name=item_name, amount = item_price))
            bought_prod.append(item_name)
        else:
            print("product code not valid.\n")

    elif command == '1':
        print(the_menu)
    elif command == '2':
        print("total amount of credit left: ${money_left}\n".format(money_left=money))
    elif command == '3':
        print("you have spent a total of: ${spent}\n".format(spent = spent_money))
    elif command == '4':
        if len(bought_prod) == 0:
            print("you haven't bought any products yet\n")
        else:
            item_number = 1
            for item in bought_prod:
                print("{num}. {item_name}\n".format(num = item_number, item_name = item))
                item_number = item_number + 1
    elif command == '5':
        print(options)
    elif command == "6" or command == "exit":
        print("exiting program:\n")
        money_management.return_money(money)
        break
    command = input("what would you like to do? "
                    "(Reminder: you can enter the '5' command "
                    "to display again help on program usage): ")
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

products_name = { 11:"Coca-Cola", 13:"Twizzlers", 10:"Ham", 15:"Pepsi",
                   17:"KAS Orange", 19:"KAS Lemon", 25:"KAS Ananas", 12:"Water" }

products_price = { 11:2.77, 13:3.22, 10:5.67, 15:3.11, 17:2.99, 19:2.99, 25:1.99, 12:1.59 }

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

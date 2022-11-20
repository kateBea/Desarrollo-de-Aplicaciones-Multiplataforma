def return_money(amount):
    currency = [50, 20, 10, 2, 1, 0.5, 0.10, 0.05, 0.01]

    for value in currency:
        total = 0
        while value <= amount != 0:
            amount = amount - value
            total = total + 1

        # if the currency was used at least once
        if total != 0:
            # value to be returned is a cent
            if value < 1:
                print(f'\treturned ${int(value*100)} x{total} cent(s)')
            else:
                print(f'\treturned ${value} x{total}')

        if amount == 0:
            break
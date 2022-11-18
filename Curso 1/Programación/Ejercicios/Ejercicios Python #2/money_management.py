# FILE MONEY_MANAGEMENT

# returns money in appropriate amount of each value
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
                print("\treturned ${curr_value} x{times} cent(s)".format(curr_value = int(value*100), times=total))
            else:
                print("\treturned ${curr_value} x{times}".format(curr_value = value, times=total))

        if amount == 0:
            break
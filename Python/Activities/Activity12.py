def sumNum(number):
    if (number >= 0):
        return number + sumNum(number-1)
    else:
        return 0

print(sumNum(10))
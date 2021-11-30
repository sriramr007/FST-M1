def sum_number(numbers):
    sum = 0
    for i in numbers:
        sum += int(i)
    return sum

numberList = list(input("Enter comma seperated numbers: ").split(","))
print(sum_number(numberList))
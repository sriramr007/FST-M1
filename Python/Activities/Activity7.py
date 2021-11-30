userInput = list(input("Enter comma seperated numbers: ").split(","))
sum = 0
for i in userInput:
    sum += int(i)
print("Sum : ", sum)
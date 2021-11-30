userInput = list(input("Enter comma seperated numbers: ").split(","))
if (userInput[0] == userInput[-1]):
    print(True)
else:
    print(False)
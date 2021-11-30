inputTuple = tuple(input("Enter comma seperated numbers: ").split(","))

for i in inputTuple:
    if (int(i) % 5 == 0):
        print(int(i))
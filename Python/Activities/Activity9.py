firstList = list(input("Enter comma seperated numbers: ").split(","))
secondList = list(input("Enter comma seperated numbers: ").split(","))
thirdList = []

for i in firstList:
    if (int(i) % 2 != 0 or int(i) == 1):
        thirdList.append(int(i))

for j in secondList:
    if (int(j) % 2 == 0):
        thirdList.append(int(j))

print(thirdList)
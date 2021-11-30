fruitShop = {
    "apple": 10,
    "banana": 15,
    "orange": 8,
    "peaches": 15
}

fruit = input("Enter Fruit name: ").lower()

if fruit in fruitShop:
    print(f"{fruit} is available, price = Rs. {fruitShop[fruit]}/kg")
elif fruit not in fruitShop:
    print(f"{fruit} is not available")
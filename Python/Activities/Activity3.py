inputPlayer1 = input("Your call, Player 1 : ").lower()
inputPlayer2 = input("Your call, Player 2 : ").lower()

flag = True

if (inputPlayer1 == "rock"):
    if (inputPlayer2 == "paper"):
        flag = False
    elif (inputPlayer2 == "scissors"):
        flag = True
elif (inputPlayer1 == "paper"):
    if (inputPlayer2 == "scissors"):
        flag = False
    elif (inputPlayer2 == "rock"):
        flag = True
elif (inputPlayer1 == "scissors"):
    if (inputPlayer2 == "rock"):
        flag = False
    elif (inputPlayer2 == "paper"):
        flag = True
elif (inputPlayer1 == inputPlayer2):
    print("Match drawn!")
else:
    print("Give correct input")


if flag:
    print("Player 1 wins!")
else:
    print("Player 2 wins!")
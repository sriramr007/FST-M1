def fibonacci(number):
    if number <= 1:
        return number
    else:
        return (fibonacci(number-1) + fibonacci(number-2))

fibonacciNumber = int(input("How many numbers will be in Fibonacci series? "))

if fibonacciNumber <= 0:
    print("Please enter a positive number")
else:
    print("Fibonacci Sequence: ")
    for i in range(fibonacciNumber):
        print(fibonacci(i))
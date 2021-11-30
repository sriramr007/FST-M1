import pytest

def test_addition():
    num1 = 10
    num2 = 20
    sum = num1 + num2
    assert sum == 30

def test_subtraction():
    num1 = 40
    num2 = 20
    diff = num1 - num2
    assert diff == 20

def test_multiplication():
    num1 = 40
    num2 = 20
    mult = num1 * num2
    assert mult == 800

def test_division():
    num1 = 40
    num2 = 20
    division = num1 / num2
    assert division == 2
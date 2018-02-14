import numpy

table = numpy.zeros(shape=(4,4),dtype="S2")
checker = False
mark = b'X'
def intializer():
    counter = 0
    for i in range(4):
        for j in range(4):
            table[i][j]=counter
            counter+=1

def inputChecker(num1,num2):
    global checker
    if num1<0 or num1>15 or num2<0 or num2>15:
        print("INVALID INPUT PLEASE REINPUT THE VALUES!!!")
    else:
        if num1 == num2+1 or num2 == num1+1 or num1 == num2-1 or num2 == num1-1 or num1 == num2+4 or num2 == num1+4 or num1 == num2-4 or num2 == num1-4:
            if table[num1//4][num1%4]==mark or table[num2//4][num2%4]==mark:
                print("ONE OF THE INPUTS IS USED PLEASE REINPUT THE VALUES!!!")
            else:
                checker = True
        else:
            print("INVALID INPUT PLEASE REINPUT THE VALUES!!!")

def tableChecker():
    checkX = False
    for i in range(4):
        for j in range(4):
            if table[i][j] != mark:
                #print(i , j)
                if i != 0 and i != 3:
                    if table[i-1][j]!=mark or table[i+1][j]!=mark:
                       checkX= True
                elif j != 0 and j != 3:
                    if table[i][j+1]!=mark or table[i][j-1]!=mark:
                       checkX= True
                elif i != 0 and i != 3 and j != 0 and j != 3:
                    if table[i][j+1]!=mark or table[i][j-1]!=mark or table[i-1][j]!=mark or table[i+1][j]!=mark:
                       checkX= True
    return  checkX


intializer()

print(table)
turn = 0
while(tableChecker()):
    checker = False;
    while(not checker):
        if turn%2 == 0:
            print("PLAYER 1 TURN")
            number1 = (int)(input("Enter the first number : "))
            number2 = (int)(input("Enter the second number : "))
            inputChecker(number1, number2)
        else :
            print("PLAYER 2 TURN")
            number1 = (int)(input("Enter the first number : "))
            number2 = (int)(input("Enter the second number : "))
            inputChecker(number1, number2)
    table[number1//4][number1%4]="X"
    table[number2//4][number2%4]="X"
    print(table)
    turn+=1

turn-=1
if turn%2 == 0:
    print("PLAYER 1 WINS")
else:
    print("PLAYER 2 WINS")
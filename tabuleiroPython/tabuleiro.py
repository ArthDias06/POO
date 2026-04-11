from math import sqrt

class Tabuleiro:
    def __init__(self, numbers):
        self.length = int(sqrt(len(numbers)))

        self.table = [[0 for _ in range(self.length)] for _ in range(self.length)]

        k = 0
        for i in range(self.length):
            for j in range(self.length):
                self.table[i][j] = int(numbers[k])
                k += 1

    def up(self):
        for i in range(self.length):
            for j in range(self.length):
                if(self.table[i][j] == 0 and i < self.length-1):
                    temp = self.table[i][j]
                    self.table[i][j] = self.table[i+1][j]
                    self.table[i+1][j] = temp
                    return
    
    def down(self):
        for i in range(self.length):
            for j in range(self.length):
                if(self.table[i][j] == 0 and i > 0):
                    temp = self.table[i][j]
                    self.table[i][j] = self.table[i-1][j]
                    self.table[i-1][j] = temp
                    return

    def left(self):
        for i in range(self.length):
            for j in range(self.length):
                if(self.table[i][j] == 0 and j < self.length-1):
                    temp = self.table[i][j]
                    self.table[i][j] = self.table[i][j+1]
                    self.table[i][j+1] = temp
                    return

    def right(self):
        for i in range(self.length):
            for j in range(self.length):
                if(self.table[i][j] == 0 and j > 0):
                    temp = self.table[i][j]
                    self.table[i][j] = self.table[i][j-1]
                    self.table[i][j-1] = temp
                    return

    def solucao(self):
        cont = 0
        for i in range(self.length):
            for j in range(self.length):
                if(self.table[i][j] == cont):
                    cont+=1
                else:
                    return False
        return True

    def printTab(self):
        for i in range(self.length):
            for j in range(self.length):
                print("+------",end="")
            print("+\n",end="|")
            for j in range(self.length):
                num = " " if self.table[i][j] == 0 else self.table[i][j]
                print(f"{num:>4}",end="  |")
            print("")
        for j in range(self.length):
            print("+------",end="")
        print("+\n")
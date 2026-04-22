from dado import Dado

class Placar:

    def __init__(self):
        self.posicoes = 10
        self.taken = []
        self.placar = []
        for _ in range(self.posicoes):
            self.taken.append(False)
            self.placar.append(0)


    def add(self, posicao, dados):
        self.posicoes = 10
        if self.taken[posicao-1]:
            raise Exception("Posição ocupada")
        k = 0
        match(posicao):
            case 1:
                k = self.conta(1, dados)
            case 2:
                k = self.conta(2, dados)
            case 3:
                k = self.conta(3, dados)
            case 4:
                k = self.conta(4, dados)
            case 5:
                k = self.conta(5, dados)
            case 6:
                k = self.conta(6, dados)
            case 7:
                if(self.checkFull(dados)):
                    k = 15
            case 8:
                if(self.checkSeqMaior(dados)):
                    k = 20
            case 9:
                if(self.checkQuadra(dados)):
                    k = 30
            case 10:
                if(self.checkQuina(dados)):
                    k = 40
            case _:
                raise Exception("Valor dad posição ilegal")
        self.placar[posicao-1] = k
        self.taken[posicao-1] = True

    def getScore(self):
        t = 0
        for i in range(self.posicoes):
            if self.taken[i]:
                t+=self.placar[i]
        return t

    def conta(self, n, vet):
        cont = 0
        for i in vet:
            if i == n:
                cont += 1
        return cont*n

    def checkFull(self, dados):
        v = sorted(dados)
        return ((v[0] == v[1] == v[2] and v[3] == v[4]) or (v[0] == v[1] and v[2] == v[3] == v[4]))

    def checkQuadra(self, dados):
        v = sorted(dados)
        return ( v[0] == v[1] and v[1] == v[2] and v[2] == v[3]) or ( v[1] == v[2] and v[2] == v[3] and v[3] == v[4])

    def checkSeqMaior(self, dados):
        v = sorted(dados)
        return ( v[0] == v[1]-1 and v[1] == v[2]-1 and v[2] == v[3]-1 and 
				v[3] == v[4]-1)

    def checkQuina(self, dados):
        return ( dados[0] == dados[1] and dados[1] == dados[2] and dados[2] == dados[3] and dados[3] == dados[4])

    def printPlacar(self):
        s = ""
        for i in range(3):
            num = f" {self.placar[i]:<3}" if self.taken[i] else "(" + str(i+1) + ") "
            s +=   num + "   |   "
            num = f" {self.placar[i+6]:<3}" if self.taken[i+6] else "(" + str(i+7) + ") "
            s +=   num + "   |  "
            num = f" {self.placar[i+3]:<3}" if self.taken[i+3] else "(" + str(i+4) + ") "
            s+= num + "\n-------|----------|-------\n"
        num = f" {self.placar[9]:<3}" if self.taken[9] else "(10)"
        s += "       |   " + num + "   |"
        s += "\n       +----------+\n"
        return s
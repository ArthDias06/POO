import random

class Dado:
    def __init__(self, lados=6, seed=None):
        self.lados = lados
        self.r = random.Random(seed) if seed != None else random
        self.rolar()
    
    def rolar(self):
        self.atual = self.r.randint(1, self.lados)
        return self.atual
    
    def getLado(self):
        return self.atual

    def printDado(self):
        s010 = "|  *  |\n"
        s100 = "|*    |\n"
        s001 = "|    *|\n"
        s000 = "|     |\n"
        s101 = "|*   *|\n"
        s111 = "|* * *|\n"


        if(self.lados != 6):
            return "erro!"
        s = "+-----+\n"
        match self.getLado():
            case 1:
                s += s000 + s010 + s000
            case 2:
                s += s100 + s000 + s001
            case 3:
                s += s100 + s010 + s001
            case 4:
                s += s101 + s000 + s101
            case 5:
                s += s101 + s010 + s101
            case 6:
                s += s111 + s000 + s111
            
        s += "+-----+\n"
        return s
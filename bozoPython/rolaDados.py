import random
import dado as dd

class RolaDados:
    def __init__(self, n, seed=0):
        self.dados = []
        if seed != 0:
            rd = random.Random()
            rd.seed(seed)
        for _ in range(n):
            if seed == 0:
                d = dd.Dado()
            else:
                d = dd.Dado(6, rd.randint(1, 10000))
            self.dados.append(d)
    
    def rolar(self, quais=None, s=None):
        if s != None:
            s = s.split()
            quais = [False] * len(self.dados)
            for num in s:
                try:
                    indice = int(num) - 1  # user types 1-based positions
                    if 0 <= indice and indice < len(self.dados):
                        quais[indice] = True
                except ValueError:
                    pass
        
        if quais != None:
            i = 0
            r = []
            for a in quais:
                if a:
                    self.dados[i].rolar()
                r.append(self.dados[i].getLado())
                i += 1
            return r
                
        r = []
        for i in range(len(self.dados)):
            r.append(self.dados[i].rolar())
        return r
    
    def printar(self):
        fim = ""
        for i in range(5):
            base = i*8
            s=""
            for d in self.dados:
                p = d.printDado()
                s += p[base:base+7]+"    "    
            fim += s +"\n"
        return fim
from rolaDados import RolaDados
from placar import Placar

if __name__ == "__main__":
    print("Digite a semente (zero para aleatório): ", end="")
    seed = int(input())
    rd = RolaDados(5, seed)
    pl = Placar()
    print(pl.printPlacar())
    for rodada in range(10):
        print("****** Rodada " + str(rodada+1))
        print("Pressione ENTER para lançar os dados")
        input()
        rd.rolar()
        print("1          2          3          4          5")
        print(rd.printar())

        print("Digite os números dos dados que quiser TROCAR. Separados por espaços.")
        muda = input()
        rd.rolar(s=muda)
        print("1          2          3          4          5")
        print(rd.printar())

        print("Digite os números dos dados que quiser TROCAR. Separados por espaços.")
        muda = input()
        values = rd.rolar(s=muda)
        print("1          2          3          4          5")
        print(rd.printar())


        print("\n\n")
        print(pl.printPlacar())
        pos = 0
        while pos <= 0:
            try:
                print("Escolha a posição que quer ocupar com essa jogada ===> ", end="")
                pos = int(input())
                if pos > 10 or pos <= 0:
                    pos = 0
                pl.add(pos, values)
            except Exception:
                pos = 0
            if pos == 0:
                print("Valor inválido. Posição ocupada ou inexistente.")
        print("\n\n")
        print(pl.printPlacar())
    print("***********************************")
    print("***")
    print("*** Seu escore final foi: " + str(pl.getScore()))
    print("***")
    print("***********************************")
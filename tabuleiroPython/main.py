from tabuleiro import Tabuleiro

numbers = input().split()
tabuleiro = Tabuleiro(numbers)
moves = input()
tabuleiro.printTab()
for i in moves:
    match i:
        case 'u':
            tabuleiro.up()
        case 'd':
            tabuleiro.down()
        case 'l':
            tabuleiro.left()
        case 'r':
            tabuleiro.right()
    tabuleiro.printTab()
print(f"Posicao final: {tabuleiro.solucao()}")
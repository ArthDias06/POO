CLASSES = Main.java Tabuleiro.java

all: 
	javac $(CLASSES)

run:
	java Main < in.txt
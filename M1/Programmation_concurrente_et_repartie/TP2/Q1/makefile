COMPIL = gcc
FLAGS = 
SOURCES = Client MainCalculatrice AddCalculatrice SubCalculatrice MulCalculatrice DivCalculatrice

all: clean $(SOURCES)

Client:
	$(COMPIL) $@.c -o $@.out $(FLAGS)

MainCalculatrice:
	$(COMPIL) $@.c -o $@.out $(FLAGS)

AddCalculatrice:
	$(COMPIL) $@.c -o $@.out $(FLAGS)

SubCalculatrice:
	$(COMPIL) $@.c -o $@.out $(FLAGS)

MulCalculatrice:
	$(COMPIL) $@.c -o $@.out $(FLAGS)

DivCalculatrice:
	$(COMPIL) $@.c -o $@.out $(FLAGS)

clean:
	rm -f *.out
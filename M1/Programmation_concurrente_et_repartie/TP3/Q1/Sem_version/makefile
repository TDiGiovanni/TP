COMPIL = gcc
FLAGS = 
SOURCES = Setup BorneIn BorneOut

all: clean $(SOURCES)

Setup:
	$(COMPIL) $@.c -o $@.out $(FLAGS)

BorneIn:
	$(COMPIL) $@.c -o $@.out $(FLAGS)

BorneOut:
	$(COMPIL) $@.c -o $@.out $(FLAGS)

clean:
	rm -f *.out
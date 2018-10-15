COMPIL = gcc
FLAGS = 
SOURCES = Client MainCalculatrice AddCalculatrice SubCalculatrice MulCalculatrice DivCalculatrice

all: clean $(SOURCES)

Client:
	$(COMPIL) $@.c -o $@ $(FLAGS)

MainCalculatrice:
	$(COMPIL) $@.c -o $@ $(FLAGS)

AddCalculatrice:
	$(COMPIL) $@.c -o $@ $(FLAGS)

SubCalculatrice:
	$(COMPIL) $@.c -o $@ $(FLAGS)

MulCalculatrice:
	$(COMPIL) $@.c -o $@ $(FLAGS)

DivCalculatrice:
	$(COMPIL) $@.c -o $@ $(FLAGS)

clean:
	rm -f $(SOURCES)
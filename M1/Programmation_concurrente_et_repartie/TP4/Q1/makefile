COMPIL = gcc
FLAGS = 
SOURCES = Client Server

all: clean $(SOURCES)

Client:
	$(COMPIL) $@.c -o $@.out $(FLAGS)

Server:
	$(COMPIL) $@.c -o $@.out $(FLAGS)

clean:
	rm -f *.out
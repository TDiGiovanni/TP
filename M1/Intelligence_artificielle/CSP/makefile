COMPIL = gcc
FLAGS = 
SOURCES = URBCSP
PARAMETERS = 50 20 300 100 #nbVariables tailleDomaine nbContraintes nbTuples

all: clean $(SOURCES)

URBCSP:
	$(COMPIL) $@.c -o $@.out $(FLAGS)
	./$@.out $(PARAMETERS) > CSP.txt

clean:
	rm -f *.out
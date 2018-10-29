COMPIL = gcc
FLAGS = 
SOURCES = URBCSP
PARAMETERS = 50 20 300 100 #nbVariables tailleDomaine nbConstraints nbTuples

all: $(SOURCES) clean

URBCSP:
	$(COMPIL) $@.c -o $@.out $(FLAGS)
	./$@.out $(PARAMETERS) > CSP.txt

clean:
	rm -f *.out
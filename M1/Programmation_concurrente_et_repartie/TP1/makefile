COMPIL = gcc
FLAGS = -lpthread
SOURCES = Q1 Q2 Q3 Q4

all: clean $(SOURCES)

Q1:
	$(COMPIL) Q1.c calculC.o -o $@ $(FLAGS)

Q2:
	$(COMPIL) Q2.c calculC.o -o $@ $(FLAGS)

Q3:
	$(COMPIL) Q3.c calculC.o -o $@ $(FLAGS)

Q4:
	$(COMPIL) Q4.c calculC.o -o $@ $(FLAGS)

clean:
	rm -f $(SOURCES)
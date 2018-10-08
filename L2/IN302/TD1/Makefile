CC = g++
PROG_NAME = exemple
SOURCE = TD1-1.cpp TD1-2.cpp TD1-3.cpp
MSQ = @
RM = $(MSQ)rm -f

all : $(PROG_NAME)

TD1-1.o : TD1-1.cpp
	$(CC) -c TD1-1.cpp

TD1-2.o : TD1-2.cpp
	$(CC) -c TD1-2.cpp

TD1-3.o : TD1-3.cpp
	$(CC) -c TD1-3.cpp

$(PROG_NAME) : $(SOURCE:.cpp=.o)
	$(CC) $(SOURCE:.cpp=.o) -o $(PROG_NAME)

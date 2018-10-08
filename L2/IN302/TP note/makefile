CXX= g++
FLAGS= -Wall
NAME= abr

all: $(NAME) main

$(NAME): $(NAME).h $(NAME).cpp
	$(CXX) $(FLAGS) $(NAME).cpp -c

main: main.cpp
	$(CXX) $(FLAGS) $(NAME).o main.cpp -o main

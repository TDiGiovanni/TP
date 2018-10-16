CXX= g++
FLAGS= -Wall
NAME=Cellule

all: $(NAME) Main

$(NAME): $(NAME).h $(NAME).cpp
	$(CXX) $(FLAGS) $(NAME).cpp -c

Main: Main.cpp
	$(CXX) $(FLAGS) $(NAME).o Main.cpp -o Main

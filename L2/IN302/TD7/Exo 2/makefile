CXX= g++
FLAGS= -Wall
NAME= exo2

all: $(NAME) Main

$(NAME): $(NAME).h $(NAME).cpp
	$(CXX) $(FLAGS) $(NAME).cpp -c

main: main.cpp
	$(CXX) $(FLAGS) $(NAME).o main.cpp -o main

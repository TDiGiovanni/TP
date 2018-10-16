CXX= g++
FLAGS= -Wall
NAME= window

all: $(NAME) test_piece

$(NAME): $(NAME).h $(NAME).cpp
	$(CXX) $(FLAGS) $(NAME).cpp -c

test_piece: test_piece.cpp
	$(CXX) $(FLAGS) $(NAME).o test_piece.cpp -o test_piece

CC = gcc
FLAGS = -Wall

# Liste des fichiers sources
SRC0 = client.c
SRC1 = serveur.c

# Exécutables à générer
default: client

# Règles pour générer les exécutables
%.o: %.c
	$(CC) $(FLAGS) -Iinclude -c $< -o $@

client: $(SRC0:%.c=%.o)
	$(CC) -o $@ $^

serveur: $(SRC1:%.c=%.o)
	$(CC) -o $@ $^

clean:
	rm -f $(BIN) *.o *~

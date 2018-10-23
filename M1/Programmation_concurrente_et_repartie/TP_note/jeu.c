#include <stdlib.h>
#include <stdio.h>
#include <errno.h>
#include <pthread.h>
#include "etape.h"

struct sNverrou{
  int currentThreadsCritiques, nbMaxThreadsCritiques;
  pthread_mutex_t lock;
  pthread_cond_t available;
};

typedef struct sNverrou n_verrou;

struct sParams {
  n_verrou nvTab[3];
  int indice;
};

typedef struct sParams params;

// LE VERROU SUIVANT EST UTILISE UNIQUEMENT POUR LA SORTIE STANDARD. 
// NE PAS LE REUTILISER POUR AUTRE FONCTION QUE L'AFFICHAGE. VOIR UTILISATION PLUS LOIN.
pthread_mutex_t vStdOut= PTHREAD_MUTEX_INITIALIZER;

// initialisation des champs de la structure n_verrou
int n_verrou_init(n_verrou * v, int k){
  v->currentThreadsCritiques = 0;
  v->nbMaxThreadsCritiques = k;

  return 0;
}

// bloque si le nombre maximum de threads autorisés à passer en section
// critique est atteint, sinon, permet l'accès à la section critique
int n_verrou_lock(n_verrou * v){
  if (pthread_mutex_lock(&(v->lock)) != 0)
    return -1;

  v->currentThreadsCritiques++;
  return 0;
}

// décrémente le nombre de thread en section critique et reveille
// éventuellement un thread en attente d'entrer en section critique
int n_verrou_unlock(n_verrou * v){
  v->currentThreadsCritiques--;

  if (pthread_cond_broadcast(&(v->available)) != 0)
    return -1;

  return 0;
}

int n_verrou_destroy(n_verrou * v){
  if (pthread_cond_destroy(&(v->available)) != 0 || pthread_mutex_destroy(&(v->lock)))
    return -1;

  return 0;
}


// Fonction exécutée par chaque thread (joueur). NE PAS MODIFIER CETTE FONCTION !
void * jouer(void * p){

  params * param = (params*)p;
  
  // LE VERROU vStdOut EST UTILISE UNIQUEMENT POUR L'AFFICHAGE (ACCES A LA SORTIE STANDARD).
  pthread_mutex_lock(&vStdOut); printf("Joueur %d: je suis pret\n", param -> indice);  pthread_mutex_unlock(&vStdOut);
  
  // Etape 1 :
  
  // je demande à passer : je passe s'il y a moins de
  // maxNbJoueursEtape1 joueurs présents dans cette étape, sinon
  // j'attends que ça soit le cas.
  while (param->nvTab[0].currentThreadsCritiques == param->nvTab[0].nbMaxThreadsCritiques)
    pthread_cond_wait(&(param->nvTab[0].available), &(param->nvTab[0].lock));

  if(n_verrou_lock(&(param -> nvTab[0])) != 0) {
    perror("probleme n_verrou lock");
    free(param);
    pthread_exit(NULL);
  }
  
  // rappel : vStdOut n'est utilisé que pour les affichages et n'affecte en rien le déroulement du jeu.
  pthread_mutex_lock(&vStdOut); printf("Joueur %d: debut etape 1\n", param -> indice); pthread_mutex_unlock(&vStdOut);
  
  etape();
  
  pthread_mutex_lock(&vStdOut); printf("Joueur %d: fin etape 1\n", param -> indice); pthread_mutex_unlock(&vStdOut);
  
  // je viens de finir une étape, je dois le signaler.
  if(n_verrou_unlock(&(param->nvTab[0])) != 0) {
    perror("probleme n_verrou unlock");
    free(param);
    pthread_exit(NULL); 
  }

  
  // Etape 2 :
  
  // je demande à passer : je passe s'il y a moins de
  // maxNbJoueursEtape2 joueurs présents dans cette étape, sinon
  // j'attends que ça soit le cas.
  while (param->nvTab[1].currentThreadsCritiques == param->nvTab[1].nbMaxThreadsCritiques)
    pthread_cond_wait(&(param->nvTab[1].available), &(param->nvTab[1].lock));

  if(n_verrou_lock(&(param->nvTab[1]))!= 0) {
    perror("probleme n_verrou lock");
    free(param);
    pthread_exit(NULL);
  }

  pthread_mutex_lock(&vStdOut); printf("Joueur %d: debut etape 2\n", param -> indice); pthread_mutex_unlock(&vStdOut);
  
  etape();
  
  pthread_mutex_lock(&vStdOut); printf("Joueur %d: fin etape 2\n", param -> indice); pthread_mutex_unlock(&vStdOut);
  
  // je viens de finir une étape, je dois le signaler.
  if(n_verrou_unlock(&(param->nvTab[1])) != 0) {
    perror("probleme n_verrou unlock");
    free(param);
    pthread_exit(NULL); 
  }
  
  // Etape 3 :
  
  // je demande à passer : je passe s'il y a moins de
  // maxNbJoueursEtape1 joueurs présents dans cette étape, sinon
  // j'attends que ça soit le cas.
  while (param->nvTab[2].currentThreadsCritiques == param->nvTab[2].nbMaxThreadsCritiques)
    pthread_cond_wait(&(param->nvTab[2].available), &(param->nvTab[2].lock));

  if(n_verrou_lock(&(param->nvTab[2])) != 0) {
    perror("probleme n_verrou lock");
    free(param);
    pthread_exit(NULL);
  }
  
  pthread_mutex_lock(&vStdOut); printf("Joueur %d: debut etape 3\n", param -> indice);; pthread_mutex_unlock(&vStdOut);

  etape();
  
  pthread_mutex_lock(&vStdOut); printf("Joueur %d: fin etape 3, je termine\n", param -> indice); pthread_mutex_unlock(&vStdOut);
  
  // je viens de finir une étape, je dois le signaler.
  if(n_verrou_unlock(&(param->nvTab[2])) != 0) {
    perror("probleme n_verrou unlock");
    free(param);
    pthread_exit(NULL); 
  }

  free(param);
  pthread_exit(NULL);
}

int main(int argc, char * argv[]){
  
  if(argc != 5){
    printf ("lancement : ./bin/jeu NbJoueurs maxNbJoueursEtape1 maxNbJoueursEtape2 maxNbJoueursEtape3 \n");
    exit(1);
  }
  
  srand(time(0)); // garder cette ligne sans la modifier.

  int nbJoueurs = atoi(argv[1]);
  int maxNbJoueursEtape1 = atoi(argv[2]);
  int maxNbJoueursEtape2 = atoi(argv[3]);
  int maxNbJoueursEtape3 = atoi(argv[4]);

  n_verrou v1, v2, v3;
  if (n_verrou_init(&v1,maxNbJoueursEtape1) != 0) {
      perror("Error thread creation");
    return 1;
  }
  if (n_verrou_init(&v2,maxNbJoueursEtape2) != 0) {
      perror("Error thread creation");
    return 1;
  }
  if (n_verrou_init(&v3,maxNbJoueursEtape3) != 0) {
      perror("Error thread creation");
    return 1;
  }

  pthread_t idThread[nbJoueurs]; 
  params p[nbJoueurs];

  for (int i = 0; i < nbJoueurs; i++) {
    p[i].nvTab[0] = v1;
    p[i].nvTab[1] = v2;
    p[i].nvTab[2] = v3;
    p[i].indice = i+1;

    if (pthread_create(&idThread[i], NULL, jouer, &p[i]) != 0) {
      perror("Error thread creation");
      return 1;
    }
  }

  for (int i = 0; i < nbJoueurs; i++)
    pthread_join(idThread[i],NULL);

  n_verrou_destroy(&v1);
  n_verrou_destroy(&v2);
  n_verrou_destroy(&v3);

  return 0;
}

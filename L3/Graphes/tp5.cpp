#include <cstdlib>
#include <iostream>
#include <vector>
#include "villes.cpp" // Importe les villes, leurs positions et les longueurs des arcs

using namespace std;

void floydWarshall(int longueur[][N],int dist[][N],int chemin[][N]) {
  // Initialisation de dist et chemin
  for (int i=0; i<N; i++) {
    for (int j=0; j<N; j++) {
      if (longueur[i][j]==INF) { // Si l'arc n'existe pas
	dist[i][j]=INF;
	chemin[i][j]=-1;
      }
      else {
	dist[i][j]=longueur[i][j];
	chemin[i][j]=j;
      }
    }
  }

  // Recherche de raccourcis
  for (int k=0; k<N; k++) {
    for (int i=0; i<N; i++) {
      for (int j=0; j<N; j++) {
	if (dist[i][j] > dist[i][k]+dist[k][j]) { // Si k est un raccourci pour aller de i à j
	  dist[i][j]=dist[i][k]+dist[k][j];
	  chemin[i][j]=chemin[i][k];
	}
      }
    }
  }

  for (int i=0; i<N; i++)
    if (dist[i][i]<0) {
      cout<<"Il existe un cycle orienté de poids <0. \n";
      return;
    }
}

void itineraire(int chemin[][N]) {
  int deb, fin;
  do {
  cout<<"Entrez le départ (sup. ou égal à 0) : \n";
  cin>>deb;
  cout<<"Entrez la destination (inf. ou égal à 40) : \n";
  cin>>fin;
  } while (deb>=N || fin>=N);
  cout<<"Vous avez choisi "<<villes[deb]<<" et "<<villes[fin]<<". \n";

  int pcc[N]= {};
  pcc[0]=deb;

  int i= 1;
  int cur= deb;
  cout<<"Le plus court chemin de "<<villes[deb]<<" à "<<villes[fin]<<" est : \n";
  cout<<villes[pcc[0]]<<" ("<<pcc[0]<<") \n";
  while (i<N && cur!=fin) {
    pcc[i]=chemin[cur][fin];
    cur=chemin[cur][fin];
    cout<<villes[pcc[i]]<<" ("<<pcc[i]<<") \n";
    i++;
  }
}

// Construit le tableau arc à partir de longueur
void construireArc(int longueur[][N], int arc[][N]) {
    for (int i=0; i<N; i++) {
        for (int j=0; j<N; j++) {
            if (longueur[i][j]!=INF)
                arc[i][j]=1;
            else
                arc[i][j]=0;
        }
    }
}

void fermetureTransitive(int arc[][N], int fermeture[][N]) {
  for (int i=0; i<N; i++)
    for (int j=0; j<N; j++)
      if (arc[i][j]==1)
            fermeture[i][j]=1;

  for (int k=0; k<N; k++) {
    for (int i=0; i<N; i++) {
      for (int j=0; j<N; j++) {
        if (fermeture[i][k]==1 && fermeture[k][j]==1) { // Si k est un raccourci pour aller de i à j
            fermeture[i][j]=1;
        }
      }
    }
  }
}

void compFortConnexe(int fermeture[][N]) {
    int comp[N]= {};

    // Initialisation
    for (int i=0; i<N; i++)
        comp[i]=i;

    // Recherche des composantes
    for (int i=0; i<N; i++)
        for (int j=0; j<N; j++)
            if ((comp[i] != comp[j])    // Si i et j ne sont pas dans la même composante
                && fermeture[i][j]==1)  // Mais qu'il existe un chemin entre eux
                for (int k=0; k<N; k++)
                    if (comp[k]==comp[j])
                        comp[k]=i;

    // Affichage
    vector<int> compAffichee;

    cout<<"Les composantes fortement connexes sont : \n";

    for (int i=0; i<N; i++) {
        for (int j=0; j<N; j++) {
            if (comp[j]==i)
                compAffichee.push_back(j);
        }

        if (!compAffichee.empty()) {
            cout<<"{";
            for (unsigned int i=0; i<compAffichee.size(); i++)
                cout<<i<<",";
            cout<<"} \n";
            compAffichee.clear();
        }
    }
}

// Affichage des tableaux distance et chemin
void affichage(int dist[][N],int chemin[][N], int arc[][N], int fermeture[][N]) {

  for (int i=0; i<N; i++)
    for (int j=0; j<N; j++)
      cout<<"dist["<<i<<"]["<<j<<"]= "<<dist[i][j]<<endl;

  for (int i=0; i<N; i++)
    for (int j=0; j<N; j++)
    cout<<"chemin["<<i<<"]["<<j<<"]= "<<chemin[i][j]<<endl;

  for (int i=0; i<N; i++)
    for (int j=0; j<N; j++)
        if (arc[i][j]!=0)
            cout<<"arc["<<i<<"]["<<j<<"]= "<<arc[i][j]<<endl;

  for (int i=0; i<N; i++)
    for (int j=0; j<N; j++)
        if (fermeture[i][j]!=0)
            cout<<"fermeture["<<i<<"]["<<j<<"]= "<<fermeture[i][j]<<endl;
}

int main(int argc, char** argv) {
  int dist[N][N]= {}; // Le tableau des distances
  int chemin[N][N]= {}; // Le tableau de la premiere étape du chemin de i à j
  int arc[N][N]= {}; // La matrice d’adjacences du graphe oriente D
  int fermeture[N][N]= {}; // La matrice de la fermeture transitive de D

  initialisation();
  floydWarshall(longueur,dist,chemin);
  itineraire(chemin);
  construireArc(longueur,arc);
  fermetureTransitive(arc,fermeture);
  //compFortConnexe(fermeture);
  //affichage(dist,chemin,arc,fermeture);

  return EXIT_SUCCESS;
}

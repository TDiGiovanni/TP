#include <cstdlib>
#include <iostream>
#include <vector>
#include <ctime>

using namespace std;

void grapheRandom(int n, int m, int edge[][2]) {
  srand(time(NULL));

  for (int i= 0; i< m; i++) {
    edge[i][0]= rand()%n;
    edge[i][1]= rand()%n;
  }
}

void afficheEdge(int m, int edge[][2]) {
  cout << "{";
  for (int i= 0; i<m; i++) {
    cout << "{" << edge[i][0] << "," << edge[i][1] << "}";
  }
  cout << "} \n";
}

void composantes(int n, int m, int edge[][2], int comp[]) {
  /* Version non optimisée
     for (int i= 0; i<n; i++)
     comp[i]= i;

  for (int i= 0; i<m; i++) {
    if (comp[edge[i][0]] != comp[edge[i][1]]) {
      for (int j=0; j<n; j++)
	if (comp[j] == comp[edge[i][0]])
	  comp[j] = comp[edge[i][1]];
    }
  }
    */

  vector<int> contenuComp[n]; // contenuComp[i] est un vecteur contenant tous les sommets dans la composante i (i étant le premier sommet à qui on a associé d'autres sommets)

  for (int i= 0; i<n; i++) {
    comp[i]= i;
    contenuComp[i].push_back(i);
  }

  // Pour toutes les arêtes ij
  for (int i= 0; i<m; i++) {
    // Si la composante de i est différent de celle de j
    if (comp[edge[i][0]] != comp[edge[i][1]]) {
            int compI= comp[edge[i][0]];
            int compJ= comp[edge[i][1]];

            // Si la composante de j est plus petite que celle de i
            if (contenuComp[compI].size() > contenuComp[compJ].size()) {
                // Pour tous les sommets k dans la composante de i
                for (int k=0; k<contenuComp[compI].size(); k++) {
                    comp[contenuComp[compI][k]]=compJ;                      // On change la composante de k pour qu'elle devienne celle de j
                    contenuComp[compJ].push_back(contenuComp[compI][k]);    // On met à jour la composante de j pour y ajouter tous les sommets de la composante de i
                    contenuComp[compI].clear();                             // On vide contenuComp[compI], car tout fait maintenant parti de contenu[compJ]
                }
            }
            // Si la composante de i est plus petite que celle de j
            else {
                // Pour tous les sommets k dans la composante de j
                for (int k=0; k<contenuComp[compJ].size(); k++) {
                    comp[contenuComp[compJ][k]]=compI;                      // On change la composante de k pour qu'elle devienne celle de i
                    contenuComp[compI].push_back(contenuComp[compJ][k]);    // On met à jour la composante de i pour y ajouter tous les sommets de la composante de j
                    contenuComp[compJ].clear();                             // On vide contenuComp[compJ], car tout fait maintenant parti de contenu[compI]
                }
            }
        }
    }
}

void afficheComp(int n, int comp[]) {
  for (int i = 0; i<n; i++) {
    cout << "Comp["<<i<<"]= "<<comp[i]<<endl;
  }
}

void ecritureTailles(int n, int m, int comp[]) {
  int Comp1[n] = {}; // Comp1[i] donne le nombre de sommets dans la composante de i
  int Comp2[n+1] = {}; // Comp2[i] donne le nombre de composantes de taille i (tableau de taille n+1, car Comp2[n] n'existe pas sinon)

  for (int i=0; i<n; i++) {
      Comp1[comp[i]]++;
  }

  for (int i=0; i<n; i++) {
    Comp2[Comp1[i]]++;
  }

  cout << "Il y a "<< Comp2[1] <<" points isoles. \n";
  for (int i=2; i<=n; i++) {
    if (Comp2[i] != 0)
      cout << "Il y a "<< Comp2[i] <<" composantes de taille "<< i <<". \n";
  }
}

int main() {
  int n; // Nombre de sommets
  int m; // Nombre d'aretes
  cout << "Entrer le nombre de sommets: ";
  cin >> n;
  cout << "Entrer le nombre d'aretes: ";
  cin >> m;
  int edge[m][2]; // Tableau des arêtes
  int comp[n]; // comp[i] est le numéro de la composante contenant i

  grapheRandom(n,m,edge);
  afficheEdge(m,edge);

  composantes(n,m,edge,comp);
  afficheComp(n,comp);

  ecritureTailles(n,m,comp);

  return EXIT_SUCCESS;
}

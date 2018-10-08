#include <cstdlib>
#include <iostream>
#include <vector>
#include <fstream>

using namespace std;

void voisinsRandom(int n, int m, vector<int> voisins[]) {
  bool dejaV= false;
  int x, y;

  for (int i=0; i<m; i++) {
    do {
      dejaV=false;
      x= rand()%n;
      do y= rand()%n; while (y==x);

      for (int j=0; j<voisins[x].size(); j++)
	if (voisins[x][j]==y)
	  dejaV= true;
    } while (dejaV==true);
    voisins[x].push_back(y);
    voisins[y].push_back(x);
  }
}

void parcoursLargeur(int n, vector<int> voisins[], int niveau[], int ordre[], int pere[]) {
  int dejaV[n]= {};
  for (int i=0; i<n; i++)
    dejaV[i]=0;

  int r=0;
  dejaV[r]=1;
  ordre[r]=1;
  pere[r]=r;
  niveau[r]=0;

  vector<int> file;
  file.push_back(r);

  int o=2;

  while (file.size()!=0) {
    int x= file.front();
    file.erase(file.begin());

    for (int i= 0; i<voisins[x].size(); i++) {
      int v= voisins[x][i];
      if (dejaV[v]==0) {
	dejaV[v]=1;
	file.push_back(v);
	ordre[v]=o;
	o++;
	pere[v]=x;
	niveau[v]=niveau[x]+1;
      }
    }
  }

      // On recherche les sommets qui ne sont pas dans la composante principale
  for (int i=0; i<n; i++) {
    if (voisins[i].size()==0) {
      ordre[i]=-1;
      pere[i]=-1;
      niveau[i]=-1;
    }
  }
}

void parcoursProfondeur(int n, vector<int> voisins[], int niveau[], int debut[], int fin[], int pere[]) {
  int dejaV[n]= {};
  for (int i=0; i<n; i++)
    dejaV[i]=0;

  int r=0;
  dejaV[r]=1;
  pere[r]=r;
  debut[r]=1;
  niveau[r]=0;

  vector<int> pile;
  pile.push_back(r);

  int t=2;

  while (!pile.empty()) {
    int x= pile.back();

    if (voisins[x].size()==0) {
      pile.pop_back();
      fin[x]=t;
      t++;
    }
    else {
      int v= voisins[x].back();
      voisins[x].pop_back();
      if (dejaV[v]==0) {
	dejaV[v]=1;
	pile.push_back(v);
	debut[v]=t;
	t++;
	pere[v]=x;
	niveau[v]=niveau[x]+1;
      }
    }
  }
      // On recherche les sommets qui ne sont pas dans la composante principale
    for (int i=0; i<n; i++) {
    if (dejaV[i]==0) {
      pere[i]=-1;
      niveau[i]=-1;
      debut[i]=-1;
      fin[i]=-1;
    }
  }
}

void ecritureNiveaux(int n, int niveau[]) {
  int niv[n]= {};
  int k= 0;

  for (int i=0; i<n; i++) {
    if (niveau[i]!=-1)
      niv[niveau[i]]++;
    else k++;
  }

  for (int i=0; i<n; i++)
    if (niv[i]!=0)
      cout << "Il y a "<< niv[i] <<" sommets au niveau "<< i <<". \n";
  cout << "Il y a "<< k <<" sommets qui ne sont pas dans la composante de 0. \n";
}

int sommeNiveaux(int n, int niveau[]) {
  int k=0;
  
  for (int i=0; i<n; i++) {
    k+=niveau[i];
  }

  return k;
}

int main() {
  int n, m; // Le nombre de sommets et d'aretes
  cout << "Entrez le nombre de sommets : ";
  cin >> n;
  cout << "Entrez le nombre d'aretes : ";
  cin >> m;

  vector<int> voisins[n]; // Les listes des voisins

  int pereL[n]={}; // L'arbre en largeur
  int ordre[n]={}; // L'ordre de parcours
  int niveauL[n]={}; // Le niveau du point
  int sommeL; // Somme des niveaux pour le parcours en largeur

  int pereP[n]={}; // L'arbre en profondeur
  int debut[n]={};
  int fin[n]={};
  int niveauP[n]={}; // Le niveau du point
  int sommeP; // Somme des niveaux pour le parcours en profondeur

  // Initialise les voisins
  voisinsRandom(n,m,voisins);

  cout<<"Liste des voisins : \n";
  for (int i= 0; i<n; i++) {
    cout<<i<<" : ";
    for (int j= 0; j<voisins[i].size(); j++)
      cout<<voisins[i][j]<<" - ";
    cout<<"\n";
  }
  cout<<"\n";

  // Parcours en largeur
  parcoursLargeur(n,voisins,niveauL,ordre,pereL);
  /*
  cout<<"Parcours en largeur : \n";
  for (int i= 0; i<n; i++) {
    cout<<i<<" : père="<<pereL[i]<<", ordre="<<ordre[i]<<", niveau="<<niveauL[i]<<". \n";
  }
  cout<<"\n";
  */
  ecritureNiveaux(n,niveauL);
  sommeL= sommeNiveaux(n,niveauL);
  cout<<"La somme des niveaux du parcours en largeur est "<<sommeL<<endl;
  cout<<"\n";

  // Parcours en profondeur
  parcoursProfondeur(n,voisins,niveauP,debut,fin,pereP);
  /*
  cout<<"Parcours en profondeur : \n";
  for (int i= 0; i<n; i++) {
    cout<<i<<" : père="<<pereP[i]<<", début="<<debut[i]<<", fin="<<fin[i]<<". \n";
  }
  cout<<"\n";
  */
  ecritureNiveaux(n,niveauP);
  sommeP= sommeNiveaux(n,niveauP);
  cout<<"La somme des niveaux du parcours en profondeur est "<<sommeP<<endl;
  

  return EXIT_SUCCESS;
}

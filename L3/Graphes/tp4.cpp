#include <cstdlib>
#include <iostream>
#include <vector>
#include <fstream>
#include <cmath>
#include <climits>
#include <ctime>

using namespace std;

const int N=1400;
const int M=(N*(N-1))/2;

typedef struct coord {
  int abs;
  int ord;
} coord;

void pointsRandom(int n, coord point[]) {
  srand(time(NULL));

  for (int i= 0; i< n; i++) {
    point[i].abs= rand()%612;
    point[i].ord= rand()%792;
  }
}

void points60(int n, coord point[]) {
  int k=0;
  
  for (int i= 0; i< 10; i++) {
    for (int j= 0; j< 10; j++) {
      point[k].abs= 60*i;
      point[k].ord= 60*j;
      k++;
    }
  }
}

float distanceEuc(coord p1, coord p2) {
  return sqrt(pow(p1.abs-p2.abs,2)+pow(p1.ord-p2.ord,2));
}

float distanceExo5(coord p1, coord p2) {
  return pow(abs(p2.abs-p1.abs)+abs(p2.ord-p1.ord),2);
}

void creeVoisins(int n, float dmax, coord point[], vector<int> voisins[], int &m) {
  for (int i=0; i<n; i++) {
    for (int j=i+1; j<n; j++) {
      int i1= point[i].abs/60;
      int j1= point[i].ord/60;
      int i2= point[j].abs/60;
      int j2= point[j].ord/60;;
      if ((j2==j1+1 && i2==i1)
	  || (i2==i1+1 && j2==j1)
	  || (j2==j1+1 && i2==i1+1)) {
      //if (distanceEuc(point[i],point[j])<=dmax) {
	voisins[i].push_back(j);
	voisins[j].push_back(i);
	m++;
      }
    }
  }
}

void affichageGraphe(int n, coord point[], vector<int> voisins[]) {
  ofstream output;

  output.open("DijkstraAvant.ps",ios::out);
  output << "%!PS-Adobe-3.0" << endl;
  output << "%%BoundingBox: 0 0 612 792" << endl;
  output << endl;

  for(int i=0;i<n;i++) {
    output << point[i].abs << " " << point[i].ord << " 3 0 360 arc" <<endl;
    output << "0 setgray" <<endl;
    output << "fill" <<endl;
    output << "stroke"<<endl;
    output << endl;
  }
  output << endl;

  for(int i=0; i<n; i++) {
    if (voisins[i].size()!=0) {
      for (int j=0; j<voisins[i].size(); j++) {
	output << point[i].abs << " " << point[i].ord
	       << " moveto" << endl;
	output << point[voisins[i][j]].abs << " " << point[voisins[i][j]].ord
	       << " lineto" << endl;
	output << "stroke" << endl;
	output << endl;
      }
    }
  }
  output << "showpage";
  output << endl;
}

bool existe(int n, int distance[], bool dejaV[], int &x) {
  int dmin= INT_MAX;
  bool ex= false;

  for (int i=0; i<n; i++)
    if (dejaV[i]==false) {
      if (distance[i]<=dmin) {
	x=i;
	dmin=distance[i];
      }

      ex=true;
    }

  return ex;
}

void dijkstra(int n, vector<int> voisins[], coord point[], int pere[]) {
  bool dejaV[n]= {};
  int distance[n]= {};

  for (int i=0; i<n; i++) {
    dejaV[i]=false;
    distance[i]= INT_MAX;
    pere[i]=-1;
  }

  int racine= 0;
  pere[racine]=racine;
  distance[racine]=0;

  int i;
  while (existe(n,distance,dejaV,i)) {
    dejaV[i]=true;

    for (int v=0; v<voisins[i].size(); v++) {
      if (dejaV[voisins[i][v]]==false
	  //&& distance[voisins[i][v]] > distance[i]+distanceEuc(point[i],point[voisins[i][v]])) {
	  && distance[voisins[i][v]] > distance[i]+distanceExo5(point[i],point[voisins[i][v]])) {
	//distance[voisins[i][v]]=distance[i]+distanceEuc(point[i],point[voisins[i][v]]);
	distance[voisins[i][v]]=distance[i]+distanceExo5(point[i],point[voisins[i][v]]);
	pere[voisins[i][v]]=i;
      }
    }
  }

  cout<<"Le sommet le plus éloigné de la racine est ";
  int somMax;
  int distMax= 0;
  for (int i=0; i<n; i++) {
    if (distance[i]>distMax) {
      somMax=i;
      distMax= distance[i];
    }
  }
  cout<<somMax<<endl;
}

int construireArbre(int n, int arbre[][2], int pere[]){
  int k=0;

  for (int i=0; i<n; i++) {
    arbre[k][0]=i;
    arbre[k][1]=pere[i];
    k++;
  }

  return k;
}

void affichageGrapheDijkstra(int n, int m, coord point[], int arbre[][2]) {
  ofstream output;

  output.open("DijkstraApres.ps",ios::out);
  output << "%!PS-Adobe-3.0" << endl;
  output << "%%BoundingBox: 0 0 612 792" << endl;
  output << endl;

  for(int i=0; i<n; i++) {
    if (arbre[i][1] != -1) {
      output << point[i].abs << " " << point[i].ord << " 3 0 360 arc" <<endl;
      output << "0 setgray" <<endl;
      output << "fill" <<endl;
      output << "stroke"<<endl;
      output << endl;
    }
  }
  output << endl;

  for(int i=0; i<n; i++) {
    if (arbre[i][1] != -1) {
      output << point[arbre[i][0]].abs << " " << point[arbre[i][0]].ord
	     << " moveto" << endl;
      output << point[arbre[i][1]].abs << " " << point[arbre[i][1]].ord
	     << " lineto" << endl;
      output << "stroke" << endl;
      output << endl;
    }
  }
  output << "showpage";
  output << endl;
}

int main() {
  float dmax; // La distance jusqu'a laquelle on relie deux points
  cout<<"Entrer la distance max jusqu'a laquelle on relie deux points : ";
  cin>>dmax;

  int n; // Le nombre de points
  cout << "Entrer le nombre de points (100 pour points60) : ";
  cin >> n;
  int m=0; // Le nombre d'arêtes

  coord point[n]; // Les coordonnées des points
  vector<int> voisins[n]; // Les listes de voisins
  int arbre[n-1][2]; // Les arêtes de l'arbre de Dijkstra
  int pere[n]; // La relation de filiation de l'arbre de Dijkstra

  //pointsRandom(n,point);
  points60(n,point);
  creeVoisins(n,dmax,point,voisins,m);
  affichageGraphe(n,point,voisins);
  dijkstra(n,voisins,point,pere);
  construireArbre(n,arbre,pere);
  affichageGrapheDijkstra(n,m,point,arbre);

  return EXIT_SUCCESS;
}

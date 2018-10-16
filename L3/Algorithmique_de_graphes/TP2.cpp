#include <cstdlib>
#include <iostream>
#include <cmath>
#include <ctime>
#include "Affichage.cc"

using namespace std;

void pointsRandom(int n, coord point[]) {
  srand(time(NULL));

  for (int i= 0; i< n; i++) {
    point[i].abs= rand()%612;
    point[i].ord= rand()%792;
  }
}

void pointsTrigo(int n, coord point[]) {
  for (int i= 0; i< n; i++) {
    point[i].abs= 300+200*cos(i);
    point[i].ord= 400+150*(sin(i)-cos(i));
  }
}

void distances(int n, int m, coord point[], int edge[][3]) {
  int k= 0;

  for (int j=0; j<n; j++) {
    for (int i=0; i<j; i++) {
      edge[k][0]= i;
      edge[k][1]= j;
      edge[k][2]= pow(point[i].abs-point[j].abs,2)+pow(point[i].ord-point[j].ord,2);
      //edge[k][2]= pow((point[i].abs-point[i].ord)-(point[j].abs-point[j].ord),2);
      k++;
    }
  }
}

void tri(int m, int edge[][3]) {
  /*
  for (int i= 0; i<m; i++) {
    for (int j= 0; j<i; j++) {
      if (edge[i][2] < edge[j][2]) {
	  swap(edge[i][0],edge[j][0]);
	  swap(edge[i][1],edge[j][1]);
	  swap(edge[i][2],edge[j][2]);
      }
    }
  }
  */
  for (int i= m-1; i>=0; i--) {
    for (int j= 0; j<i; j++) {
      if (edge[j+1][2] < edge[j][2]) {
	  swap(edge[j+1][0],edge[j][0]);
	  swap(edge[j+1][1],edge[j][1]);
	  swap(edge[j+1][2],edge[j][2]);
      }
    }
  }
}

void kruskal(int n, int m, int edge[][3], int arbre[][2]) {
  tri(m,edge);

  int comp[n]={};
  int k=0;

  for (int i= 0; i<n; i++)
    comp[i]= i;

  for (int i= 0; i<m; i++) {
    if (comp[edge[i][0]] != comp[edge[i][1]]) {
      arbre[k][0]=edge[i][0];
      arbre[k][1]=edge[i][1];
      k++;

      int aux=comp[edge[i][0]];
      for (int v=0; v<n; v++)
        if (comp[v] == aux)
            comp[v] = comp[edge[i][1]];
    }
  }
}

int main() {
  int n;
  cout<<"Entrez le nombre de points (60 pour pointsTrigo) : ";
  cin>>n;

  int m= n*(n-1)/2; // Le nombre de paires de points
  coord point[n]={}; // Les coordonnées des points dans le plan
  int edge[m][3]={}; // Les paires de points et le carré de leur longueur
  int arbre[n-1][2]={}; // Les arêtes de l'arbre de Kruskal

  pointsRandom(n,point);
  //pointsTrigo(n,point);
  distances(n,m,point,edge);
  //tri(m,edge);
  kruskal(n,m,edge,arbre);
  affichageGrapheKruskal(n,point,arbre);

  /*
  for (int i=0; i<n; i++) {
    cout<<"point["<<i<<"]= "<<point[i].abs<<","<<point[i].ord<<endl;
  }

  for (int i=0; i<m; i++)
      cout<<"edge["<<i<<"][2]="<<edge[i][2]<<endl;
*/

  return 0;
}

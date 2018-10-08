#include <iostream>

using namespace std;

void f1 (int n) {
  unsigned int k= 0;
  
  for (unsigned int i= 1; i<= n; i++) {
    k+= i;
  }
}

void f3 (int n) {
  unsigned int som= 0;
  
  for (unsigned int i= 1; i<= n; i++) {
    for (unsigned int j= 1; j<= n; j++) {
      for (unsigned int k= 1; k<= n; k++) {
	if (i == k) {
	  som++;
	}
      }
    }
  }
}

void g2 (int n) {
  
  if (n > 1) {
    g2(n-1);
    g2(n-2);
  }
  else {
    return;
  }
}

void g3 (int n) {
  
  if (n > 1) {
    g3(n-1);
    g3(n-2);
    g3(n-3);
  }
  else {
    return;
  }
}

int main (int argc, char** argv) {
  time_t start;

  cout<<"A partir de quelle valeur de n sentez-vous la différence entre l'exécution des programmes:\n";
  cout<<"f1(n) et f3(n)? A partir de n= 500\n";
  start= time(NULL);
  cout<<"f1(500) met "; f1(500); cout<<time(NULL)-start; start= time(NULL); cout<<"s et f3(500) met "; f3(500); cout<<time(NULL)-start<<"s\n";
  cout<<"f3(n) et g2(n)? A partir de n= 40\n";
  start= time(NULL);
  cout<<"f3(40) met "; f3(40); cout<<time(NULL)-start; start= time(NULL); cout<<"s et g2(40) met "; g2(40); cout<<time(NULL)-start<<"s\n";
  cout<<"g2(n) et g3(n)? A partir de n= 30\n";
  start= time(NULL);
  cout<<"g2(31) met "; g2(31); cout<<time(NULL)-start; start= time(NULL); cout<<"s et g3(31) met "; g3(31); cout<<time(NULL)-start<<"s\n";

  cout<<"Y a-t-il une valeur de n pour laquelle vous sentez une différence entre:\n";
  cout<<"l’exécution du programme f3(n) et l’exécution successive des programmes f1(n) et f3(n)?\n";
  start= time(NULL);
  cout<<"A partir de n= . f3() met "; f3(500); cout<<time(NULL)-start; start= time(NULL); cout<<"s et f1()+f3() met "; f1(500); f3(500); cout<<time(NULL)-start<<"s\n";
  cout<<"l’exécution du programme g2(n) et l’exécution successive des programmes f3(n) et g2(n)?\n";
  start= time(NULL);
  cout<<"A partir de n= . g2() met "; g2(); cout<<time(NULL)-start; start= time(NULL); cout<<"s et f3()+g2() met "; f3(); g2(); cout<<time(NULL)-start<<"s\n";
  cout<<"l’exécution du programme g3(n) et l’exécution successive des programmes g2(n) et g3(n)?\n";
  start= time(NULL);
  cout<<"A partir de n= . g3()= "; g3(30); cout<<time(NULL)-start; start= time(NULL); cout<<"s et g2()+g3()= "; g2(30); g3(30); cout<<time(NULL)-start<<"s\n";
  
  return 0;
}

// g++ Q1.cpp -o R1

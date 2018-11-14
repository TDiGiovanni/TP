#include <iostream>
#include <vector>


using namespace std;

template <typename T>
class Pile: private vector<T> {
public:
  void empiler(T t) {
    this->push_back(t);
    cout<<"Empilage de "<<t<<endl;
  }

  void depiler() {
    this->pop_back();
    cout<<"Depilage"<<endl;
  }
  
  using vector<T>::size;

  T sommet() {
    return this->back();
  }

  void affiche(ostream& os) {
    for (int i=0; i<this->size(); i++)
      os<<i<<" : "<<(*this)[i]<<endl;
  }
};

int main() {
  Pile<int> p;
  
  p.empiler(2);
  p.empiler(4);

  cout<<"Sommet : "<<p.sommet()<<endl;
  
  p.empiler(6);
  p.empiler(8);

  p.affiche(cout);

  p.depiler();
  
  cout<<"Taille : "<<p.size()<<endl;
  
  return 0;
}

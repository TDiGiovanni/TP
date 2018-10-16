#include <iostream>
#include <cstdlib>

using namespace std;


class tabint
{
 private:
  int* t;
  int n;
  unsigned int alloc;

 public:
  // Constructeur
  tabint(int);

  // Constructeur par copie
  tabint(tabint&);

  // Destructeur
  ~tabint();

  // Opérateur =
  tabint& operator=(tabint&);
  
  // Accesseurs
  int& at(int);

  int getn() const;

  // Autres méthodes
  void extend();
};


void write (ostream&, tabint&);

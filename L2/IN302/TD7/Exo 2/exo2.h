#include <iostream>

template <typename T>
class MyVector
{
 private:
  T* data;
  unsigned int n;
  unsigned int alloc;

  void extend();

 public:
  // Constructeurs
  MyVector();
  MyVector(unsigned int);

  //Destructeur
  ~MyVector();

  // Opérateur =
  MyVector& operator=(const MyVector&);

  // Accesseur en lecture
  const T& at(unsigned int) const;
  
  void push_back(T); // Ajoute un élément à la fin du tableau
  unsigned int size() const; // Récupère la taille du tableau

  T find(const T&) const; // Trouve un élément
  void erase(T); // Supprime un élément
};

void write(std::ostream&, const MyVector&);

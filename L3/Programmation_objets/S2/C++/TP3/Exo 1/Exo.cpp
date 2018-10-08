#include <iostream>

class C1 {
//protected:
private:
  virtual void f() {}
  friend class A;
  friend class B;
  
public:	
  virtual void mc1();
};
/*
class C2: public virtual C1 {
public:
  virtual void mc2();
};
*/
class C2: public virtual C1 {
protected:
  virtual void f() {}	
public:
  virtual void mc2();	
  friend class D;	
};

void C1::mc1() {
  C1* c1;
  c1->f();
  
  C2* c2;
  c2->f(); // Erreur : f est inaccessible depuis ce contexte quand elle est redéfinie dans C2.
}

void C2::mc2() {
  C1* c1;
  c1->f(); // Erreur : f est inaccessible depuis ce contexte quand elle est protected.
  
  C2* c2;
  c2->f(); // Erreur : f est inaccessible depuis ce contexte quand elle est private.
}
	


class A {
public:
  virtual void ma() {
  C1* c1;
  c1->f();
  
  C2* c2;
  c2->f(); // Erreur : f est inaccessible depuis ce contexte quand elle est redéfinie dans C2.
  }	
};

class B: public	virtual	A {
public:
  virtual void mb() {
    C1* c1;
    c1->f();
    
    C2* c2;
    c2->f(); // Erreur : f est inaccessible depuis ce contexte quand elle est redéfinie dans C2
  }
};

class D	{
public:
  virtual void md() {
    C1* c1;
    c1->f(); // Erreur : f est inaccessible depuis ce contexte quand elle est protected.
    
    C2* c2;
    c2->f(); // Erreur : f est inaccessible depuis ce contexte quand elle est protected. Plus d'erreur quand D friend de C2
  }	
};	
	
int main() {
  C1* c1;
  c1->f(); // Erreur : f est inaccessible depuis ce contexte quand elle est protected.
  
  C2* c2;
  c2->f(); // Erreur : f est inaccessible depuis ce contexte quand elle est protected.
}

class A {

};

class Bx {
  friend class A;
protected:
  double x;
};

class By {
protected:
  double y;
};

class B: public Bx, public By {
  
};

class C {

};

/*
class B {
protected:
  int x;
private:
  int y;
};

class A : public B {

};

class C {

};
*/

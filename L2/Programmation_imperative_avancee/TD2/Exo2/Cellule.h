class  Cellule
{
  
 private:
  
  bool etat;
  int x;
  int y;

 public:

  Cellule(bool, int, int);

  bool getetat() const;
  int getx() const;
  int gety() const;
  
  bool estVoisin(Cellule) const;

};


void Test_cell (Cellule);

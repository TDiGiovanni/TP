#include "Itv.h"

using namespace std;

// Classe Itv
// Contsructeurs
Itv::Itv()
{
  bi= 0;
  bs= 0;
}

Itv::Itv(double x, double y)
{
  bi=x;
  bs=y;
}

// Opérateurs
bool Itv::operator==(Itv I2) const
{
   if (bi==I2.getbi() && bs==I2.getbs())
    return true;
  
  else
    return false;
}

bool Itv::operator!=(Itv I2) const
{
  if (bi==I2.getbi() && bs==I2.getbs())
    return false;
  
  else
    return true;
}

bool Itv::operator<(Itv I2) const
{
    if ( ((bi > I2.getbi()) && (bs <= I2.getbs())) || ((bi == I2.getbi()) && (bs < I2.getbs())) )
    return true;
  
  else
    return false;
}

bool Itv::operator>(Itv I2) const
{
  return (bi > I2.getbs()) || (bs < I2.getbi());
}

bool Itv::operator<=(Itv I2) const
{
  return (bi == I2.getbs()) || (bs == I2.getbi());
}

bool Itv::operator>=(Itv I2) const
{
  return (!estEgal(I2) && !estInclus(I2) && !estDisjoint(I2) && !estAccole(I2));
}

void Itv::operator+=(double v)
{
  bi += v;
  bs += v;
}

// Accesseurs en lecture
double Itv::getbi() const
{
  return bi;
}

double Itv::getbs() const
{
  return bs;
}

// Accesseurs en écriture
void Itv::setbi(double x)
{
  bi=x;
}

void Itv::setbs(double x)
{
  bs=x;
}

//
void Itv::affiche() const
{
  cout<<"["<<bi<<","<<bs<<"]"<<endl;
}

double Itv::longueur() const
{
  double l= bs-bi;
  
  return l;
}

bool Itv::appartient(double x) const
{
  bool app;
  
  if (x>=bi && x<=bs)
    app=true;
  else
    app=false;
  
  return app;
}

// Tests
bool Itv::estEgal(Itv I2) const
{
  bool egal;
    
  if (bi==I2.getbi() && bs==I2.getbs())
    egal=true;
  
  else
    egal=false;
  
  return egal;
}

bool Itv::estInclus(Itv I) const
{
  if ( ((bi > I.getbi()) && (bs <= I.getbs())) || ((bi == I.getbi()) && (bs < I.getbs())) )
    return true;
  
  else
    return false;
}

bool Itv::estDisjoint(Itv I) const
{
  return (bi > I.getbs()) || (bs < I.getbi());
}

bool Itv::estAccole(Itv I) const
{
  return (bi == I.getbs()) || (bs == I.getbi());
}

bool Itv::estImbrique(Itv I) const
{
  return (!estEgal(I) && !estInclus(I) && !estDisjoint(I) && !estAccole(I));
}

void Itv::translate(double v)
{
  bi += v;
  bs += v;
}

// Fonctions
void translate(Itv &I, double v)
{
  I.translate(v);
}

ostream& operator<<(ostream &s, const Itv &I)
{
  return s<<"["<<I.getbi()<<","<<I.getbs()<<"]"<<endl;
}

istream& operator>>(istream &s, Itv &I)
{
  double a,b;
  
  s>>a>>b;

  I.setbi(a);
  I.setbs(b);

  return s;
}


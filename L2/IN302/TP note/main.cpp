#include "abr.h"

int main(int argc, char** argv)
{
  ABR<int> A1, A3;
  ABR<double> A2;

  A1.insert(1); A1.insert(8);
  A1.insert(3); A1.insert(6);
  A3= A1;
  A1.insert(5); A1.insert(4);
  A1.insert(7); A1.insert(2);

  std::ifstream file("abr.txt");
  A2.load(file);

  double x;
  std::cin>>x;

  if (A2.find(x))
    std::cout<<x<<" est dans A2"<<std::endl;

  std::cout<<"A1= ";
  A1.affiche(std::cout);
  std::cout<<"A2= ";
  A2.affiche(std::cout);
  std::cout<<"A3= ";
  A3.affiche(std::cout);

  return 0;
}

#include <iostream>
#include "Cellule.h"

using namespace std;

template <typename T>


T max3 (T x, T y, T z)
{
  if (x>y && x>z)
    return x;

  if (y>x && y>z)
    return y;

  return z;
}


int main (int argc, char** argv)
{
  cout<<max3 <int> (1,2,3)<<endl;
  cout<<max3 <double> (1.52,2.68,7.45)<<endl;

  return 0;
}

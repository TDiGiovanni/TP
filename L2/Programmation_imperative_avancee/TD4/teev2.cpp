#include <iostream>
#include <fstream>

using namespace std;


int main (int argc, char** argv)
{
  int i=1;
  ofstream out;
  char* chaine;

  cin>>chaine;
  cout<<chaine<<endl;
  
  while (i<argc)
    {
      out.open(argv[i]);

      out.read(chaine, );

      out.close();
    }
  
  return 0;
}

#include <iostream>
#include <fstream>


int main (int argc, char** argv)
{
  int i=1;

  std::ifstream in;
  
  while (i<argc)
    {
      in.open(argv[i]);

      if (in.is_open()==true)
	{
	  in.seekg(0,in.end);
	  int taille= in.tellg();

	  char* fichier= new char [taille];

	  in.seekg(0,in.beg);
	  in.read(fichier,taille);
	  std::cout.write(fichier,taille);

	  if (in.fail())
	    std::cout<<"Erreur de lecture"<<std::endl;

	  in.close();
	  delete[] fichier;
	}
    
      else
	std::cout<<"Erreur d'ouverture de fichier"<<std::endl;

      i++;
    }
    
    return 0;
}

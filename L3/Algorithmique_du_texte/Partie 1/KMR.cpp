#include <cstdlib>
#include <iostream>
#include <string>
#include <vector>
#include <map>

using namespace std;

void kmr(string mot) {
  map<char,unsigned int> pos;
  vector<unsigned int> p, q;
  unsigned int a, b;
  
  for (unsigned int i=0; i<mot.length(); i++)
    if (pos[mot[i]]==NULL)
      pos[mot[i]]=i;


	
    
    
    
}

int main(int argc, char** argv) {
  kmr("roudoudou");
  
  return 0;
}

#include <iostream>
#include <fstream>
#include <sstream>
#include <cstdlib>
#include <stdlib.h>

// AB.h
typedef int Valeur;

class Sommet;
typedef Sommet* AB;

std::string* TikzRecursAB(int ligne,int gauche, int droite, int numeroPere, int typeFils, AB Ar);

class Sommet {
  protected:
  Valeur racine;
  AB pere, SAG, SAD;

  public:
  Sommet(Valeur v);
  Sommet(Sommet& s);

  void GrefferSAG(AB g);
  void GrefferSAD(AB d);

  void SupprimerSAG();
  void SupprimerSAD();

  bool FeuilleP();

  friend std::string* TikzRecursAB(int ligne,int gauche, int droite, int numeroPere, int typeFils, AB Ar);
};

// SortieLatex.cpp
std::string * TikzRecursAB(int ligne,int gauche, int droite, int numeroPere, int typeFils, AB Ar){
  std::ostringstream ossnum, osslign,osscol,ossnumPere, ossbal, ossnum2Pere,ossnumRac;

  std::string stres("");

  if (Ar) {
    ossnumPere<<numeroPere;
    ossnumRac<<"(\\textcolor{red}{" << Ar->racine << "})\\\\This = \\textcolor{red}{" <<Ar <<"}\\\\Pere = (\\textcolor{red}{"<<Ar->pere <<"})";
    
    if (Ar->pere )ossnum2Pere<<Ar->pere->racine; else ossnum2Pere<<0;
    
    int numero;
    if (typeFils==-1) { numero=1; } else { numero= 2*numeroPere + typeFils; }
    ossnum<<numero;
    osslign<<ligne;
    int mil = (gauche + droite)/2;
    
    osscol<<mil;
    
    stres="\\node[draw, color=black, rounded corners=5pt, text width=3cm, text centered] (SZ" + ossnum.str()    + ") at " +
      "("   + osscol.str()    + ", " + osslign.str() + ") " + 
      "{ "  + ossnumRac.str() + "};\n";
    
    if (typeFils!=-1) stres+="\\draw[->, >=latex, color=blue] (SZ"+ossnumPere.str()+") -- (SZ"+ossnum.str() +");\n";
    
    if (Ar->SAG) stres+=*TikzRecursAB(ligne-3,gauche,mil-13,numero,0,Ar->SAG);
    if (Ar->SAD) stres+=*TikzRecursAB(ligne-3,mil+13,droite,numero,1,Ar->SAD); 
 }
  return new std::string(stres);
}

std::string * TikzAB(AB Ar) {
  return TikzRecursAB(1,1,10,1,-1,Ar);
}

void SortieLatex(AB Ar, std::string filepath) { //don't insert garbage in filepath, its std::system-ised.
  std::ofstream fichier(filepath.c_str(), std::ios::out | std::ios::trunc);
 std::string preamb ("\\documentclass{article} \n \\usepackage{tikz} \n \\begin{document} \n \\resizebox{300pt}{!}{\n \\begin{tikzpicture}\n");
 std::cout<<preamb<<"\n";
 std::string post("\\end{tikzpicture}\n } \\end{document} \n"); //rsz box end?
 std::cout<<post<<"\n";
 std::cout<<*TikzAB(Ar)<<"\n";
 std::string   res1(preamb + *TikzAB(Ar));
 std::string   res(res1 + post);
 //std::cout<<res1<<"\n";
 fichier <<res<<"\n";
 fichier.close();
 
 std::ostringstream system_CARE;
 // /dev/null 2>&1 isnt enough to mute pdflatex...
  system_CARE << "mkdir pdflatex_temp > /dev/null 2>&1;" 
              << "pdflatex -output-directory=\"./pdflatex_temp\" -interaction=nonstopmode \"" << filepath << "\" >/dev/null 2>&1;"
	      << "mv ./pdflatex_temp/*.pdf ./ > /dev/null 2>&1;";
  std::system(system_CARE.str().c_str());
  return;
}

// AB.cpp
Sommet::Sommet(Valeur v) {
  racine = v;
  pere = NULL;
  SAG = NULL;
  SAD = NULL;
}

Sommet::Sommet(Sommet& s) {
  racine = s.racine;
  pere = s.pere;
  if (s.SAG != NULL)
    SAG = new Sommet (*(s.SAG));
  if (s.SAD != NULL)
    SAD = new Sommet (*(s.SAD));
}

bool Sommet::FeuilleP() {
  if (SAG == NULL && SAD == NULL)
    return true;

  return false;
}

void Sommet::SupprimerSAG() {
  if (SAG != NULL) {
    SAG->pere = NULL;
    SAG = NULL;
  }
}

void Sommet::SupprimerSAD() {
  if (SAD != NULL) {
    SAD->pere = NULL;
    SAD = NULL;
  }
}

void Sommet::GrefferSAG(AB g) {
  SupprimerSAG();
  SAG = new Sommet(*g);
}

void Sommet::GrefferSAD(AB d) {
  SupprimerSAD();
  SAD = new Sommet(*d);
 }

// Main
int main(int argc, char** argv) {
  AB A1 = new Sommet(1), A2 = new Sommet(2), A3 = new Sommet(3);
  A1->GrefferSAG(A2); A1->GrefferSAD(A3);

  AB A1Copie = new Sommet(*A1);
  A1Copie->SupprimerSAG(); A1Copie->SupprimerSAD();

  SortieLatex(A1,"A1");
  SortieLatex(A1Copie,"A1Copie");

  std::cout<<"\n";
  std::cout<<"Resultat de FeuilleP sur A1: "<<A1->FeuilleP()<<"\n";
  std::cout<<"Resultat de FeuilleP sur A1Copie: "<<A1Copie->FeuilleP()<<"\n \n";
  
  return 0;
}

// g++ SortieLatex.cpp -o TP5

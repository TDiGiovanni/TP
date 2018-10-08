#ifndef __WINDOW_H
#define __WINDOW_H

extern "C" {
#include <curses.h>
}
#include <string>

// Ensemble de couleurs possibles (fond+texte)
enum Color {
  WBLACK,  // Couleur fond = noir ,   couleur texte = blanc
  WCYAN,   // Couleur fond = cyan,    couleur texte = blanc
  WBLUE,   // Couleur fond = bleu,    couleur texte = blanc
  WYELLOW, // Couleur fond = jaune,   couleur texte = blanc
  WGREEN,  // Couleur fond = vert,    couleur texte = blanc
  WMAGENTA,// Couleur fond = magenta, couleur texte = blanc
  WRED,	   // Couleur fond = rouge,   couleur texte = blanc
  BWHITE,  // Couleur fond = blanc,   couleur texte = blanc
  BCYAN,   // Couleur fond = cyan,    couleur texte = noir
  BBLUE,   // Couleur fond = bleu,    couleur texte = noir
  BYELLOW, // Couleur fond = jaune,   couleur texte = noir
  BGREEN,  // Couleur fond = vert,    couleur texte = noir 
  BMAGENTA,// Couleur fond = magenta, couleur texte = noir
  BRED,    // Couleur fond = rouge,   couleur texte = noir
};



// Fonction pour démarrer le mode console graphique
void startProgramX();
// Fonction pour arrêter le mode console graphique
void stopProgramX();


class Window {
 private:
  int height,width,startx,starty;
  WINDOW* win, *frame;
  Color colorwin, colorframe;
  char bord;
  void update() const;

 public:

  // Constructeur d'une fenêtre de hauteur=h, largeur=w dont le coin supérieur gauche a pour coordonnées (x,y), le caractère c est utilisé pour définir la bordure
  Window(int h,int w, int x, int y, char c='+');

  // Destructeur
  ~Window();

  // Fonction permettant d'afficher une variable s de type (string ou char) à la position (x,y) dans la fenetre. Si une couleur est spécifiée l'affichage utilise cette couleur, sinon la couleur de la fenêtre est utilisée
  void print(int x, int y, std::string s, Color c) const;
  void print(int x, int y, char s, Color c) const;
  void print(int x, int y, std::string s) const;
  void print(int x, int y, char s) const; 

  
  // Accesseurs
  int getX() const;        // Récupère l'abscisse du coin supérieur gauche de la fenêtre 
  int getY() const;        // Récupère l'ordonnée du coin supérieur gauche de la fenêtre 
  int getHauteur() const ; // Récupère la hauteur de la fenêtre
  int getLargeur() const ; // Récupère la largeur de la fenêtre

  Color getCouleurBordure() const; // Récupère la couleur de la bordure
  Color getCouleurFenetre() const; // Récupère la couleur de la fenêtre
  void setCouleurBordure(Color);   // Modifie la couleur de la bordure
  void setCouleurFenetre(Color);   // Modifie la couleur de la fenêtre (ATTENTION, tout le contenu de la fenêtre prend la couleur)

  void clear() const; // Enlève tout le contenu de la fenêtre

};











#endif

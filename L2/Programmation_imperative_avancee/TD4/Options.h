#include <string>

using namespace std;

class option
{
 public:
  enum Type
  {
    Bool,
    Int,
    Float,
    Double,
    Char,
    String,
    None,
  }; 
  
 private:
  int numero;
  string nom, raccourci, description;
  Type type;
  
 public:
  // Constructeurs
  option ();
  option (int, string, string, string, Type);

  // Accesseurs en écriture
  void set_num (int);
  void set_nom (string);
  void set_raccourci (string);
  void set_description (string);
  void set_type (Type);

  // Accesseurs en lecture
  int get_num () const;
  string get_nom () const;
  string get_raccourci () const;
  strin get_description () const;
  Type get_type () const;
};


class Toption
{
 private:
  option T[Nb_opt];
  
 public:
  void ajouter (option);
  void afficher () const;
  int get_num (string) const;
  bool argument (string) const;
  Type get_argument (bool) const;
};

#include "Casier6.hpp"
/*
template <typename t>
t Casier6::operator[](int i) {
  return this->cases[i];
}
*/
template <typename t>
void Casier6::range(t* obj, int i) {
  cases[i-1]= obj;
}

#include <algorithm>
#include <iostream>
#include <random>

int main() {

  std::vector<double> dNr;
  for (int i = 0; i < 5; i++) {
    dNr.emplace_back(((double)rand() / RAND_MAX) * 20);
    std::cout << dNr[i] << std::endl;
  }
  std::cout << "Front: " << dNr.front() << std::endl
            << "Back: " << dNr.back() << std::endl;
  dNr.emplace(dNr.begin() + 1, 13.69);
  std::cout << "Andre i rekkefølgen: " << dNr[1] << std::endl
            << "Tredje i rekkefølgen: " << dNr[2] << std::endl
            << "front: " << dNr.front() << std::endl;
  double inp = 13.69;
  auto p = find(dNr.begin(), dNr.end(), inp);
  std::cout << *p << std::endl
            << "End()iterator: " << *dNr.end() << std::endl;
  for (auto &dNrs : dNr) {
    std::cout << dNrs << ", ";
  }
  if (p == dNr.end()) {
    std::cout << "The number was not found. :- " << *p << std::endl;
  } else {
    std::cout << "Match! :-- " << *p << std::endl;
  }
}

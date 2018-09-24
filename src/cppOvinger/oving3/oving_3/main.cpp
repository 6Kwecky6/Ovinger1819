#include <iostream>

//Oppg. 1
class Circle {
public:
  Circle(double radius_);  //Stor C, skal ha samme navn som klasse
  double get_area() const; //double i stedet for int
  double get_circumference() const;

private:                      //Private skal stå over variabelen, med kolonne
  const double pi = 3.141592; //Flyttet inn i klassen
  double radius;
};                                                  //Semikolonne
Circle::Circle(double radius_) : radius(radius_) {} //inn parameteren skal assignes til klasse parameteren

double Circle::get_area() const { //Vi returnerer en constant, og velger double i stedet for int
  return pi * radius * radius;
}

double Circle::get_circumference() const {  //Git funksjonen en retur type
  double circumference = 2.0 * pi * radius; //Deklarerer circumference
  return circumference;
}
//Oppg.3
class Commodity {
public:
  Commodity(const std::string &name_, int id_, double price_);
  const std::string &get_name() const;
  double get_price(double q) const;
  double get_price() const;
  int get_id() const;
  void set_price(double price);
  void set_id(int id);
  double get_price_with_sales_tax(double q) const;

private:
  std::string name;
  int id;
  double price;
  double tax = 1.4;
};

Commodity::Commodity(const std::string &name_, int id_, double price_) : name(name_), id(id_), price(price_) {}

const std::string &Commodity::get_name() const {
  return name;
}
double Commodity::get_price() const {
  return price;
}
double Commodity::get_price(double q) const {
  return price * q;
}
double Commodity::get_price_with_sales_tax(double q) const {
  return q * price * tax;
}

int Commodity::get_id() const {
  return id;
}
void Commodity::set_id(int id_) {
  id = id_;
}
void Commodity::set_price(double price_) {
  price = price_;
}

int main() {
  //Oppg. 2
  Circle circle(5);

  double area = circle.get_area();
  std::cout << "Arealet er lik " << area << std::endl;

  double circumference = circle.get_circumference();
  std::cout << "Omkretsen er lik " << circumference << std::endl;

  //Oppg. 3
  const double quantity = 2.5;
  Commodity commodity("Norvegia", 123, 73.50);

  std::cout << "Varenavn: " << commodity.get_name() << ", varenr: " << commodity.get_id() << " Pris pr enhet: " << commodity.get_price() << std::endl;

  std::cout << "Kilopris: " << commodity.get_price() << std::endl;
  std::cout << "Prisen for " << quantity << " kg er " << commodity.get_price(quantity) << " uten moms" << std::endl;
  std::cout << "Prisen for " << quantity << " kg er " << commodity.get_price_with_sales_tax(quantity) << " med moms" << std::endl;

  commodity.set_price(79.60);
  std::cout << "Ny kilopris: " << commodity.get_price() << std::endl;
  std::cout << "Prisen for " << quantity << " kg er " << commodity.get_price(quantity) << " uten moms" << std::endl;
  std::cout << "Prisen for " << quantity << " kg er " << commodity.get_price_with_sales_tax(quantity) << " med moms" << std::endl;

  //Oppg. 4 a)
  std::string word1, word2, word3;
  std::cin >> word1 >> word2 >> word3;
  //b)
  std::string sentence = word1 + " " + word2 + " " + word3 + ".";
  //c)
  std::cout << "Word1: " << word1.length() << std::endl
            << "Word2: " << word2.length() << std::endl
            << "Word3: " << word3.length() << std::endl
            << "Sentence: " << sentence.length() << std::endl;
  //d)
  std::string sentence2 = sentence;
  //e)
  for (int i = 9; i < 11; i++) {
    sentence2[i] = 'X';
  }
  std::cout << "Sentence1: " << sentence << std::endl
            << "Sentence2: " << sentence2 << std::endl;
  //f)
  std::string sentence_start = "     ";
  for (int i = 0; i < 5; i++) {
    sentence_start[i] = sentence[i];
  }
  std::cout << "Sentence complete: " << sentence << std::endl
            << "Sentence start: " << sentence_start << std::endl;

  std::cout << "Sentence contains 'hallo': " << (sentence.find("hallo") != std::string::npos) << std::endl;

  for (size_t i = 0; i < sentence.length(); i++) {
    if ((sentence[i] == 'e') && (sentence[i + 1] == 'r')) {
      std::cout << "Found 'er' at index " << i << std::endl;
    }
  }
}
#include <iostream>
using namespace std;

//Oppg. 6
int find_sum(const int *table, int length) {
  int tot = 0;
  for (int i = 0; i < length; i++) {
    tot += *(table + i);
  }
  return tot;
}

int main() {
  //Oppg.1 a)
  int i = 3;
  int j = 5;
  int *p = &i;
  int *q = &j;
  cout << "______________OPPG. 1_____________" << endl
       << "Value i and p: " << i << " " << *p << endl
       << "Address i and p: " << &i << " " << p << endl
       << "Value j and q: " << j << " " << *q << endl
       << "Address j and q: " << &j << " " << q << endl;
  //Oppg. 1 b)
  *p = 7;
  *q += 4;
  *q = *p + 1;
  p = q;
  cout << "_______________OPPG. 2_____________" << endl
       << *p << " " << *q << endl
       << p << " " << q << endl
       << i << " " << &i << endl;

  /*
   * Oppg. 2
   * I den gitte koden, vil vi sette null på verdien *line variabelen(*line[0]). Dette vil si at variabelen ikke har noe verdi lenger til noe verdi. Dette
   * er hensiktsmessig om man vil sørge for at det ikke er noe der. Alikevel, så vil dette bare sikkre at line[0] er trygg fra å overskrive variablene. Det vil si
   * at i tilfellet til denne utskriften, vil vi bare sikkre "D", og alle andre bokstaver kan potensielt overskrive andre ting.
   *
   * Oppg. 3
   * Til å starte med, kan vi få feil ved at inputen til brukeren kan være mer enn 5 bokstaver. Da vil vi overskrive minneindexet utenfor listen, og kompilatoren vil
   * advare oss med stack smashing detected. While løkken kan og gå utenfor indexet, eller enda verre, aldri stoppe. Den vil kjøre helt til den finner en "e".
   * I tillegg, overskriver vi alle karakterene med "e" frem til vi finner en "e", så vi vil og miste betydningen på stringen.
   * */
  //Oppg. 4
  int a = 5;
  int &b = a; //En referanse må referere til noe med en gang
  int *c;
  c = &b;
  a = b + *c; //en referanse kan ikke være en peker, og a er ikke en peker
  b = 2;      //en referanse kan ikke referere til ett tall, den må ha en variabel den kan referere til.

  //Oppg. 5
  double number = 15.42534;
  double *pointer = &number;
  double &ref = number;
  cout << "_________________OPPG. 5__________________" << endl
       << "Normal var: " << number << endl
       << "Pointer var: " << *pointer << endl
       << "Reference var: " << ref << endl;

  //Oppg. 6
  int const length = 20;
  int const round1 = 10;
  int const round2 = 5;
  int const round3 = 5;
  int list[length];
  for (int i = 0; i < length; i++) {
    *(list + i) = i + 1;
  }
  cout << "___________________OPPG. 6__________________" << endl
       << "Up to 10: " << find_sum(list, round1) << endl
       << "The next 5: " << find_sum((list + round1), round2) << endl
       << "The last 5: " << find_sum((list + length - round3), round3) << endl;
}

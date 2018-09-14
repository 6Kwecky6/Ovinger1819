#include <iostream>

using namespace std;

int *genList(int);

int main() {
  int length = 100;
  int *list = genList(length);
  for (int i = 0; i < length; i++) {
    cout << list[i];
  }
}

int genList(int length)[] {
  int list[length];
  for (int i = 0; i < length; i++) {
    list[i] = rand() % static_cast<int>(length + 1);
  }
  return *list;
}

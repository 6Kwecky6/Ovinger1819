#include <fstream>
#include <iostream>

using namespace std;

void read_temperatures(double[], int);

int main() {
  const int length = 5;
  double temp[length];
  int cold = 0, medicore = 0, heat = 0;
  read_temperatures(temp, length);
  for (int i = 0; i < length; i++) {
    if (temp[i] < 10) {
      cold++;
    } else if (temp[i] <= 20) {
      medicore++;
    } else {
      heat++;
    }
  }
  cout << "Amount of days below 10: " << cold << "\nAmount of days between 10 and 20: " << medicore << "\nAmount of days above 20: " << heat << "\n";
}

void read_temperatures(double temperatures[], int length) {
  ifstream file;
  file.open("temperatureList.txt");
  if (!file) {
    cout << "File not found!" << endl;
    exit(EXIT_FAILURE);
  }
  for (int i = 0; i < length; i++) {
    file >> temperatures[i];
  }
  file.close();
}

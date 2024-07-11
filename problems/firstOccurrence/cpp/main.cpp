#include <iostream>
#include <string>

using namespace std;

int my_func(string haystack, string needle) {
  if (needle.empty()) {
    return -1;
  }

  int n = haystack.length();
  int m = needle.length();

  for (int i = 0; i <= n - m; i++) {
    int j = 0;

    while (j < m && haystack[i + j] == needle[j]) {
      j++;
    }

    if (j == m) {
      return i;
    }
  }

  return -1;
}

int main() {
  string haystack = "sadbutsad", needle = "sad";

  cout << my_func(haystack, needle) << endl;

  return 0;
}

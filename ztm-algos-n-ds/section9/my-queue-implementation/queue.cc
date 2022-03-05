#include "queue.h"
#include <iostream>

using namespace std;

Queue::Queue() : internalList(new LinkedList()) {
  cout << "created a new Queue" << endl;
}


#include "queue.h"
#include <iostream>

using namespace std;

int main() {
  Queue* queue = new Queue();

  cout << "Queue first inserted node: " << queue->PeekFront() << endl;

  queue->Enqueue(1);
  queue->Enqueue(2);
  queue->Enqueue(3);
  queue->Enqueue(4);

  cout << "Queue first inserted node: " << queue->Peek() << endl;

  int result = queue->Dequeue();

  cout << "Dequeued node with data: " << result << endl;

  return 0;
}
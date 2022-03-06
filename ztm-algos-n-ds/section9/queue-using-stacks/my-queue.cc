#include <iostream>
#include <stack>

using namespace std;

class MyQueue {
  public:
    MyQueue() {

    }

    void push(int x) {
      cout << "adding '" << x << "' to the first stack" << endl;
      _stack01.push(x);
    }

    int pop() {
      return 0;
    }

    int peek() {
      if (!_stack01.empty()) {
        while (!_stack01.empty()) {
          cout << "copying element '" << _stack01.top() << "' from _stack01 "
            << "to _stack02" << endl;
          _stack02.push(_stack01.top());
          _stack01.pop();
        }

        cout << "queue top is: " << _stack02.top() << endl;

        return _stack02.top();
      }

      if (!_stack02.empty()) {
        while(!_stack02.empty()) {
          cout << "copying element '" << _stack02.top() << "' from _stack02 "
            << "to _stack01" << endl;
          _stack01.push(_stack02.top());
          _stack02.pop();
        }

        cout << "queue top is: " << _stack01.top() << endl;

        return _stack01.top();
      }

      return (int)INT_MIN;

    }

    bool empty() {
      return 0;
    }

  private:
    stack<int> _stack01;
    stack<int> _stack02;

};

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue* obj = new MyQueue();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->peek();
 * bool param_4 = obj->empty();
 */
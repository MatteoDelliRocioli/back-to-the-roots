#include <iostream>
#include <stack>

using namespace std;

class MyQueue {
  public:
    MyQueue() {

    }

    void push(int x) {
      cout << "adding '" << x << "' to the first stack" << endl;

      if (_stack01.empty() && _stack02.empty()) {
        _stack01.push(x);
        return;
      }

      if (!_stack01.empty()) {
        _stack01.push(x);
        return;
      }

      _stack02.push(x);
    }

    int pop() {
      cout << "popping" << endl;

      int result = (int)INT_MIN;

      if (!_stack01.empty()) {
        while (!_stack01.empty()) {
          cout << "copying element '" << _stack01.top() << "' from _stack01 "
            << "to _stack02" << endl;
          _stack02.push(_stack01.top());
          _stack01.pop();
        }

        cout << "queue top is: " << _stack02.top() << endl;
        result = _stack02.top();
        _stack02.pop();

        while (!_stack02.empty()) {
          _stack01.push(_stack02.top());
          _stack02.pop();
        }

        return result;
      }

      if (!_stack02.empty()) {
        while(!_stack02.empty()) {
          cout << "copying element '" << _stack02.top() << "' from _stack02 "
            << "to _stack01" << endl;
          _stack01.push(_stack02.top());
          _stack02.pop();
        }

        cout << "queue top is: " << _stack01.top() << endl;
        result = _stack01.top();
        _stack01.pop();

        while (!_stack01.empty()) {
          _stack02.push(_stack01.top());
          _stack01.pop();
        }

        return result;
      }

      return result;
    }

    int peek() {
      cout << "peeking" << endl;
      int result = (int)INT_MIN;

      if (!_stack01.empty()) {
        while (!_stack01.empty()) {
          cout << "copying element '" << _stack01.top() << "' from _stack01 "
            << "to _stack02" << endl;
          _stack02.push(_stack01.top());
          _stack01.pop();
        }

        cout << "queue top is: " << _stack02.top() << endl;
        result = _stack02.top();

        while (!_stack02.empty()) {
          _stack01.push(_stack02.top());
          _stack02.pop();
        }

        return result;
      }

      if (!_stack02.empty()) {
        while(!_stack02.empty()) {
          cout << "copying element '" << _stack02.top() << "' from _stack02 "
            << "to _stack01" << endl;
          _stack01.push(_stack02.top());
          _stack02.pop();
        }

        cout << "queue top is: " << _stack01.top() << endl;
        result = _stack01.top();

        while (!_stack01.empty()) {
          _stack02.push(_stack01.top());
          _stack01.pop();
        }

        return result;
      }

      return result;

    }

    bool empty() {
      if (!_stack01.empty() || !_stack02.empty()) {
        cout << "queue is not empty" << endl;
        return false;
      }

      cout << "queue is empty" << endl;
      return true;
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
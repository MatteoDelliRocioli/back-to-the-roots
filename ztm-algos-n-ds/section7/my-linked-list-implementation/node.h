#pragma once

class node
{
  public:
    node();
    node(int &value);
    ~node();

    int getValue();
    void setValue(int value);
    int* getLink();
    void setLink(int &link);


  private:
    int value;
    int* link;
};
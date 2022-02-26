#pragma once

class node
{
  public:
    node();
    node(int &value);
    ~node();

    int getValue();
    int* getLink();
    void setLink(int &link);


  private:
    int value;
    int* link;
};
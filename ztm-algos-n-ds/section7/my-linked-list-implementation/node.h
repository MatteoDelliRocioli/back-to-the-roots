#pragma once

class node
{
	public:
		node(int &value);
		~node();

		int getValue();
		int* getLink();


	private:
		int value;
		int* link;
};
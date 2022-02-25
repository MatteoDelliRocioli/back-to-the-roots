#pragma once

class node
{
	public:
		node(const int &value);
		~node();

		int getValue();
		const int* getLink();

	private:
		int value;
		const int* link;
};
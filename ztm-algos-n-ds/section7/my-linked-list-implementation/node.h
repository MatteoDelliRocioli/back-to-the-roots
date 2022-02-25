#pragma once

class node
{
	public:
		node(const int &value);
		~node();

		int getValue();

	private:
		int value;
		const int* link;
};
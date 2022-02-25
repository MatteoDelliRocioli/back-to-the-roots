#pragma once

class node
{
	public:
		node(const int &value);
		~node();

	private:
		int value;
		long long link;
};
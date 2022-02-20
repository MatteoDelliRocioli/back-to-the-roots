#pragma once

#include <string>

namespace personalImplementation
{
	class HashTable
	{
		public:
			int get(string key);
			void set(string key, int value);

		private:
			void _hash(string key);
	}
}
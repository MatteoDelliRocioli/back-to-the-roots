# How does one builds multiple files in one executable?

To build multiple files into one executable the command to use is `g++` followed by the names of the `*.cpp` class files. 
DO NOT include `*.h` files in the build command because they are not to be built, they are just used by the linker to know the class members and function definitions and create a single file executable.

E.g.
```bash
g++ .\hashTable.cpp .\main.cpp
```

and then type the newly created executable name in the CLI to run the program

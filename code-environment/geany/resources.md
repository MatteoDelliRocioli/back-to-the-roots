Here is the list of resources that I used to set up my Geany configuration, the result is ![image](https://user-images.githubusercontent.com/37411225/148621295-1a393b0d-3308-4901-ab95-0fc2a7626677.png)

---

### Windows 10 and WSL2

SInce my machine has win10 installed, I've taken advantage of thw WSL2 linux integration for windows.
The complete guide to install WSL2 and enable GUI for the linux subsystem can be found [here](https://medium.com/@japheth.yates/the-complete-wsl2-gui-setup-2582828f4577)

---

### Errichto Geany setup

Considering that the setup is intended to be convenient for starting competitive programming, I've looked up for the [`errichto` Geany setup guide](https://github.com/Errichto/youtube/wiki/Linux-&-Geany-Setup)

---

### Personal additions

I wanted to the editor to give me as little clues as possible about the code (so little to no syntax highlight), thus I modified the file `filetypes.cpp` in the `/usr/share/geany/filedefs` folder. I recommend to make a copy of it before modifying, just in case 😊.

So here is the current content of that file:
``` bash
# For complete documentation of this file, please see Geany's main documentation
[styling=C]

[lexer_properties=C]

[settings]
lexer_filetype=C

# default extension used when saving files
extension=cpp

# MIME type
mime_type=text/x-c++src

# the following characters are these which a "word" can contains, see documentation
#wordchars=_abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789

# single comments, like # in this file
comment_single=//
# multiline comments
comment_open=/*
comment_close=*/

# set to false if a comment character/string should start at column 0 of a line, true uses any
# indentation of the line, e.g. setting to true causes the following on pressing CTRL+d
        #command_example();
# setting to false would generate this
#       command_example();
# This setting works only for single line comments
comment_use_indent=true
```

Other than the above, I've added the Monokai theme from the official [Geany themes page](https://www.geany.org/download/themes/) only modifying the "comment" color to be `comment=#FF00FF` and putting the file in the `~/.config/geany/colorschemes/` directory.

# My vim editor configuration

## vim --version
> VIM - Vi IMproved 8.1 (2018 May 18, compiled Nov 08 2021 14:21:34)

## ~/.vimrc file contents
```bash
syntax off
set number
set tabstop=2
bel vert term
set hls is
hi Search cterm=NONE ctermfg=black ctermbg=gray
```

- __syntax off__ is to program in vim without any syntax aid, that is in order to better learn the specific language syntax
- __set number__ shows the line index number at the left side while editing a file in vim
- __set tabstop=2__ sets the tab to occupy 2 spaces
- __bel vert term__ splits the screen when opening vim to show a terminal on the right side of your screen, to switch focus between terminals use the _"**CTRL+W+W**"_ command

Result example (using wsl2 on Win10)
![image](https://user-images.githubusercontent.com/37411225/148401421-4ae6937f-5a41-4dd5-a103-142ee08177fd.png)

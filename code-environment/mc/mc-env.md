# My midnight-commander configuration

I wanted to change working directory on __mc__ exit to the last visited one during __mc__ navigation

In order to obtain that you simply put the following line to the end of your ~/.profile file
``` bash
alias mc='source /usr/lib/mc/mc-wrapper.sh'
```

After updating the ~/.profile file run
``` bash
source ~/.profile
```
for the changes to take effect
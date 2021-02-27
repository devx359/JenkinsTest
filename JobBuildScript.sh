#! /bin/sh
echo "*********************Strating test*********************"
chmod 777 $WORKSPACE/drivers/chromedriver_88
Xvfb -ac :99 -screen 0 1280x1024x16 & export DISPLAY=:99
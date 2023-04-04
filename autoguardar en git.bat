@echo off
title Autoguardado en git del proyecto "prueba"
color 0B
set /P message="Insert commit comment:"
set autosave=(This is autosave from 'autoguardar en git.bat'.)
set commit=%message%%autosave%
echo Starting save
echo ----------------------------------------------------------
git add %~dp0*
git commit -m "%commit%"
git push
echo ----------------------------------------------------------
echo Save ended
pause
exit
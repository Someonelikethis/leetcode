#!/usr/bin/env bash
#（#!）符号表示Shebang,通常卸载shell脚本的第一行，指明执行这个脚本的程序

#第十行

if [ $(cat file.txt | wc -l) -ge 10 ]
then
echo `head -10 file.txt|tail -1`
else
echo ""
fi
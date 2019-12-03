#第十行

if [ $(cat file.txt | wc -l) -ge 10 ]
then
echo `head -10 file.txt|tail -1`
else
echo ""
fi
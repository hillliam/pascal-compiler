#!/bin/bash
mkdir -p txt-full-export
for file in *.pascal
do
  ../java.bat pascal.Pascal $file -path 1 > txt-full-export/$file.txt
done

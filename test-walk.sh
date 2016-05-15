#!/bin/bash
mkdir -p txt-export
for file in *.pascal
do
  ../java.sh pascal.Pascal $file -path > txt-export/$file.txt
done

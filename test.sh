#!/bin/bash
mkdir -p js-export
for file in *.pascal
do
  ../java.sh pascal.Pascal $file > js-export/$file.js
done

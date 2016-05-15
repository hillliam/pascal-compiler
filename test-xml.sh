#!/bin/bash
mkdir -p xml-export
for file in *.pascal
do
  ../java.sh pascal.Pascal $file -xml > xml-export/$file.xml
done

#!/bin/bash

for i in *
do
    if [ -f "$i" ]
    then
	for p in $*
	do
	    l=$(grep -c $p "$i")
	    if [[ $l>0 ]]
	    then
		mv $i DUMP
	    fi
	done
    fi
done

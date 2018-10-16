#!/usr/bin/env python3

import sys
import re
import os

resa=re.search("^-.*a",sys.argv[1])
resp=re.search("^-.*p",sys.argv[1])
home= os.getenv("HOME")

if os.path.isfile(home+"/.bashrc"):
    fd= open(home+"/.bashrc","r")
    tab= fd.readlines()

    if resa or resp:
        for i in tab:
            if resa:
                resaa= re.search("^ *alias +([^=]+) *= *(.+)",i)
                if resaa:
                    print("La commande",resaa.group(2),"est devenue",resaa.group(1))
                    
            if resp:
                respp= re.search("^ *export +PATH=\$PATH:(.+)",i)
                if respp:
                    print("Les répertoires supplémentaires ajoutés sont",respp.group(1))

    else:
        print("Les options utilisées sont incorrectes (options possibles: a et p)")

    fd.close()
        
else:
    print("Le fichier n'existe pas")

#!/usr/bin/env python3

import os, sys, re

suffixes= {}
k= 0

def parcours (repertoire):

    print ("Je suis dans", repertoire)

    global k
    liste= os.listdir(repertoire)
    
    for fichier in liste:

        if os.path.isdir(repertoire+"/"+fichier):
            parcours (repertoire+"/"+fichier)
            
        else:
            res= re.search(".*(\..+)",fichier)

            if res:
                ext= res.group(1)
                
                if ext in suffixes:
                    suffixes[ext]+=1
                    k+=1

                else:
                    suffixes[ext]=1
                    k+=1
                    
                
parcours (sys.argv[1])

for i in suffixes:
    print (i,":",suffixes[i])
print ("Total :",k)

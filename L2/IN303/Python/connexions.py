#!/usr/bin/env python3

import sys, os, re

annee={'Jan': 'Janvier', 'Feb': 'Février', 'Mar': 'Mars', 'Apr': 'Avril', 'May': 'Mai', 'Jun': 'Juin', 'Jul': 'Juillet', 'Aug': 'Août', 'Sep': 'Septembre', 'Oct': 'Octobre', 'Nov': 'Novembre', 'Dec': 'Decembre'}

last=os.popen("last")

logdate={}


for line in last:
    res= re.search("^([a-z]+) +(pts|tty).+([A-Z][a-z][a-z]) (( |[1-3])[0-9]).+\(([0-9][0-9]):([0-9][0-9])\)",line)
    
    if res:
        login= res.group(1)
        mois= res.group(3)
        jour= res.group(4)
        heure= res.group(6)
        minutes= res.group(7)
        temps= int(heure)*60 +int(minutes)
        date= jour+" "+annee[mois]
        
        if login in logdate:
            logdate[login]=[logdate[login][0]+1 , logdate[login][1]+temps]
        else:
            logdate[login]=[1,temps]

            
for i in logdate:
    print(i,"s'est connecté le",date,"(",logdate[i][0],"fois pendant",logdate[i][1],"minutes au total )")

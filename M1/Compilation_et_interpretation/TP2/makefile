G4 = PP
AST = PP

JAVAC = javac
ANTLR_PATH = /usr/local/lib/antlr-4.7.1-complete.jar
ANTLR_JAR = java -jar $(ANTLR_PATH)

TMP = "$(PWD)/tmp"

all: $(G4).interp
	$(JAVAC) -classpath $(ANTLR_PATH) -d $(TMP) $(TMP)/*.java "$(PWD)"/*.java

$(G4).interp: $(G4).g4
	mkdir -p $(TMP)
	$(ANTLR_JAR) -o $(TMP) $(G4).g4

clean:
	rm -fr $(TMP)

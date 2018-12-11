CXX      	= g++
CXXFLAGS 	= -std=c++1z -Wextra -Wall -pedantic -g -O0 -pthread
LDFLAGS  	=

EXEDIR  	 = bin

CLTEXE  	 = client
SRVEXE  	 = server

CLTSRCDIR = code/client/sources
CLTINCDIR = code/client/includes
CLTOBJDIR = code/client/obj

SRVSRCDIR = code/server/sources
SRVINCDIR = code/server/includes
SRVOBJDIR = code/server/obj

CMNSRCDIR = code/common/sources
CMNINCDIR = code/common/includes

CLTSRC = $(wildcard $(CLTSRCDIR)/*.cpp $(CMNSRCDIR)/*.cpp) $(wildcard $(CLTSRCDIR)/**/*.cpp $(CMNSRCDIR)/**/.cpp)

CLTOBJ = $(CLTSRC:$(CLTSRCDIR)/%.cpp=$(CLTOBJDIR)/%.o)

SRVSRC = $(wildcard $(SRVSRCDIR)/*.cpp $(CMNSRCDIR)/*.cpp) $(wildcard $(SRVSRCDIR)/**/*.cpp $(CMNSRCDIR)/**/.cpp)
SRVOBJ = $(SRVSRC:$(SRVSRCDIR)/%.cpp=$(SRVOBJDIR)/%.o)

all: $(CLTEXE) $(SRVEXE)

# Client
$(CLTEXE): $(CLTOBJ)
	$(CXX) $(CXXFLAGS) $^ -o $(EXEDIR)/$(CLTEXE) $(LDFLAGS) -I$(CMNINCDIR)

$(CLTOBJDIR)/%.o: $(CLTSRCDIR)/%.cpp
	@mkdir -p $(CLTOBJDIR)
	-$(CXX) $(CXXFLAGS) -c $< -o $@ -I$(CLTINCDIR) -I$(CMNINCDIR)


# Server
$(SRVEXE): $(SRVOBJ)
	$(CXX) $(CXXFLAGS) $^ -o $(EXEDIR)/$(SRVEXE) $(LDFLAGS) -I$(CMNINCDIR)

$(SRVOBJDIR)/%.o: $(SRVSRCDIR)/%.cpp
	@mkdir -p $(SRVOBJDIR)
	-$(CXX) $(CXXFLAGS) -c $< -o $@ -I$(SRVINCDIR) -I$(CMNINCDIR)

clean:
	@rm -rf $(CLTOBJDIR)
	@rm -rf $(SRVOBJDIR)
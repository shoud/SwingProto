JAVA=java
JAVAC=javac
CLASSPATH=bin/:.:sqlite-jdbc-3.7.2.jar

VIEW_SRC=$(wildcard view/*.java)
VIEW_CLASS=$(VIEW_SRC:.java=.class)
BIN_VIEW_CLASS=$(addprefix bin/,$(VIEW_CLASS))
MODEL_SRC=$(wildcard model/*.java)
MODEL_CLASS=$(MODEL_SRC:.java=.class)
BIN_MODEL_CLASS=$(addprefix bin/,$(MODEL_CLASS))

all: bin/GestionImages.class bin/controller/CounterController.class $(BIN_MODEL_CLASS) $(BIN_VIEW_CLASS)

bin/%.class: %.java
	$(JAVAC) $^ -d bin

.PHONY: all clean run

clean:
	rm -rf bin/*

run: all
	$(JAVA) -classpath $(CLASSPATH) GestionImages

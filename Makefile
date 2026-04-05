# Makefile to generate Javadoc for Java source files in the current directory.

# --- Variables ---
# Tool for generating Javadoc.
JAVADOC := javadoc
# All .java files in the current directory.
SOURCES := $(wildcard *.java)
# Directory where generated Javadoc will be placed.
OUTDIR  := docs

# --- Targets ---

# Default target: running 'make' will build the javadoc.
.PHONY: all
all: javadoc

# Generates the Javadoc documentation.
.PHONY: javadoc
javadoc:
	@echo "Generating Javadoc for $(SOURCES) into $(OUTDIR)/..."
	@mkdir -p $(OUTDIR)
	@$(JAVADOC) -d $(OUTDIR) -sourcepath . $(SOURCES)

# Opens the generated documentation in a web browser.
# Uses a Python one-liner for cross-platform compatibility.
.PHONY: open
open: javadoc
	@echo "Opening documentation..."
	@python -m webbrowser -t "$(OUTDIR)/index.html"

# Removes the generated documentation directory.
.PHONY: clean
clean:
	@if [ -d "$(OUTDIR)" ]; then \
		echo "Removing $(OUTDIR)/..."; \
		rm -rf $(OUTDIR); \
	fi

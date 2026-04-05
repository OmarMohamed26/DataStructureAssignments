# Makefile to generate Javadoc for Java source files in this project.

# --- Variables ---
JAVADOC := javadoc
SOURCES := $(shell find linkedlist stack -name '*.java' | sort)
OUTDIR := docs

# --- Targets ---
.PHONY: all
all: javadoc

.PHONY: javadoc
javadoc:
	@echo "Generating Javadoc for $(SOURCES) into $(OUTDIR)/..."
	@mkdir -p $(OUTDIR)
	@$(JAVADOC) -d $(OUTDIR) $(SOURCES)

.PHONY: open
open: javadoc
	@echo "Opening documentation..."
	@python -m webbrowser -t "$(OUTDIR)/index.html"

.PHONY: clean
clean:
	@if [ -d "$(OUTDIR)" ]; then \
		echo "Removing $(OUTDIR)/..."; \
		rm -rf $(OUTDIR); \
	fi

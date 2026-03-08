# Linked List Data Structure Lab

A custom Java implementation of a Singly Linked List from scratch, built as part of a Data Structures course lab. This repository includes the core data structure implementation alongside several algorithmic exercises.

## Features

The `SingleLinkedList` class implements the `ILinkedList` interface and provides standard linked list operations:
- `add()` / `addHead()` / `add(index, element)` - Insertion methods
- `get()` / `set()` - Access and modify elements by index
- `remove()` / `clear()` - Deletion methods
- `sublist()` - Extract a portion of the list
- `contains()` / `isEmpty()` / `size()` - Utility and boolean checks
- Built-in `Scanner` support to read lists directly from standard input (stdin).

## Algorithmic Exercises

The `LinkedListExercise` class contains solutions and placeholders for common linked list interview/competitive programming problems:
- **Compare Two Lists:** Check if two linked lists are identical in both size and element values.
- **Reverse List:** (Pending) Reverse a linked list in-place without using extra memory.
- **Merge Sorted Lists:** (Pending) Merge two internally sorted linked lists into a single sorted list.

## Remaining Tasks

The following tasks are planned or currently in progress:
- [ ] Make the Doubly Linked List follow the `ILinkedList` interface.
- [ ] Adapt the Doubly Linked List solution to work on HackerRank.
- [ ] Solve the *"Reverse Linked List"* problem using the custom `SingleLinkedList` class.
- [ ] Solve the *"Merge Two Sorted Linked Lists"* problem using the custom `SingleLinkedList` class.

## Getting Started

To compile and run the project, ensure you have a Java Development Kit (JDK) installed. You can compile the source files and run the main test methods provided in the classes:

```bash
javac *.java
java SingleLinkedList
```
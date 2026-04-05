# Linked List Data Structure Lab

A custom Java implementation of linked-list data structures from scratch, built as part of a Data Structures course lab.

## Project Structure

- `linkedlist/`: Linked-list interfaces, implementations, and linked-list exercises.
- `stack/`: Stack interface and stack implementation backed by `SingleLinkedList`.

## Features

The `SingleLinkedList` class implements the `ILinkedList` interface and provides standard linked-list operations:
- `add()` / `addHead()` / `add(index, element)` for insertion.
- `get()` / `set()` for indexed access and updates.
- `remove()` / `clear()` for deletion.
- `sublist()` for extracting a list segment.
- `contains()` / `isEmpty()` / `size()` for utility checks.
- Built-in `Scanner` support to read lists directly from standard input.

## Algorithmic Exercises

The `LinkedListExercise` class contains solutions and placeholders for common linked-list interview and competitive-programming problems:
- **Compare Two Lists:** Checks if two linked lists are identical in size and values.
- **Reverse List:** Placeholder for in-place reverse without extra memory.
- **Merge Sorted Lists:** Placeholder for in-place merge of sorted lists.

Additional HackerRank-style helpers are provided in:
- `linkedlist/ReverseLinkedList.java`.
- `linkedlist/MergeLinkedList.java`.
- `linkedlist/Solution.java`.

## Remaining Tasks

- [ ] Make the doubly linked list follow the `ILinkedList` interface.
- [ ] Adapt the doubly linked-list solution to work on HackerRank.
- [ ] Solve the *Reverse Linked List* problem using the custom `SingleLinkedList` class.
- [ ] Solve the *Merge Two Sorted Linked Lists* problem using the custom `SingleLinkedList` class.

## Getting Started

To compile and run the project, ensure you have a Java Development Kit (JDK) installed.

```bash
javac linkedlist/*.java stack/*.java
java linkedlist.SingleLinkedList
```

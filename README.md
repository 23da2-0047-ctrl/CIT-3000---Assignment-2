
# CIT300 – Data Structure & Graph Performance Analyzer  -  Assignment-2

## 1. Project Description

The Data Structure & Graph Performance Analyzer is a Java-based console application developed for the CIT300 Data Structures and Algorithms Graded Practical Assignment 2.

The main purpose of this project is to demonstrate different data structures, searching algorithms, graph traversal algorithms, and algorithmic complexity through a menu-driven application.

Users can perform operations on arrays, stacks, queues, linked lists, and graphs. The system also provides performance comparisons using operation counts and execution time.

## 2. Technologies Used

* **Programming Language:** Java
* **Application Type:** Console-Based Application
* **Development Environment:** Java-compatible IDE / Command Prompt
* **Version Control:** Git and GitHub

## 3. Main Features

### Array Operations

* Insert elements
* Delete elements
* Search for elements
* Display array elements
* Sort array elements

### Stack Operations

* Push elements
* Pop elements
* Peek at the top element
* Display stack elements
* Handle empty stack conditions

### Queue Operations

* Enqueue elements
* Dequeue elements
* Peek at the front element
* Display queue elements
* Handle empty queue conditions

### Linked List Operations

* Insert elements
* Delete elements
* Search for elements
* Display linked list elements

### Searching Operations

* Linear Search
* Binary Search
* Compare search steps and execution time

### Graph Operations

* Add vertices
* Add edges
* Display the graph
* Breadth-First Search (BFS)
* Depth-First Search (DFS)
* Find shortest paths, if supported by the implementation

### Performance Analysis

* Compare Linear Search and Binary Search
* Compare array and linked list operations
* Measure algorithm execution time
* Count algorithm steps
* Demonstrate algorithmic complexity

### Additional Features

* Menu-driven console interface
* User input handling
* Result logging
* Performance comparison reports

## 4. Project Structure

```text
CIT300_DS_Graph_Analyzer/
│
├── ArrayOperations.java
├── SearchOperations.java
├── MyStack.java
├── MyQueue.java
├── MyLinkedList.java
├── Graph.java
├── InputHelper.java
├── Main.java
├── PerformanceAnalyzer.java
├── ResultLog.java
├── run.bat
└── README.md
```

## 5. Team Members and Responsibilities

### Member 1

**Student Name:** H W N Sewwandi
**Student ID:** 23DA2-0047
**Assigned Responsibility:** Array and Searching Operations

**Individual Contribution:**

* Worked on array operations.
* Implemented or contributed to Linear Search and Binary Search.
* Tested searching functionality and compared search results.

### Member 2

**Student Name:** M D I Asunthara De Silva
**Student ID:** 23DA2-0002
**Assigned Responsibility:** Stack and Queue Operations

**Individual Contribution:**

* Worked on stack operations.
* Worked on queue operations.
* Tested push, pop, peek, enqueue, and dequeue operations.
* Checked empty data structure conditions.

### Member 3

**Student Name:** H M S Pramodaya
**Student ID:** 23DA2-0117
**Assigned Responsibility:** Linked List and Graph Operations

**Individual Contribution:**

* Worked on linked list operations.
* Worked on graph representation and operations.
* Implemented or contributed to BFS and DFS traversal.
* Tested graph functionality and traversal results.

### Member 4

**Student Name:** K D Himasha Darshani
**Student ID:** 23DA2-0227
**Assigned Responsibility:** Main Menu, Integration, and Performance Analysis

**Individual Contribution:**

* Worked on the main menu and system integration.
* Worked on performance comparison and result logging.
* Assisted with input handling and application testing.
* Prepared the project documentation and README.

**Note:** The individual contributions above must be reviewed and updated to match the work actually completed by each member.

## 6. How to Run the Application

### Requirements

* Java Development Kit (JDK) installed
* Windows Command Prompt or PowerShell

### Method 1: Using the Batch File

1. Download or clone the project repository.
2. Open the project folder in Windows.
3. Open Command Prompt or PowerShell in the project folder.
4. Run the following command:

```powershell
.\run.bat
```

5. Select an option from the main menu.
6. Follow the instructions displayed by the application.

### Method 2: Using Java Commands

If the source files are in the current directory, compile them using:

```bash
javac *.java
```

Then run the application using:

```bash
java Main
```

If the project uses Java packages or a different directory structure, adjust the commands accordingly.

## 7. Main Menu

The application provides the following main menu:

```text
=============================================
       DATA STRUCTURE & GRAPH ANALYZER
=============================================
1. Array Operations
2. Stack Operations
3. Queue Operations
4. Linked List Operations
5. Searching Operations
6. Graph Operations
7. Performance Comparison
8. Display All Results
9. Exit
Enter your choice:
```

## 8. Algorithmic Complexity

The application demonstrates the following common time complexities:

| Algorithm / Operation             | Typical Time Complexity            |
| --------------------------------- | ---------------------------------- |
| Linear Search                     | O(n)                               |
| Binary Search on a sorted array   | O(log n)                           |
| Array insertion at the front      | O(n)                               |
| Linked list insertion at the head | O(1)                               |
| Stack push and pop                | O(1)                               |
| Queue enqueue and dequeue         | O(1) for a suitable implementation |
| BFS                               | O(V + E)                           |
| DFS                               | O(V + E)                           |

Here, **n** represents the number of elements, **V** represents the number of vertices, and **E** represents the number of edges.

Actual performance depends on the implementation, input data, and computer environment.

## 9. Performance Comparison

The Performance Comparison module demonstrates algorithm performance using operation counts and execution time.

Execution time may vary between runs because of computer hardware, Java Virtual Machine behaviour, and system load. Therefore, operation counts and theoretical complexity should also be considered when comparing algorithms.

## 10. Testing

The following functionality has been tested during development:

* Array insertion, deletion, searching, and sorting
* Stack push, pop, peek, and display
* Queue enqueue, dequeue, peek, and display
* Linked list insertion, deletion, searching, and display
* Linear Search and Binary Search
* Graph vertex and edge operations
* BFS and DFS traversal
* Performance comparison
* Displaying recorded results
* Exiting the application

## 11. GitHub Collaboration

The project is maintained using Git and GitHub.

Team members should contribute to their assigned modules and use meaningful commits. Branches and pull requests can be used to manage individual work and integrate changes into the main project.

Each member is responsible for understanding and explaining their own contribution during the demonstration.

## 12. Demonstration Video

One merged demonstration video will be prepared for submission.

The video will demonstrate:

* Team member introductions
* Individual responsibilities and contributions
* Relevant source code
* Program functionality
* Data structures and algorithms
* Performance and complexity comparisons
* Integration with the complete application

Each member must ensure that their face is clearly visible during their respective presentation. The final merged video must be less than 15 minutes.

## 13. Assignment Information

**Module:** CIT300 – Data Structures and Algorithms
**Assignment:** Graded Practical Assignment 2 – Week 12
**Project:** Data Structure & Graph Performance Analyzer
**Programming Language:** Java
**Application Type:** Console-Based System



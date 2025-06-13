# Directory Lister

## Description

Directory Lister is a Java console application that recursively scans a specified directory and saves the list of files and folders to a text file with configurable depth settings.

## Features

- Recursive directory traversal with controlled depth
- File filtering (ignores the output results file)
- Input path validation
- Flexible architecture using interfaces
- Automatic resource management
- Clean and readable output with indentation for nested items

## Requirements

- Java 8 or newer
- Gradle 8.10 (for building)

## Build and Run

1. Build the project:
```bash  
./gradlew build  
```  

2. Run the application:
```bash  
java -jar build/libs/DirectoryLister-1.0-SNAPSHOT.jar  
```  

## Usage

After launching, the application will prompt for:
1. The directory path to scan
2. The traversal depth (0 = current directory only)
3. The output filename (without extension)

The result will be saved in the specified directory as a `.txt` file.

## Example Output

```  
List of files and folders in directory: /path/to/directory  
Date: 2025-06-13 20:15:30  
Traversal depth: 2  

[D] folder1  
  [F] file1.txt  
  [D] subfolder  
    [F] subfile.txt  
[F] file2.txt  
```  

## Project Structure

```  
src/main/java/dev/cheercode/  
├── Main.java                    - Entry point  
├── core/  
│   └── DirectoryLister.java     - Core traversal logic  
├── io/  
│   ├── ConsoleInputReader.java  - Console input handling  
│   ├── FileListWriter.java      - Output interface  
│   ├── InputReader.java         - Input interface  
│   └── TextFileListWriter.java  - Text file writer  
└── validation/  
    ├── DirectoryValidator.java  - Validation interface  
    └── SimpleDirectoryValidator.java - Validator implementation  
```
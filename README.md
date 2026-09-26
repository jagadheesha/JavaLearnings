# JavaLearnings

A collection of small Java programs and IntelliJ IDEA projects for practicing core Java, collections, file handling, JDBC, serialization, and introductory web development.

## Projects

| Directory | Topics / examples |
| --- | --- |
| `Abstract` | Abstract classes, employee models, and salary calculations |
| `ArrayList` | `ArrayList` usage and constructors |
| `Collections` | Java Collections Framework examples |
| `colllection` | Custom and car collection examples |
| `demo` | Basic Java programs and number triangles |
| `EmployeeReg` | Employee registration and salary classes |
| `fileoutputstream` | File output and Java object serialization |
| `jdbcconnect` | JDBC connection and employee management |
| `jdbcconnection` | JDBC examples, array encoding/decoding, and string building |
| `Map` | Java `Map` examples |
| `MyWebPage` | Maven-based Java project targeting Java 17 |
| `sample` | File creation, reading, writing, and directory listing |
| `Servletdemo1` | Servlet/JSP-related examples |
| `Setinterface` | Java `Set` interface examples |
| `Sumof` | Date, age, and common-value examples |
| `TrainMapPro` | Map-based Java practice project |

## Requirements

- JDK 17 or newer
- IntelliJ IDEA (recommended for the `.iml` projects)
- Maven, if working with `MyWebPage`
- A JDBC-compatible database and driver for the JDBC examples

## Getting started

1. Clone the repository and open the repository root in IntelliJ IDEA.
2. Select a project directory and mark its `src` directory as the sources root if IntelliJ does not detect it automatically.
3. Open the relevant `Main.java` file and run it from the IDE.

The projects are independent exercises. There is no single root build command for all directories.

## Maven project

To compile the Maven project:

```bash
cd MyWebPage
mvn compile
```

## JDBC examples

The JDBC projects expect database configuration and a suitable JDBC driver. Review `jdbcconnect/src/DBConnection.java` or the corresponding connection class in `jdbcconnection` before running those examples.

## Repository layout

Most exercises use this layout:

```text
<ProjectName>/
├── <ProjectName>.iml
└── src/
    └── *.java
```

Generated build output and IDE-specific files should remain uncommitted according to each project’s ignore rules.

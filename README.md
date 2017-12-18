# Student Tracker Web App

**An fully functional JSP/Servlet web application connected to MySQL database for University Student Record Management.**

### Application feature include:
- List Students
- Add New Students
- Update information for exisiting Students
- Delete Student record

Web application follows MVC architecture seperating input, processing and output of for the application.

### Files performing MVC functionality:
- Model - StudentDbUtl.java
- View - JSP pages
- Controller - StudentControlServlet.java

### Student Class attributes: 
- Student's First Name
- Student's Last Name
- Student's Email ID
- Is Student a Graduate Student or not(boolean attribute)

#### Application can be excecuted by running **StudentControlServlet.java**

### Database Connection and Access:

Database **connection parameters are initialized into MysqlDataSource Object in StudentControlServlet.java** and connection object is passed to
StudentDbUtil to establish database connection for data access.

Browser request is processed by StudentControlServlet that calls appropriate StudentDbUtil methods for database access.

StudentControlServlet.java performs data processing on data(Student Object) returned by StudentDbUtil and forwards data to JSP pages attached to request attributes.
JSP pages provides updated view of CRUD operation results.

**Excecute the file - db.sql in MySQL to get schema and some default data for the Web App**

### Configuration stack:
- Java version: Java 9
- Server: Apache Tomcat 8.5
- DataBase: MySQL
- IDE: Eclipse Oxygen

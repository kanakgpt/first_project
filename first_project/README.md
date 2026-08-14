# first_project - Student/Course PostgreSQL API

This project now stores student data in PostgreSQL (no in-memory HashMap).

## Tech
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Lombok

## Database configuration
Configured in `src/main/resources/application.properties`:
- username: `root`
- password: `postgres`
- schema: `student`
- database: `postgres`

`src/main/resources/schema.sql` creates schema and recreates tables on startup.

## Tables
- `student.courses`
- `student.students`
- `student.student_courses` (many-to-many relation)

## APIs
### Course APIs
- `POST /api/courses`
- `GET /api/courses`
- `GET /api/courses/{courseId}`

Sample create course payload:
```json
{
  "courseId": "C101",
  "courseName": "Mathematics"
}
```

### Student APIs
- `POST /api/student`
- `GET /api/student`
- `GET /api/student/{studentId}`
- `PUT /api/student/{studentId}`
- `DELETE /api/student/{studentId}`

Sample create student payload:
```json
{
  "studentId": "S001",
  "studentName": "John",
  "address": "Delhi",
  "courseIds": ["C101", "C102"]
}
```

## Exception handling
Global exception handling is implemented with:
- `ResourceNotFoundException`
- `GlobalExceptionHandler`
- structured API error response (`ApiErrorDto`)


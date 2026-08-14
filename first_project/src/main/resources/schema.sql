CREATE SCHEMA IF NOT EXISTS student;

DROP TABLE IF EXISTS student.student_courses;
DROP TABLE IF EXISTS student.students;
DROP TABLE IF EXISTS student.courses;

CREATE TABLE student.courses (
    course_id VARCHAR(100) PRIMARY KEY,
    course_name VARCHAR(255) NOT NULL
);

CREATE TABLE student.students (
    student_id VARCHAR(100) PRIMARY KEY,
    student_name VARCHAR(255) NOT NULL,
    address VARCHAR(500) NOT NULL
);

CREATE TABLE student.student_courses (
    student_id VARCHAR(100) NOT NULL,
    course_id VARCHAR(100) NOT NULL,
    PRIMARY KEY (student_id, course_id),
    CONSTRAINT fk_student_courses_student
        FOREIGN KEY (student_id)
        REFERENCES student.students(student_id)
        ON DELETE CASCADE,
    CONSTRAINT fk_student_courses_course
        FOREIGN KEY (course_id)
        REFERENCES student.courses(course_id)
        ON DELETE CASCADE
);


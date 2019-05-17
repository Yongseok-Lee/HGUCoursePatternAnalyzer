package edu.handong.analysis;

import edu.handong.analysis.datamodel.Course;
import edu.handong.analysis.datamodel.Student;
import java.util.ArrayList;

public class HGUCoursePatternAnalyzer
{	
	String[] lines = {	"1999-1, JC Nam, Java Programming",
						"1999-2, JC Nam, Programming Language Theory",
						"1999-1, JC Nam, Data Structures",
						"2001-1, JC Nam, Database Systems",
						"2018-1, SB Lim, Java Programming",
						"2018-2, SB Lim, Programming Language Theory",
						"2019-1, SB Lim, Data Structures",
						"2019-1, SB Lim, Algorithm Analysis",
						"2018-1, SJ Kim, Java Programming",
						"2018-2, SJ Kim, Programming Language Theory",
						"2019-1, SJ Kim, Logic Design",
						"2019-1, SJ Kim, Algorithm Analysis",
						};

	private int numOfStudents;
	private int numOfCourses;
	private ArrayList<Student> students;
	private ArrayList<Course> courses;
	
	/**
	 * This method runs our analysis logic to get the list of student and course names from lines.
	 * @param args
	 */
	public void run(String[] args)
	{	
		this.numOfStudents = Integer.parseInt(args[0]);
		this.numOfCourses = Integer.parseInt(args[1]);
		this.students = this.initiateStudentArrayFromLines(this.lines);
		this.courses = this.initiateCourseArrayFromLines(this.lines);
		
		
		System.out.println("Number of All Students: " + this.numOfStudents);
		
		for (Student student: this.students)
		{
			if (student != null)
			{
				System.out.println(student.getName());
			}
		}
		
		
		System.out.println("Number of All Courses: " + this.numOfCourses);
		
		for (Course course: this.courses)
		{
			if (course != null)
			{
				System.out.println(course.getCourseName());
			}
		}
	}

	/**
	 * This method returns a Student array to initiate the field, students, from lines.
	 * @param lines
	 * @return Student[]
	 */
	private ArrayList<Student> initiateStudentArrayFromLines(String[] lines)
	{	
		// TODO: implement this method
		int numOfLines = 0;
		
		for (String line : lines)
		{
			numOfLines++;
		}
		
		
		ArrayList<Student> temp = new ArrayList<Student>();
		
		for (int i = 0; i < numOfLines; i++)
		{
			Student student = new Student(lines[i].split(", ")[1]);
			
			if (!studentExist(temp, student))
			{
				temp.add(student);
			}
		}
		
		
		this.students = new ArrayList<Student>();

		for (Student student : temp)
		{
			if (student != null)
			{
				this.students.add(student);
			}
		}
		
		
		return this.students;
	}

	/**
	 * This method check if there is the same name of the second argument in the array, students
	 * @param students
	 * @param student
	 * @return boolean
	 */
	private boolean studentExist(ArrayList<Student> students, Student student)
	{	
		// TODO: implement this method
		for (Student student_ : students)
		{
			if (student_ != null && student.getName().equals(student_.getName()))
			{
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * This method returns a Course array to initiate the field, courses, from lines.
	 * @param lines
	 * @return Course[]
	 */
	private ArrayList<Course> initiateCourseArrayFromLines(String[] lines)
	{
		// TODO: implement this method
		int numOfLines = 0;
		
		for (String line : lines)
		{
			numOfLines++;
		}
		
		
		ArrayList<Course> temp = new ArrayList<Course>();
		
		for (int i = 0; i < numOfLines; i++)
		{
			Course course = new Course(lines[i].split(", ")[2]);
			
			if (!courseExist(temp, course))
			{
				temp.add(course);
			}
		}
		
		
		this.courses = new ArrayList<Course>();

		for (Course course : temp)
		{
			if (course != null)
			{
				this.courses.add(course);
			}
		}

		
		return this.courses;
	}

	/**
	 * This method check if there is the same name of the second argument in the array, courses.
	 * @param courses
	 * @param course
	 * @return boolean
	 */
	private boolean courseExist(ArrayList<Course> courses, Course course)
	{	
		// TODO: implement this method
		for (Course course_ : courses)
		{
			if (course_ != null && course.getCourseName().equals(course_.getCourseName()))
			{
				return true;
			}
		}
		
		return false;
	}
}
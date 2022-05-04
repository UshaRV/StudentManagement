package CollegeManagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.manage.Student;
import com.student.manage.StudentDao;

public class Start {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Student Mangement App");
		while (true) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Press 1 to ADD STUDENT");
			System.out.println("Press 2 to Delete STUDENT");
			System.out.println("Press 3 to Display STUDENT");
			System.out.println("Press 4 to exit app");
			int c = Integer.parseInt(br.readLine());
			if (c == 1) {
				// add student
				System.out.println("Enter username:");
				String name = br.readLine();
				System.out.println("Enter user phone number:");
				String phone = br.readLine();
				System.out.println("Enter user city name:");
				String city = br.readLine();

				// create student object to store student
				Student st = new Student(name, phone, city);
				boolean answer = StudentDao.insertStudentToDB(st);
				if (answer) {
					System.out.println("student is added successfully");
				} else {
					System.out.println("Something Went wrong");
				}
				System.out.println(st);

			} else if (c == 2) {
				System.out.println("Enter StudentID to delete:");
			 int userId=Integer.parseInt(br.readLine());
			boolean f=  StudentDao.deleteStudent(userId);
			if(f) {
				System.out.println("deleted....");
			}
			else {
				System.out.println("something went wrong");
			     }
			}

			else if (c == 3) {
				// display student
			   StudentDao.showAllStudent();
			} else if (c == 4) {
				// exit
				break;
			} else {

			}

		}
		System.out.println("Thankyou for using my application");
		System.out.println("see you soon");

	}
}

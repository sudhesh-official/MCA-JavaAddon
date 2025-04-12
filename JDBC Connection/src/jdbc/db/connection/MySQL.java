package jdbc.db.connection;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class MySQL {

	public static void main(String[] args) {
		/*
		 * emp_id, emp_name, emp_age, emp_city, emp_mno
		 */
		Scanner scanner = new Scanner(System.in);

		// JDBC Connection URLS :
		String url = "jdbc:mysql://localhost:3306/users?characterEncoding=utf8";
		String username = "root";
		String password = "root";
		
		int id, age;
		String name, city;
		long mnum;
		
		String qry = "";

		try {

			int option = 1;

			while (option != 9) {
				
				Connection connection = DriverManager.getConnection(url,username,password);
				
				Statement statement = connection.createStatement();
				ResultSet resultSet;
				
				PreparedStatement preparedStatement;
				
				System.out.println("\nMySQL Database Connectivity....");
				System.out.println("\t1. Insert data,");
				System.out.println("\t2. Update data,");
				System.out.println("\t3. View data,");
				System.out.println("\t4. Delete data,");
				System.out.println("\t9. Quit");
				System.out.println("\nEnter Your Choice : ");
				option = scanner.nextInt();

				switch (option) {
				case 1:
					System.out.printf("\nInsert data,");
					scanner.nextLine();
					System.out.printf("\nEnter your name : ");
					name = scanner.nextLine();
					System.out.printf("Enter Your age  : ");
					age = scanner.nextInt();
					scanner.nextLine();
					System.out.printf("Enter Your city : ");
					city = scanner.nextLine();
					System.out.printf("Enter Your mnum : ");
					mnum = scanner.nextLong();
					
					// qry = "INSERT INTO `users`.`emplyee` (`emp_name`, `emp_age`, `emp_city`, `emp_mno`) VALUES ('abc', '12', 'abc', '7894561230')";
					qry = "INSERT INTO users.emplyee (emp_name, emp_age, emp_city, emp_mno) VALUES (?, ?, ?, ?)";
					preparedStatement = connection.prepareStatement(qry); 
					
					preparedStatement.setString(1, name);
					preparedStatement.setInt(2, age);
					preparedStatement.setString(3, city);
					preparedStatement.setLong(4, mnum);
					preparedStatement.executeUpdate();
					
					System.out.println("\nYour Data Save DONE....");
					
					break;
				case 2:
					System.out.println("\nUpdate data,");
					
					System.out.printf("\nEnter the Update Id : ");
					id = scanner.nextInt();
					scanner.nextLine();
					System.out.printf("Enter your name : ");
					name = scanner.nextLine();
					System.out.printf("Enter Your age  : ");
					age = scanner.nextInt();
					scanner.nextLine();
					System.out.printf("Enter Your city : ");
					city = scanner.nextLine();
					System.out.printf("Enter Your mnum : ");
					mnum = scanner.nextLong();
					
					qry = "UPDATE users.emplyee SET emp_name = ?, emp_age = ?, emp_city = ?, emp_mno = ? WHERE (emp_id = ?)";
					
					preparedStatement = connection.prepareStatement(qry);
					preparedStatement.setString(1, name);
					preparedStatement.setInt(2, age);
					preparedStatement.setString(3, city);
					preparedStatement.setLong(4, mnum);
					preparedStatement.setInt(5, id);
					preparedStatement.executeUpdate();
					
					System.out.println("\nYour Data Update DONE....");
					break;
				case 3:
					System.out.println("\nView data,");
					qry = "SELECT * FROM users.emplyee";
					resultSet = statement.executeQuery(qry);
					
					while (resultSet.next()) {
						id = resultSet.getInt("emp_id");
						name = resultSet.getString("emp_name");
						age = resultSet.getInt("emp_age");
						city = resultSet.getString("emp_city");
						mnum = resultSet.getLong("emp_mno");
						
						System.out.println(id + ", " + name + ", " + age + ", " + city + ", " + mnum);
					}
					break;
				case 4:
					System.out.println("\nDelete data,");
					
					System.out.printf("\nEnter Deleting Id : ");
					id = scanner.nextInt();
					
					qry = "DELETE FROM users.emplyee WHERE (emp_id = ?)";
					
					preparedStatement = connection.prepareStatement(qry);
					preparedStatement.setInt(1, id);
					preparedStatement.executeUpdate();
					
					System.out.println("Data Delete Success...");
					break;
				case 9:
					System.out.println("\n\nProgram ends now....");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid Option try again...");
					break;
				}
			}

		} catch (Exception e) {
			System.out.println("\n\nError :- " + e.getMessage());
		}

	}

}

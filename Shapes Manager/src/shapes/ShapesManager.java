package shapes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ShapesManager {
	
	public enum shapeTypes {Square, Rectangle, Cube, Circle};
	String shapesFileName = "C:\\Users\\rsudh\\OneDrive\\Desktop\\MCA\\Shapes Manager\\src\\shapes.txt";
	ArrayList<Shape> shapes = new ArrayList<>();
	
	// Add Shapes.
	public boolean AddShape(shapeTypes type) {
		Shape s = null;
		switch (type) {
		case Square:
			s = new Square();
			break;
		case Rectangle:
			s = new Rectangle();
			break;
		case Cube:
			s = new Cube();
			break;
		case Circle:
			s = new Circle();
			break;
		}
		s.getInput();
		// System.out.println(s.toCSVString());
		// s.deserialize(s.toCSVString());
		shapes.add(s);
		// This calls toString() of the shape
		// System.out.println(shapes); 
		AddShape2File(s);
		s = null; 
		return true;
	}

	// Add Shape to the File.
	private void AddShape2File(Shape s) {
		FileWriter f = null;
		try {
			f = new FileWriter(shapesFileName, true);
			BufferedWriter bw = new BufferedWriter(f);
			bw.write(s.toCSVString());
			bw.newLine();
			bw.close();
			f.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			f = null;
		}
	}
	
	public void ListShapes() {
		// System.out.println("List of Shapes");
		/*
		for(Shape s: shapes) {
			System.out.println(s.toString());
		} */
		try {
			BufferedReader reader = new BufferedReader(new FileReader(shapesFileName));
			String line;
			 System.out.println("List of Shapes from File:");
			 while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			 reader.close();
		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}
	}
	
	public void deleteShape() {
	}
	
	public void getShape() {
	}
	
	
	
	
	
}

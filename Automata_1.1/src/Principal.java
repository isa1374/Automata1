import java.io.BufferedReader; 
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.LineNumberReader; 
import java.util.ArrayList;

public class Principal {
	
	static ArrayList <String>trans;
	public static void main(String[] args) {
		try{
			File file = new File("C:/Users/isha1_000/Documents/Isa/ITC/7to Semestre/Matemáticas Computacionales/Proyecto/PrimeraParte/A1.txt");
			FileReader frd = new FileReader(file); 
			BufferedReader rd = new BufferedReader(frd); 
			LineNumberReader num = new LineNumberReader(frd);
			
			String line; 
			
			String [] estados = null;
			String [] simb = null; 
			String [] inicio = null; 
			String [] fnl = null;

			
			//Lectura del doc y llenado de arreglos
			do{
				switch (num.getLineNumber()){
					case 0:
						line= num.readLine(); 
						//System.out.println(line);
						estados = line.split(","); 
						//System.out.println(estados[0].toString());
						//System.out.println(estados[1].toString());
						//System.out.println(estados[2].toString());
					case 1: 
						line= num.readLine();
						//System.out.println(line);
						simb= line.split(","); 
						//System.out.println(simb[0].toString());
						//System.out.println(simb[1].toString());
					case 2: 
						line = num.readLine(); 
						//System.out.println(line); 
						inicio = line.split(","); 
						//System.out.println(inicio[0].toString());
					case 3: 
						line = num.readLine(); 
						//System.out.println(line); 
						fnl = line.split(","); 
						//System.out.println(fnl[0].toString());
						
					default:
						line=num.readLine(); 
						trans.add(line);
				}
			}while ((num.readLine()) != null); 
			
			trans.get(0);
			
			num.close();
		}
		catch (IOException e){
			
		}
		
		
		
	}

}

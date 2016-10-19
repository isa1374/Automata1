import java.io.BufferedReader; 
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.LineNumberReader; 

public class Principal {

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
			String [] trans = null; 
			int countLine=0; 
			
			while((num.readLine())!= null){
				countLine++;
			}
			
			//Lectura del doc y llenado de arreglos
			while ((num.readLine()) != null){
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
						break;
				}
			}; 
			
			
			num.close();
		}
		catch (IOException e){
			
		}
		
		
	}

}

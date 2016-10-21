import java.io.BufferedReader; 
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.LineNumberReader; 
import java.util.ArrayList;
import java.util.HashMap; 

public class Principal {
	static ArrayList <String> trans = new ArrayList<String>();
	public static void main(String[] args) {
		
		String [] estados = null;
		String [] alf = null; 
		String [] inicio = null; 
		String [] fnl = null;
		
	
		try{
			File file = new File("C:/Users/isha1_000/Documents/Isa/ITC/7to Semestre/Matemáticas Computacionales/Proyecto/PrimeraParte/A1.txt");
			FileReader frd = new FileReader(file); 
			BufferedReader rd = new BufferedReader(frd); 
			LineNumberReader num = new LineNumberReader(frd);
			
			String line="";
			//Lectura del doc y llenado de arreglos
				while(line!=null){
					switch(num.getLineNumber()){
					case 0: 
						line=num.readLine();
						//System.out.println(line);
						estados=line.split(",");
						//System.out.println(estados[0].toString());
						//System.out.println(estados[1].toString());
						//System.out.println(estados[2].toString());
						break;
					case 1: 
						line=num.readLine();
						//System.out.println(line);
						alf=line.split(",");
						//System.out.println(alf[0].toString());
						//System.out.println(alf[1].toString());
						break;
					case 2: 
						line=num.readLine();
						//System.out.println(line); 
						inicio=line.split(",");
						//System.out.println(inicio[0].toString());
						break;
					case 3: 
						line=num.readLine();
						//System.out.println(line);
						fnl=line.split(",");
						//System.out.println(fnl[0].toString());
						break;
					default:
						line=num.readLine();
						trans.add(line);
						//System.out.println(line);		
					}
				};
			num.close();
		}
		catch (IOException e){
			System.out.println("Error");
		}
		
		//Separación 
		HashMap<String,HashMap<String, String>> pr= new HashMap<>(); 
		HashMap<String, String> hm = new HashMap<>(); 
		
		String [] aux; 
		String [] aux2 = null;
		
		for(int i=0; i<trans.size(); i++){
			hm=new HashMap<>();
			if(trans.get(i)!= null){
				aux=trans.get(i).split("->"); 
				aux2=aux[0].split(","); 
				hm.put(aux2[1].toString(), aux[1].toString());
				//System.out.println(hm.entrySet());
				pr.put(aux2[0],	 hm);
				System.out.println(pr.entrySet());
			};
		}
	}
	
}

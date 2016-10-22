import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.*;


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
		ListMultimap<String,HashMap<String,String>> pr = ArrayListMultimap.create();
		HashMap<String,String> me= new HashMap<>(); 
		
		String[]aux=null;
		String[]aux2=null; 
		
		for(int i=0; i<trans.size(); i++){
			me= new HashMap<>();
			if(trans.get(i)!=null){
				aux= trans.get(i).split("->"); 
				aux2=aux[0].split(","); 
					
				me.put(aux2[1].toString(), aux[1].toString()); 
				//System.out.println(me.entrySet());
				pr.put(aux2[0].toString(), me);
			}
		}
		//Print Map
		for(String key: pr.keySet()){
			List<HashMap<String, String>> list = (List<HashMap<String,String>>)pr.get(key);
			for(int m=0; m<list.size();m++){
				System.out.println(key +"="+list.get(m));
				
			}
		}
		
		//new HashMap con un arrayList con los estados resultantes
		
		
	}
	
}

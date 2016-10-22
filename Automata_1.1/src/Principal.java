import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.common.collect.*;


public class Principal {
	static ArrayList <String> trans = new ArrayList<String>();
	static ArrayList <String> nuevosEstados=new ArrayList<>();
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
		//Separación en un mapeo múltiple
		ListMultimap<String,HashMap<String,String>> pr = ArrayListMultimap.create();
		HashMap<String,String> me= new HashMap<>(); 
		
		String[]aux=null;
		String[]aux2=null; 
		
		
		for(int i=0; i<trans.size(); i++){
			me= new HashMap<>();
			if(trans.get(i)!=null){
				aux= trans.get(i).split("->"); 
				aux2=aux[0].split(","); 
				boolean con=nuevosEstados.contains(aux[1].toString());
				if(con != true){
					nuevosEstados.add(aux[1].toString());
				}
				me.put(aux2[1].toString(), aux[1].toString()); 
				//System.out.println(me.entrySet());
				pr.put(aux2[0].toString(), me);
			}
		}
		//Print Map
		/*for(String key: pr.keySet()){
			System.out.println(key +"="+ pr.get(key));
		}*/
		
		//Lista estados finales comprobación 
		/*for(int m=0; m<nuevosEstados.size();m++){
			System.out.println(nuevosEstados.get(m));
		}*/
		
		//Tabla de transiciones 
		System.out.println("Tabla de transiciones");
		String tabla [][]= new String[estados.length+1][alf.length+1];
		int o,p=1; 
		tabla[0][0]=null;
		for(o=1; o<estados.length+1; o++){
			tabla[o][0]=estados[o-1].toString();
			for(p=1; p<alf.length+1;p++){
				tabla[0][p]=alf[p-1].toString();
			}
		}
		for(String[] row: tabla ){
			printRow(row);
		}
		
		//Mapa de transiciones finales 
		ListMultimap<String,HashMap<String,String>> tfinl = ArrayListMultimap.create();
		HashMap<String,String> mox= new HashMap<>();
		
		ArrayList<String>ef= new ArrayList<>();
		int b,h=0; 
		String []help;

		for(b=0; b<nuevosEstados.size(); b++){
			for(h=0; h<alf.length; h++){
				if(pr.containsKey(nuevosEstados.get(b))==true&& me.containsKey(alf[h].toString())==true){
					mox.put(alf[h].toString(), me.get(alf[h].toString()));
					tfinl.put(nuevosEstados.get(b), mox);
				}else{
					help=nuevosEstados.get(b).split(","); 
					for(int ne=0; ne<help.length; ne++){
						if(pr.containsKey(help[ne].toString())==true && (me.containsKey(alf[h])==true)){
							mox.put(alf[h], me.get(alf[h].toString()));
							tfinl.put(help[ne].toString(), mox);
						}
					}
				}
			}
		}
		for(String key: tfinl.keySet()){
		System.out.println(key +"="+ tfinl.get(key));
		}
		
	
	}
	public static void printRow(String[]row){
		for(String i: row){
			System.out.print(i);
			System.out.print("\t");
		}
		System.out.println();
	}
}

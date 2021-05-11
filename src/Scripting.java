import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;


public class Scripting {

	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);
	     String frase;
	     System.out.print("Ingresar la frase : ");
	     frase = sc.nextLine();
	     frase = frase.replaceAll("\\p{Punct}", "");
	    	 System.out.println("Palabras= " + CantidadDePalabras(frase));
		     System.out.println("Frecuencia= " + PalabraRepetidas(frase));
		     System.out.println("Top - 5= " + top5(frase));  
			JOptionPane.showMessageDialog(null,"Se finalizo el proceso.");

	}
	
	public static int CantidadDePalabras(String frase) {
		 StringTokenizer st = new StringTokenizer(frase);
	     int CantPalabras = st.countTokens();
	     return CantPalabras;
	}
	 
	 public static String PalabraRepetidas (String frase){
		 String[] lista = obtenerlista(frase);
		 List<String> listaLimpia =cleanList(lista);
	     String[] lista2 = new String[listaLimpia.size()];
	     lista2 = (listaLimpia.toArray(lista2));
	     String frecuencia = "" ;
	     if(lista2.length==0) {
	    	 return "No hay palabras repetidas";
	     }
		for(int i=0;i<lista2.length;i++) {
			String[] linea=lista2[i].split("-");
			frecuencia= frecuencia +"'"+linea[1]+"'"+"("+linea[0]+")";
			if(i<lista2.length-1) {
				frecuencia = frecuencia+", ";
			}else {
				frecuencia = frecuencia+".";
			}
		}
		return frecuencia;
	 }
	 
	 public static String top5 (String frase){
		 String[] lista = obtenerlista(frase);
		 List<String> listaLimpia =cleanList(lista);
	     String[] lista2 = new String[listaLimpia.size()];
	     lista2 = (listaLimpia.toArray(lista2));
	     String top5 = "" ;
	     if(lista2.length==0) {
	    	 return "No hay top 5";
	     }
	     int i=0;
		while(i<lista2.length&&i<5) {
			String[] linea=lista2[i].split("-");
			top5= top5 +"'"+linea[1]+"'"+"("+linea[0]+")";
			if(i<4 || i<lista2.length) {
				top5 = top5+", ";
			}else {
				top5 = top5+".";
			}
			i++;
		}
		return top5;
	 }
	 /*
	  * METHODs
	  */
	 public static String[] obtenerlista (String frase){
		 StringTokenizer st = new StringTokenizer(frase);
	     int CantPalabras = st.countTokens();
	     String []palabras = frase.split(" ");
	     String[] resultado = new String[CantPalabras];
	    for(int i=0;i<CantPalabras;i++) {
	    int contador = 0;
	    String str1 = st.nextToken().toString().toLowerCase();
	    for(int a=0;a<CantPalabras;a++) {
		    String str2 = palabras[a].toLowerCase();

		    if(str1.equals(str2) ){
		    	contador++;
		    }   
	    }
	    String resp = String.valueOf(contador)+"-"+str1;
	    resultado[i] = resp;
	    }
		return resultado;		 
	 }
	 
	 
	 public static List<String> cleanList(String [] lista) {
		 List<String> lista2 = new ArrayList<>();
		 //ordeno de mayor a menor
		 Arrays.sort(lista,Collections.reverseOrder());

		//limpio repetidos
		 for (String s : lista) {
			 if(!lista2.toString().contains(s)) {
				//elimino los iguales a 1
				String s2=s.substring(0,s.indexOf("-"));
				 if(!s2.equals("1")) {
					 lista2.add(s); 
				 }
				 
			 }
		 }
		 return lista2;
	 }

}

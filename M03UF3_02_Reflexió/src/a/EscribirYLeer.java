/**
 * M03UF3  Fitxers. Reflexió.
 * 
 * Accés Reflexiu a parámetres (variables)
 */
package a;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;

public class EscribirYLeer
{
	static String nomFitxer = ".\\src\\a\\reflx.dat";
	//static String nomFitxer = "mascotas.dat";
    public static void main(String[] args)
    {
        EscribirYLeer eyl = new EscribirYLeer();
        eyl.escribeFichero(nomFitxer);
        eyl.leeFichero(nomFitxer);
    }

    public void escribeFichero(String fichero)
    {
        try
        {

            FileWriter fw = new FileWriter(nomFitxer);
            BufferedWriter bw = new BufferedWriter(fw);
            
            Field[] fields = Persona.class.getFields();  //Fields son tots els paràmetres PUBLICS d'una classe
            String s = "";
            for(Field f : fields) {
            	s+=f.getName()+";"; //getname et torna el nom de la variable. Si, el nom que tu has posat al codi font.
            }
            bw.write(s);
            bw.newLine();
            
            
            for(int i=0;i<5;i++) {
            	Persona p = new Persona(i);
            	s = "";
                for(Field f : fields) {
                	s+=f.get(p)+";";  //get(objecte) et torna el valor de la variable.
                }
                bw.write(s);
                bw.newLine();
            }
            bw.flush();
            
            
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void leeFichero(String fichero)
    {
        try
        {
        	
            FileReader fr = new FileReader(nomFitxer);
            BufferedReader br = new BufferedReader(fr);
            
            String[] cabeceras = br.readLine().split(";"); //El mètode split ens tornara un array de totes les Strings entre els ";", sense posar els ";".
            while(br.ready()) {  //El Reader estara llest mentre no s'arribi al EOF...
            	String[] linea = br.readLine().split(";");
            	Persona p = new Persona(0);
            	for(int i=0;i<linea.length;i++) {
            		Field f = p.getClass().getField(cabeceras[i]);
            		switch(f.getType().toString()) {   //getType et torna el tipus de la variable.
            		case "class java.lang.String":
            			f.set(p, linea[i]);
            			break;
            		case "int":
            			f.set(p, Integer.parseInt(linea[i]));
            			break;
            		case "double":
            			f.set(p, Double.parseDouble(linea[i]));
            			
            		}
            	}
            	System.out.println(p);
            	
            	
            }
            
            
            
            
        }
        catch (Exception e2)
        {
            e2.printStackTrace();
        }
    }
}

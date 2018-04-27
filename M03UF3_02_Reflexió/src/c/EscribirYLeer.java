/**
 * M03UF3  Fitxers. Reflexió.
 * 
 * Codi Automodificable.
 * 
 * Abandon all hope ye who enter here.
 */
package c;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.*;
import java.util.Random;

import b.Robot;

public class EscribirYLeer
{
	static String nomFitxer = ".\\src\\a\\reflx.dat";
	//static String nomFitxer = "mascotas.dat";
    public static void main(String[] args)
    {
    	
        EscribirYLeer eyl = new EscribirYLeer();
        eyl.escribeFichero(nomFitxer);
        //eyl.leeFichero(nomFitxer);
    }

    public void escribeFichero(String fichero)
    {
        try
        {

            FileWriter fw = new FileWriter(nomFitxer);
            BufferedWriter bw = new BufferedWriter(fw);
            
            Random rand = new Random();
            Method[] methods = Robot.class.getDeclaredMethods();
            for(int i=0;i<10;i++) {
            	int r = rand.nextInt(methods.length);
            	bw.write(methods[r].getName());
            	for (Class<?> c : methods[r].getParameterTypes()) {
            		bw.write(" "+c.getName());
            	}
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
    
    public void view() {
    	for(int[] f : Robot.map) {
    		for(int i : f) {
    			System.out.println(i);
    		}
    	}
    }
}

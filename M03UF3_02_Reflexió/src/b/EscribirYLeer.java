/**
 * M03UF3  Fitxers. Reflexió.
 * 
 * Codi Automodificable.
 * 
 * Abandon all hope ye who enter here.
 */
package b;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.*;
import java.util.Random;

import a.Persona;
import b.Robot;

public class EscribirYLeer
{
	static String nomFitxer = ".\\src\\b\\reflx.dat";
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
            
            Random rand = new Random();
            Method[] methods = Robot.class.getDeclaredMethods();
            for(int i=0;i<10;i++) {
            	int r = rand.nextInt(methods.length);
            	bw.write(methods[r].getName()+";");
            	for (Class<?> c : methods[r].getParameterTypes()) {
            		bw.write(c.getName()+" ");
            	}
            	bw.write(";");
            	for (Class<?> c : methods[r].getParameterTypes()) {
            		switch (c.getName()) {
            		case "java.lang.Integer":
            			
            			bw.write(rand.nextInt(10)+" ");
            		}
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
    	
		try {
			
		FileReader fr = new FileReader(nomFitxer);
		BufferedReader br = new BufferedReader(fr);
		
		
		Robot rob = new Robot();
		while(br.ready()) {  //El Reader estara llest mentre no s'arribi al EOF...
			String[] linea = br.readLine().split(";");
			if(linea.length==1) {
				rob.getClass().getMethod(linea[0], null).invoke(rob, null);
			}else {
				String[] params = linea[1].split(" ");
				String[] values = linea[2].split(" ");
				Object[] rvalues = new Object[values.length];
				Class<?>[] cparams = new Class<?>[params.length];
				
				for(int i =0;i<params.length;i++) {
					cparams[i]= Class.forName(params[i]);
					switch(cparams[i].toString()) {
						case "java.lang.Integer":
							
						break;
						
					}
				}
				rob.getClass().getMethod(linea[0], cparams)
				.invoke(rob, linea[2]);
				
			}
			view();
        	
        }
        
        
        
        
        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void view() {
    	for(int i=0;i<Robot.SIZE;i++) {
    		for(int j=0;j<Robot.SIZE;j++) {
    			System.out.print(Robot.map[i][j]);
    		}System.out.println();
    	}
    	
    	System.out.println();
    }
}

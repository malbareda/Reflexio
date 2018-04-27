package a;


public class Persona
{



	public Persona (int i)
    {
        setPersona(i);
    }
    
    public String nombre;
    public String apellido;
    public int edad;
    public int altura;
    public double peso;
    public String profesion;
    
    

    public String toString()
    {
        return nombre+" "+
        apellido+" "+profesion+" de "+edad+" años, "+altura+" cm y "+peso+" kg";
    }

    public void setPersona(int i)
    {
        nombre="nombre"+i;
        apellido="apellido"+i;
        edad=i;
        altura = 150+i;
        peso = 75+i;
        profesion = "ingeniero"+i;
        
    }
}

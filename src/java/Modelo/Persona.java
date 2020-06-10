package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

 
public class Persona {
    //atributos de la clase
    String dui;
    String apellidos;
    String nombres; 
    
    Connection cnn; 
    Statement state; 
    ResultSet result;
 
    //constructor vacío de la clase tipo publico
    //el constructor lo utilizaremos para la conexión de la base de datos
public Persona(){
        try {
            Class.forName("com.mysql.jdbc.Driver"); //Driver de la base de datos    //URL de la base de datos
            cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_recursos_humanos?zeroDateTimeBehavior=convertToNull","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}

public Persona (String dui, String apellidos, String nombres){
    this.dui = dui;
    this.apellidos = apellidos;
    this.nombres = nombres;

}
    

public boolean insertarDatos(){
    try {
        String miQuery = "Insert into tb_persona values('" + dui + "', '" + apellidos + "', '" + nombres + "');";
        int estado = 0; //Estado de la inercion 
        state = cnn.createStatement();
        estado = state.executeUpdate(miQuery);
        if(estado == 1){
             return true;
        }
    } catch (SQLException ex){
        Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
    }
        return false;

}

public ArrayList<Persona> consultarRegistros(){ //Crear el arrays de alamacenamiento de Persona
        ArrayList<Persona> person = new ArrayList(); 
        try{
            String miQuery = "select * from tb_persona;"; //definir la consulta
            state = cnn.createStatement();//Crear el boton para la consulta
            result = state.executeQuery(miQuery);//Ejecutar la consulta
            while(result.next()){ //Recorre todo el result y almacena cada fila los registros encontrados
            
                        //
            person.add(new Persona(result.getString("dui_persona"), result.getString("apellidos_persona"), result.getString("nombres_persona")));    
         }
        } catch (SQLException ex){
            Logger.getLogger(Persona.class.getName()).log(Level.SEVERE, null, ex);
        
        }
        return person; //Independientemente encuentre o no registro retorna el objrto persona
  
}     

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    
    
}

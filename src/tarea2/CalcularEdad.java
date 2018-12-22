/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tarea2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author luis
 */
public class CalcularEdad {
    
    public static void main(String[] args) throws IOException{
        
    
    Calendar calendario = GregorianCalendar.getInstance();    
    Scanner lector = new Scanner(System.in);
    //variables para almacenar y manejar los valores de nacimiento y estimaciones        
    int añoAc,mesAc,diaAc;
    int añoNa,mesNa,diaNa;
    int añoE,mesE,diaE;
    
    /*Asignación de fecha actual*/
    añoAc = calendario.get(Calendar.YEAR);
    mesAc = calendario.get(Calendar.MONTH) +1;
    diaAc = calendario.get(Calendar.DATE);
     
    
try{
    System.out.println("Bienvenido vamos a calcular su edad");
    System.out.println("Fecha Actual: "+añoAc+"/"+mesAc+"/"+diaAc);
    /*Creaccion del archivo para guardar los resultados*/
    File archivo =new File("texto.txt");
    FileWriter escribir =new FileWriter(archivo,true);
   
   /*Preguntas para solicitar la edad y recolectar la informacion ingresada 
      por el usuario desde el teclado*/
   System.out.print("Ingrese el año de nacimiento: ");
   añoNa = lector.nextInt();
         
   System.out.print("Ingrese el mes de nacimiento: ");
   mesNa = lector.nextInt();
      
   System.out.print("Ingrese el dia de nacimiento: ");
   diaNa = lector.nextInt();
   /*Escribimos los datos en el documento*/
   escribir.write("Bienvenido vamos a calcular su edad");
   escribir.write("Fecha Actual: "+añoAc+"/"+mesAc+"/"+diaAc);
   escribir.append('\n');
   escribir.write("Ingrese el año de nacimiento: ");
   escribir.write(String.valueOf(añoNa));
   escribir.append('\n');
   escribir.write("Ingrese el mes de nacimiento: ");
   escribir.write(String.valueOf(mesNa));
   escribir.append('\n');
   escribir.write("Ingrese el dia de nacimiento: ");
   escribir.write(String.valueOf(mesNa));
   escribir.append('\n');
      
   /*Calculamos lo edad ingresada*/
   if (añoNa <= añoAc){
       if(diaAc < diaNa){
           diaAc = diaAc + 30;
           mesAc = mesAc - 1;
         }
       if(mesAc < mesNa){
           mesAc = mesAc + 12;
           añoAc = añoAc - 1; 
       }
       añoE = añoAc - añoNa;
       mesE = mesAc - mesNa;
       diaE = diaAc - diaNa;
       
       /*obtenemos el resultado del calculo*/
       String resultado = "Su edad exacta luego de nuestro calculo es: "+añoE + 
               " años "+ mesE +
               " meses con " + diaE +" dias";
       System.out.println(resultado);
       
       /*Escribimos el resultado el resultado del calculo y cerramos el 
       documento*/
       escribir.write(resultado);
       escribir.append('\n');
       escribir.close();
   }else{
       System.out.print("Datos incorrectos");
       
   }
   }catch(InputMismatchException e)
    {
        System.out.println("ERROR EN DATO INGRESADO!");
    
    }catch(Exception e)
    {
        System.out.println();
    }
    
    
}
    
}

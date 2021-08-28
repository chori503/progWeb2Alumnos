package controlador;

import dao.AlumnoDao;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import modelo.Alumno;

public class AlumnoController {

    public static void main(String[] args) {
        Alumno a = new Alumno();
        AlumnoDao adao= new AlumnoDao();
        Scanner scan = new Scanner(System.in);
        a.setId(0);
        System.out.println("Ingrese el nombre del alumno: ");
        a.setNombres(scan.next());
        System.out.println("Ingrese los apellidos del alumno: ");
        a.setApellidos(scan.next());
        System.out.println("Ingrese el mail del alumno: ");
        a.setNombres(scan.next());
        boolean rigthDate = false;
        while (!rigthDate) {
            System.out.println("Ingrese la fecha de nacimiento: (yyyy-MM-dd)");
            try {
                a.setFecNacimiento(new SimpleDateFormat("yyyy-MM-dd").parse(scan.next()));
            rigthDate=true;
            } catch (Exception e) {
                e.printStackTrace();
                rigthDate=false;
            }
        }
        if(adao.insert(a)){
            System.out.println("Registro guardado Exitosamente");
        }else{
            System.out.println("Error al guardar :'c");
        }
    
    for(Alumno al:adao.findAll()){
        System.out.println("--------------------------");
        System.out.println("ID: "+al.getId());
        System.out.println("NOMBRES: "+al.getNombres());
        System.out.println("APELLIDOS: "+al.getApellidos());
        System.out.println("MAIL: "+al.getMail());
        System.out.println("FECHA DE NACIMIENTO: "+al.getFecNacimiento());
        System.out.println("---------------------------");
    }
    }
}

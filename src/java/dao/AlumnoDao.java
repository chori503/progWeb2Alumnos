package dao;

import conexion.Conexion;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.Alumno;

public class AlumnoDao {

    Conexion con = new Conexion();

    public AlumnoDao() {
    }

    public boolean insert(Alumno a) {
        String sql = "INSERT INTO alumnos VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps = con.conectar().prepareStatement(sql);
            ps.setInt(1, a.getId());
            ps.setString(2, a.getNombres());
            ps.setString(3, a.getApellidos());
            ps.setString(4, a.getMail());
            ps.setDate(5, new Date(a.getFecNacimiento().getYear(), a.getFecNacimiento().getMonth(), a.getFecNacimiento().getDate()));
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Alumno> findAll() {
        String sql = "SELECT * FROM alumnos";
        try {
            PreparedStatement ps = con.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Alumno> ulist = new LinkedList<>();
            while (rs.next()) {
                Alumno a = new Alumno();
                a.setId(rs.getInt("id"));
                a.setNombres(rs.getString("nombres"));
                a.setApellidos(rs.getString("apellidos"));
                a.setMail(rs.getString("mail"));
                a.setFecNacimiento(rs.getDate("fec_nacimiento"));
                ulist.add(a);
            }
            return ulist;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

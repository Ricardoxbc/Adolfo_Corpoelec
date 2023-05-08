package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import model.TurnoX;
import model.Usuario;

/**
 *
 * @author Ricardo Bermudez
 */
public class Conn {

    private static Connection conn;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected static Connection getConnection() {
        if (conn != null) {
            return conn;
        }
        return getConnection("localhost", "3306", "test", "test", "asistencia");
    }

    protected static Connection getConnection(String url, String port, String user, String pass, String bd) {
        try {
            String host = String.format("jdbc:mysql://%s:%s/%s", url, port, bd);
            conn = DriverManager.getConnection(host, user, pass);
            if (conn.isValid(3)) {
                Logger.getGlobal().log(Level.INFO, "Connected");
                return conn;
            }
        } catch (Exception e) {
            Logger.getGlobal().log(Level.SEVERE, "Error de conexion", e);
        }
        return null;
    }

    public static boolean insertUsuario(Usuario u) {
        try {
            PreparedStatement stmt = getConnection().prepareStatement(
                    "INSERT INTO usuario "
                    + "(cedula, nombre, apellido, contrasenia, cargo, acceso) "
                    + "VALUES (?,?,?,?,?,?)"
            );
            stmt.setString(1, u.getCedula());
            stmt.setString(2, u.getNombre());
            stmt.setString(3, u.getApellido());
            stmt.setString(4, u.getContrasenia());
            stmt.setString(5, u.getCargo());
            stmt.setInt(6, u.getAcceso());
            boolean res = stmt.executeUpdate() > 0;
            stmt.close();
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(Conn.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static boolean updateUsuario(Usuario u) {
        try {
            PreparedStatement stmt = getConnection().prepareStatement(
                    "UPDATE usuario SET "
                    + "cedula = ?, nombre = ?, apellido = ?, contrasenia = ?, cargo = ?, acceso = ?, id_turno = ?"
                    + " WHERE id_usuario = ?"
            );
            stmt.setString(1, u.getCedula());
            stmt.setString(2, u.getNombre());
            stmt.setString(3, u.getApellido());
            stmt.setString(4, u.getContrasenia());
            stmt.setString(5, u.getCargo());
            stmt.setInt(6, u.getAcceso());
            stmt.setLong(7, u.getHorarioId());
            stmt.setLong(8, u.getId());
            boolean res = stmt.executeUpdate() > 0;
            stmt.close();
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(Conn.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static List<Usuario> getUsuario(Usuario u) {
        try {
            List<Usuario> list = new ArrayList<>();
            short parms = 0;
            Object fields[] = new Object[3];
            String sql = "SELECT * FROM usuario WHERE 1 ";
            if (u != null) {
                if (u.getId() != null) {
                    sql += " AND id_usuario = ? ";
                    fields[parms++] = u.getId();
                }
                if (u.getCedula() != null) {
                    sql += " AND cedula = ? ";
                    fields[parms++] = u.getCedula();
                }
                if (u.getCedula() != null) {
                    sql += " AND contrasenia = ? ";
                    fields[parms++] = u.getContrasenia();
                }
            }
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            for (int i = 0; i < parms; i++) {
                stmt.setObject(i + 1, fields[i]);
            }
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Usuario user = new Usuario()
                        .setId(rs.getLong("id_usuario"))
                        .setCedula(rs.getString("cedula"))
                        .setContrasenia(rs.getString("contrasenia"))
                        .setNombre(rs.getString("nombre"))
                        .setApellido(rs.getString("apellido"))
                        .setCargo(rs.getString("cargo"))
                        .setAcceso(rs.getInt("acceso"))
                        .setHorarioId(rs.getObject("id_turno", Long.class));
                list.add(user);
            }
            stmt.close();
            rs.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Conn.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static boolean eliminarUsuario(Usuario u) {
        try {
            PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM usuario WHERE id_usuario = ?");
            stmt.setLong(1, u.getId());
            boolean res = stmt.executeUpdate() > 0;
            stmt.close();
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(Conn.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static boolean insertTurno(TurnoX t) {
        try {
            PreparedStatement stmt = getConnection().prepareStatement(
                    "INSERT INTO turno "
                    + "(descanso, turno, fechaInicio, fechaFin, rangos) "
                    + "VALUES (?,?,?,?,?)"
            );
            stmt.setString(1, t.getDescanso().toString());
            stmt.setString(2, Arrays.toString(t.getTurnos()));
            stmt.setDate(3, java.sql.Date.valueOf(t.getInicioTurnoX()));
            stmt.setDate(4, java.sql.Date.valueOf(t.getFinTurnoX()));
            stmt.setString(5, "");
            boolean res = stmt.executeUpdate() > 0;
            stmt.close();
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(Conn.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static List<TurnoX> getTurnos(LocalDate fecha) {
        try {
            List<TurnoX> list = new ArrayList<>();
            String sql = "SELECT * FROM turno WHERE ? >= fechaInicio AND ? <= fechaFin";
            PreparedStatement stmt = getConnection().prepareStatement(sql);
            stmt.setDate(1, java.sql.Date.valueOf(fecha));
            stmt.setDate(2, java.sql.Date.valueOf(fecha));

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                TurnoX turno = new TurnoX()
                        .setId(rs.getLong("id_turno"))
                        .setDescanso(TurnoX.Descanso.valueOf(rs.getString("descanso")))
                        .setInicioTurnoX(LocalDate.parse(rs.getString("fechaInicio")));
                String[] turnosSplit = rs.getString("turno").replace("[", "").replace("]", "").split(",");
                Object[] arr = Arrays.stream(turnosSplit)
                        .map(s -> s.trim())
                        .collect(Collectors.toCollection(ArrayList::new))
                        .toArray();
                TurnoX.Turno[] turnos = new TurnoX.Turno[5];
                int i = 0;
                for (Object s : arr) {
                    turnos[i++] = !s.toString().equals("null") ? TurnoX.Turno.valueOf(s.toString()) : null;
                }
                turno.setTurnos(turnos);
                list.add(turno);
            }
            stmt.close();
            rs.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(Conn.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static boolean eliminarTurno(TurnoX t) {
        try {
            PreparedStatement stmt = getConnection().prepareStatement("DELETE FROM turno WHERE id_turno = ?");
            stmt.setLong(1, t.getId());
            boolean res = stmt.executeUpdate() > 0;
            stmt.close();
            return res;
        } catch (SQLException ex) {
            Logger.getLogger(Conn.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}

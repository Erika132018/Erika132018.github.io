/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package modelo;

import java.util.Date;
import java.util.Scanner;

public class Ejecutor {

    public static void main(String[] args) {
        // Crear una instancia de la clase Ejecutor
        Ejecutor ejecutor = new Ejecutor();

        // Variable para seleccionar la modalidad
        int opcion = mostrarMenu();

        // Ejecutar la modalidad seleccionada
        switch (opcion) {
            case 1:
                ejecutor.ejecutarFutbol();
                break;
            case 2:
                ejecutor.ejecutarAjedrez();
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }

    // Función para mostrar el menú y obtener la opción seleccionada
    public static int mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione una modalidad:");
        System.out.println("1. Fútbol");
        System.out.println("2. Ajedrez");
        System.out.print("Opción: ");
        int opcion = scanner.nextInt();
        return opcion;
    }


    // Función para ejecutar el código relacionado con fútbol
    public void ejecutarFutbol() {
        //Creacion de Roles
        Rol r1 = new Rol("ADMINISTRADOR", "\nSe encarga de administracion genral de todo el sistema");
        Rol r2 = new Rol("SUB-ADMINISTRADOR", "\nSe encarga de gestion de todo el sistema");
        Listas.agregarRol(r1);
        Listas.agregarRol(r2);
//Persona
        Persona p1 = new Persona("Manuel", "Saenz", "1234567892", "0985244142", new Date(), TipoPersona.NATURAL);
        Persona p2 = new Persona("Liz", "Cale", "1111111111", "121212121", new Date(), TipoPersona.NATURAL);
        Persona p3 = new Persona("Steven", "Cale", "1111111111", "121212121", new Date(), TipoPersona.NATURAL);
        Persona p4 = new Persona("Jahir", "Cale", "1111111111", "121212121", new Date(), TipoPersona.NATURAL);

//Usuario
        Usuario u1 = new Usuario("admin1", "admin", r1, p1);
        Usuario u2 = new Usuario("admin2", "admin", r2, p1);
        Listas.agregarUsuario(u1);
        Listas.agregarUsuario(u2);
        
        //Arbitro
        Arbitro a1 = new Arbitro("SN", "CENTRAL", "Luis", "Paz", "1104779044", "0985244142", new Date(), TipoPersona.ARBITRO);

        //Jugadores Futbol
        Jugador jf1 = new Jugador(10, true, "Pepito", "Janz", "110477788", "121212", new Date(), TipoPersona.JUGADOR_FUTBOL);
        Jugador jf2 = new Jugador(10, true, "Jahir", "Cale", "1104665677", "121212", new Date(), TipoPersona.JUGADOR_FUTBOL);
        Jugador jf3 = new Jugador(10, true, "Steven", "Cale", "11054898", "121212", new Date(), TipoPersona.JUGADOR_FUTBOL);
        Jugador jf4 = new Jugador(10, true, "Fausto", "Cale", "110578888", "121212", new Date(), TipoPersona.JUGADOR_FUTBOL);
        
        // Agregamos las Personas
        Listas.agregarPersona(p1);
        Listas.agregarPersona(p2);
        Listas.agregarPersona(p3);
        Listas.agregarPersona(p4);
// Agregamos los jugadores de Futbol
        Listas.agregarPersona(jf1);
        Listas.agregarPersona(jf2);
        Listas.agregarPersona(jf3);
        Listas.agregarPersona(jf4);

        // Agregamos los Arbitros
        Listas.agregarPersona(a1);

        //Tipo Sancion Futbol
        TipoSancionFutbol tsf1_rd = new TipoSancionFutbol("Roja Directa", 3.00);
        TipoSancionFutbol tsf2_r = new TipoSancionFutbol("Roja", 3);
        TipoSancionFutbol tsf3_a = new TipoSancionFutbol("Amarilla", 1.50);
        Listas.agregarTipoSancionFutbol(tsf1_rd);
        Listas.agregarTipoSancionFutbol(tsf2_r);
        Listas.agregarTipoSancionFutbol(tsf3_a);
        
        //Tipo Punto
        TipoPunto tp1 = new TipoPunto(1, "Tiro libre");
        TipoPunto tp2 = new TipoPunto(2, "Dentro de linea");
        TipoPunto tp3 = new TipoPunto(3, "Fuera de linea");
        //Temporada
        Temporada tmp1 = new Temporada(new Date(), new Date(), "Abril-Septiembre 2023");
        Temporada tmp2 = new Temporada(new Date(), new Date(), "Octubre-Abril 2024");
        
        //Tipo Cuerpo Técnico
        TipoCuerpoTecnico tct1 = new TipoCuerpoTecnico("Entrenador", "Se encarga de los entrenamientos del equipo");
        TipoCuerpoTecnico tct2 = new TipoCuerpoTecnico("Preparador Fisico", "Se encarga de las rutinas de ejercicio");
        TipoCuerpoTecnico tct3 = new TipoCuerpoTecnico("Director Tecnico", "Se encarga de la dirección del equipo");

        //Equipo futbol
        Equipo e3 = new Equipo(new Date(), "==IDV==", "Independiente", TipoCompetencia.FUTBOL);
        Equipo e4 = new Equipo(new Date(), "==BARCA==", "Barcelona F.C", TipoCompetencia.FUTBOL);
        
        Listas.agregarEquipoFutbol(e3);
        Listas.agregarEquipoFutbol(e4);

        //Competencia
        Competencia c1 = new Competencia("LIGABARRIAL", 11, 22, TipoCompetencia.FUTBOL);
        //Fichaje futbol
        Fichaje f1 = new Fichaje(e4, jf1, c1, tmp1); // Fichaje equipo de futbol
        Fichaje f2 = new Fichaje(e4, jf2, c1, tmp1); // Fichaje equipo de futbol

        Fichaje f3 = new Fichaje(e3, jf3, c1, tmp1); // Fichaje equipo de futbol
        Fichaje f4 = new Fichaje(e3, jf4, c1, tmp1); // Fichaje equipo de futbol

        //Encuentros deportivos Futbol
        Encuentro ecF1 = new Encuentro(e4, e3, new Date(), "Canchas UNL", EstadoEncuentro.FINALIZADO);
        //Agregar Sanciones
        SancionFutbol s1 = new SancionFutbol(new Date(), tsf3_a, ecF1, jf1, EstadoSancion.PENDIENTE);
        SancionFutbol s2 = new SancionFutbol(new Date(), tsf3_a, ecF1, jf1, EstadoSancion.PAGADO);
        SancionFutbol s3 = new SancionFutbol(new Date(), tsf1_rd, ecF1, jf2, EstadoSancion.PAGADO);
        Listas.agregarSancionesFutbol(s1);
        Listas.agregarSancionesFutbol(s2);
        Listas.agregarSancionesFutbol(s3);

        //Marcador Futbol
        MarcadorFutbol mf1 = new MarcadorFutbol(ecF1, e4, 2);
        MarcadorFutbol mf2 = new MarcadorFutbol(ecF1, e3, 1);

      
        Listas.agregarMarcadorFutbol(mf1);
        Listas.agregarMarcadorFutbol(mf2);
        // Goleadores del Futbol
        Goles goleador1 = new Goles(jf1, mf1, 10);
        Goles goleador2 = new Goles(jf3, mf2, 7);

        Usuario u = new Usuario();
        u.presentarUsuario();

        Rol r = new Rol();
        r.presentarRoles();

        Persona p = new Persona();
        p.presentarPersonas();
        p.presentarJugadoresFutbol();

        Equipo eq = new Equipo();
        eq.presentarEquiposFutbol();
       

        TablaDePosicionesFutbol tablaPosiciones = new TablaDePosicionesFutbol();
        tablaPosiciones.calcularTablaPosiciones(Listas.listaEquipos, Listas.listaMarcadorFutbol);
        tablaPosiciones.presentarTablaPosiciones();
        
        System.out.println("Ejecutando código de Fútbol...");
    }

    // Función para ejecutar el código relacionado con ajedrez
    public void ejecutarAjedrez() {
        // Creación de Jugadores de Ajedrez
        Jugador ja1 = new Jugador(0, true, "Sergio", "Garcia", "110477788", "121212", new Date(), TipoPersona.JUGADOR_AJEDREZ);
        Jugador ja2 = new Jugador(0, true, "Ana", "Lopez", "1104665677", "121212", new Date(), TipoPersona.JUGADOR_AJEDREZ);
        Listas.agregarPersona(ja1);
        Listas.agregarPersona(ja2);
        
        // Creación de Tipo de Sanciones para Ajedrez
       TipoSancionAjedrez tsa1 = new TipoSancionAjedrez("Falta de Tiempo", "Tiempo agotado");
       TipoSancionAjedrez tsa2 = new TipoSancionAjedrez("Movimiento Ilegal", "Movimiento no permitido");
       Listas.agregarTipoSancionAjedrez(tsa1);
       Listas.agregarTipoSancionAjedrez(tsa2);
       
       // Creación de Temporadas para Ajedrez
       Temporada tmpAjedrez = new Temporada(new Date(), new Date(), "2023");
       Listas.agregarTemporadaAjedrez(tmpAjedrez);
       // Creación de Competencias de Ajedrez
        CompetenciaAjedrez ca1 = new CompetenciaAjedrez("Campeonato Ajedrez", 9, 18);
        Listas.agregarCompetenciaAjedrez(ca1);
        // Creación de Encuentros de Ajedrez
        EncuentroAjedrez ea1 = new EncuentroAjedrez(ja1, ja2, new Date(), "Sala de Ajedrez", EstadoEncuentro.FINALIZADO);
        Listas.agregarEncuentroAjedrez(ea1);
        // Creación de Marcador de Ajedrez
        MarcadorAjedrez ma1 = new MarcadorAjedrez(ea1, ja1, ja2, ResultadoAjedrez.GANADOR_BLANCAS);
        Listas.agregarMarcadorAjedrez(ma1);
        // Presentar Personas de Ajedrez
        System.out.println("\nPersonas de Ajedrez:");
        System.out.println("=====================");
        for (Persona persona : Listas.listaPersonas) {
            if (persona.getTipoPersona() == TipoPersona.JUGADOR_AJEDREZ) {
                persona.presentarPersona();
            }
        }
        
         // Presentar Marcadores de Ajedrez
        System.out.println("=======================");
        for (MarcadorAjedrez marcadorAjedrez : Listas.listaMarcadorAjedrez) {
        marcadorAjedrez.presentarMarcadorAjedrez();
        }

        // Presentar Tabla de Posiciones de Ajedrez
        TablaPosicionesAjedrez tablaPosicionesAjedrez = new TablaPosicionesAjedrez();
        JugadorAjedrez jugador1 = new JugadorAjedrez("Sergio Garcia");
        JugadorAjedrez jugador2 = new JugadorAjedrez("Ana Lopez");

        tablaPosicionesAjedrez.agregarJugador(jugador1);
        tablaPosicionesAjedrez.agregarJugador(jugador2);

        tablaPosicionesAjedrez.registrarPartida(jugador1.getNombre(), jugador2.getNombre(), 1); // Jugador 1 gana
        tablaPosicionesAjedrez.registrarPartida(jugador1.getNombre(), jugador2.getNombre(), 0); // Empate

        System.out.println("===============================");
        tablaPosicionesAjedrez.presentarTablaPosiciones();
      
    }
 
}
     
    


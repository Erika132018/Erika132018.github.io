/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;

/**
 *
 * @author 59398
 */
public class Ejecutor {

    public static void main(String[] args) {

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
//JugadoresBasket
        Jugador jb5 = new Jugador(10, true, "Cristopher", "Morgan", "110578888", "121212", new Date(), TipoPersona.JUGADOR_BASKET);
        Jugador jb6 = new Jugador(10, true, "Alexander", "Colbourn", "110578888", "121212", new Date(), TipoPersona.JUGADOR_BASKET);
        Jugador jb7 = new Jugador(10, true, "Ilenko", "Romanova", "110578888", "121212", new Date(), TipoPersona.JUGADOR_BASKET);
        Jugador jb8 = new Jugador(10, true, "Jack", "Roos", "110578888", "121212", new Date(), TipoPersona.JUGADOR_BASKET);
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
// Agregamos los jugadores de Basket
        Listas.agregarPersona(jb5);
        Listas.agregarPersona(jb6);
        Listas.agregarPersona(jb7);
        Listas.agregarPersona(jb8);
// Agregamos los Arbitros
        Listas.agregarPersona(a1);

//Tipo Sancion Futbol
        TipoSancionFutbol tsf1_rd = new TipoSancionFutbol("Roja Directa", 3.00);
        TipoSancionFutbol tsf2_r = new TipoSancionFutbol("Roja", 3);
        TipoSancionFutbol tsf3_a = new TipoSancionFutbol("Amarilla", 1.50);
        Listas.agregarTipoSancionFutbol(tsf1_rd);
        Listas.agregarTipoSancionFutbol(tsf2_r);
        Listas.agregarTipoSancionFutbol(tsf3_a);
//Tipo Sancion Basket

        TipoSancionBasket tsb1 = new TipoSancionBasket("Falta Personal", "Poseción del Balón");
        TipoSancionBasket tsb2 = new TipoSancionBasket("Falta descalificante", "Expulsión");
        TipoSancionBasket tsb3 = new TipoSancionBasket("Faltas por Equipo", "Tiro libre al equipo contrario");
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

//Equipo Basket
        Equipo e1 = new Equipo(new Date(), "==BROKLINS==", "Los broklins", TipoCompetencia.BASKETBALL);
        Equipo e2 = new Equipo(new Date(), "==NEWYORK==", "NewYorknba", TipoCompetencia.BASKETBALL);

//Equipo futbol
        Equipo e3 = new Equipo(new Date(), "==IDV==", "Independiente", TipoCompetencia.FUTBOL);
        Equipo e4 = new Equipo(new Date(), "==BARCA==", "Barcelona F.C", TipoCompetencia.FUTBOL);
        Listas.agregarEquipoFutbol(e1);
        Listas.agregarEquipoFutbol(e2);
        Listas.agregarEquipoFutbol(e3);
        Listas.agregarEquipoFutbol(e4);

//Cuerpo Técnico
        CuerpoTecnico ct1 = new CuerpoTecnico(p2, e2, tct2);
        CuerpoTecnico ct2 = new CuerpoTecnico(p1, e1, tct1);
        CuerpoTecnico ct3 = new CuerpoTecnico(p4, e2, tct3);
        CuerpoTecnico ct4 = new CuerpoTecnico(p3, e1, tct2);

//Competencia
        Competencia c1 = new Competencia("LIGABARRIAL", 11, 22, TipoCompetencia.FUTBOL);
        Competencia c2 = new Competencia("NBA", 5, 15, TipoCompetencia.BASKETBALL);
//Fichaje futbol
        Fichaje f1 = new Fichaje(e4, jf1, c1, tmp1); // Fichaje equipo de futbol
        Fichaje f2 = new Fichaje(e4, jf2, c1, tmp1); // Fichaje equipo de futbol

        Fichaje f3 = new Fichaje(e3, jf3, c1, tmp1); // Fichaje equipo de futbol
        Fichaje f4 = new Fichaje(e3, jf4, c1, tmp1); // Fichaje equipo de futbol

//Encuentros deportivos Futbol
        Encuentro ecF1 = new Encuentro(e4, e3, new Date(), "Canchas UNL", EstadoEncuentro.FINALIZADO);
        Encuentro ecF2 = new Encuentro(e1, e2, new Date(), "Canchas UNL", EstadoEncuentro.FINALIZADO);

//Agregar Sanciones
        SancionFutbol s1 = new SancionFutbol(new Date(), tsf3_a, ecF1, jf1, EstadoSancion.PENDIENTE);
        SancionFutbol s2 = new SancionFutbol(new Date(), tsf3_a, ecF1, jf1, EstadoSancion.PAGADO);
        SancionFutbol s3 = new SancionFutbol(new Date(), tsf1_rd, ecF1, jf2, EstadoSancion.PAGADO);
        Listas.agregarSancionesFutbol(s1);
        Listas.agregarSancionesFutbol(s2);
        Listas.agregarSancionesFutbol(s3);

//Marcador Basket
        MarcadorBasket mB1 = new MarcadorBasket(ecF1, e1, tp3);
        MarcadorBasket mB2 = new MarcadorBasket(ecF1, e1, tp3);

        Listas.agregarMarcadorBasket(mB1);
        Listas.agregarMarcadorBasket(mB2);

//Marcador Futbol
        MarcadorFutbol mf1 = new MarcadorFutbol(ecF1, e4, 2);
        MarcadorFutbol mf2 = new MarcadorFutbol(ecF1, e3, 1);

        MarcadorFutbol mf3 = new MarcadorFutbol(ecF2, e1, 0);
        MarcadorFutbol mf4 = new MarcadorFutbol(ecF2, e2, 0);

        Listas.agregarMarcadorFutbol(mf1);
        Listas.agregarMarcadorFutbol(mf2);
        Listas.agregarMarcadorFutbol(mf3);
        Listas.agregarMarcadorFutbol(mf4);

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
        eq.presentarEquiposBasket();

        TablaDePosicionesFutbol tablaPosiciones = new TablaDePosicionesFutbol();
        tablaPosiciones.calcularTablaPosiciones(Listas.listaEquipos, Listas.listaMarcadorFutbol);
        tablaPosiciones.presentarTablaPosiciones();
    }

}

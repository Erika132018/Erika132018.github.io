import enum
from datetime import date

from django.db import models


class TipoJugador(enum.Enum):
    FUTBOL = 'Futbol'
    AJEDREZ = 'Ajedrez'


class TipoEncuentro(enum.Enum):
    FUTBOL = 'Futbol'
    AJEDREZ = 'Ajedrez'


class EstadoEncuentro(enum.Enum):
    INICIADO = 'Iniciado'
    FINALIZADO = 'Finalizado'
    SUSPENDIDO = 'Suspendido'
    CANCELADO = 'Cancelado'


class TipoGrupo(enum.Enum):
    LIGA = 'Liga'
    COPA = 'Copa'


class Persona(models.Model):
    nombre = models.CharField("Nombres", max_length=65, null=False, blank=False)
    apellido = models.CharField("Apellidos", max_length=65, null=False, blank=False)
    dni = models.CharField('N de documento', max_length=10, unique=True, blank=False, null=False)
    fecha_nacimiento = models.DateField("Fecha de nacimiento", default=date.today, null=False, blank=False)
    celular = models.CharField("Celular", max_length=10, blank=True, null=True)
    direccion = models.CharField("Dirección", max_length=60, null=True, blank=True)

    def __str__(self):
        return '{0} {1}'.format(self.nombre, self.apellido)


class Temporada(models.Model):
    nombre = models.CharField(max_length=50)
    fecha_inicio = models.DateField()
    fecha_fin = models.DateField()

    def __str__(self):
        return self.nombre


class Equipo(models.Model):
    nombre_equipo = models.CharField(max_length=50)

    def __str__(self):
        return self.nombre_equipo

    class Meta:
        db_table = 'equipo'


class Jugador(Persona):
    tipo = models.CharField(max_length=20, choices=[(tag.value, tag.name) for tag in TipoJugador], null=True)
    numeroCamiseta = models.IntegerField(default=1)

    def __str__(self):
        return '{0} {1} - {2}'.format(self.nombre, self.apellido, self.get_tipo_display())

    class Meta:
        db_table = 'jugador'


class Fichaje(models.Model):
    jugador = models.ForeignKey(Jugador, on_delete=models.CASCADE, related_name='jugadores_fichados')
    equipo = models.ForeignKey(Equipo, on_delete=models.CASCADE, related_name='equipos_fichados')
    temporada = models.ForeignKey(Temporada, on_delete=models.CASCADE, related_name='temporadas_fichajes')

    def __str__(self):
        return f"{self.jugador} - {self.equipo}"

    class Meta:
        db_table = 'fichaje'


class Competencia(models.Model):
    nombre = models.CharField(max_length=50)
    tipo = models.CharField(max_length=20, choices=[(tag.value, tag.name) for tag in TipoJugador], null=True)
    estado = models.CharField(max_length=20, choices=[(tag.value, tag.name) for tag in EstadoEncuentro], null=True)
    temporada = models.ForeignKey(Temporada, on_delete=models.CASCADE, related_name='temporadas_competencia', null=True)

    def __str__(self):
        return self.nombre

    class Meta:
        db_table = 'competencia'


class CompetenciaFutbol(Competencia):
    titulares = models.IntegerField(default=1)
    total_jugadores = models.IntegerField(default=0)

    def __str__(self):
        return self.nombre

    class Meta:
        db_table = 'competencia_futbol'


class Grupo(models.Model):
    nombre = models.CharField(max_length=50)
    tipo = models.CharField(max_length=20, choices=[(tag.value, tag.name) for tag in TipoGrupo], null=True)
    competencia = models.ForeignKey(Competencia, on_delete=models.CASCADE, related_name='competencia_grupo', null=True)
    equipos = models.ManyToManyField(Equipo, related_name='equipos_grupo')

    def __str__(self):
        return self.nombre

    class Meta:
        db_table = 'grupo'


class CompetenciaAjedrez(Competencia):
    max_jugadores = models.PositiveIntegerField(default=10)

    def __str__(self):
        return self.nombre

    class Meta:
        db_table = 'competencia_ajedrez'


class Encuentro(models.Model):
    fecha = models.DateField()
    hora = models.TimeField()
    lugar = models.CharField(max_length=50)
    tipo = models.CharField(max_length=20, choices=[(tag.value, tag.name) for tag in TipoEncuentro], null=True)
    estado = models.CharField(max_length=20, choices=[(tag.value, tag.name) for tag in EstadoEncuentro], null=True)

    class Meta:
        db_table = 'encuentro'


class EncuentroFutbol(Encuentro):
    equipo1 = models.ForeignKey(Equipo, on_delete=models.CASCADE, related_name='encuentros_equipo1')
    equipo2 = models.ForeignKey(Equipo, on_delete=models.CASCADE, related_name='encuentros_equipo2')

    def __str__(self):
        return f'Encuentro entre {self.equipo1} y {self.equipo2}, el {self.fecha} a las {self.hora} en {self.lugar}'

    class Meta:
        db_table = 'encuentro_futbol'


class EncuentroAjedrez(Encuentro):
    jugador1 = models.ForeignKey(Jugador, on_delete=models.CASCADE, related_name='encuentros_jugador1')
    jugador2 = models.ForeignKey(Jugador, on_delete=models.CASCADE, related_name='encuentros_jugador2')

    def __str__(self):
        return f'Encuentro entre {self.jugador1} y {self.jugador2}, el {self.fecha} a las {self.hora} en {self.lugar}'

    class Meta:
        db_table = 'encuentro_ajedrez'


class MarcadorFutbol(models.Model):
    equipo1 = models.IntegerField(default=0)
    equipo2 = models.IntegerField(default=0)
    encuentro = models.ForeignKey(EncuentroFutbol, on_delete=models.CASCADE, related_name='encuentro_marcador')

    def __str__(self):
        return f'Encuentro entre {self.equipo1} y {self.equipo2}'

    class Meta:
        db_table = 'marcador'


class MarcadorAjedrez(models.Model):
    jugador1 = models.ForeignKey(Jugador, on_delete=models.CASCADE, related_name='jugador1_marcador_ajedrez')
    jugador2 = models.ForeignKey(Jugador, on_delete=models.CASCADE, related_name='jugador2_marcador_ajedrez')
    encuentro = models.ForeignKey(EncuentroAjedrez, on_delete=models.CASCADE, related_name='encuentro_marcador')
    puntos_jugador1 = models.IntegerField(default=0)
    puntos_jugador2 = models.IntegerField(default=0)

    def __str__(self):
        return f'Encuentro entre {self.jugador1} y {self.jugador2}'

    class Meta:
        db_table = 'marcador_ajedrez'


class TablaPocisionesFutbol(models.Model):
    equipo = models.ForeignKey(Equipo, on_delete=models.CASCADE, related_name='equipo_tabla')
    competencia = models.ForeignKey(Competencia, on_delete=models.CASCADE, related_name='competencia_tabla_futbol')
    marcador= models.ForeignKey(MarcadorFutbol, on_delete=models.CASCADE, related_name='marcador_tabla_futbol')
    puntos = models.IntegerField(default=0)
    partidos_jugados = models.IntegerField(default=1)
    partidos_ganados = models.IntegerField(default=0)
    partidos_empatados = models.IntegerField(default=0)
    partidos_perdidos = models.IntegerField(default=0)
    goles_favor = models.IntegerField(default=0)
    goles_contra = models.IntegerField(default=0)
    diferencia_goles = models.IntegerField(default=0)

    def __str__(self):
        return f'Equipo {self.equipo} en la competencia {self.competencia}'

    class Meta:
        db_table = 'tabla_pocisiones'


class TablaPocisionesAjedrez(models.Model):
    jugador = models.ForeignKey(Jugador, on_delete=models.CASCADE, related_name='jugador_tabla')
    competencia = models.ForeignKey(Competencia, on_delete=models.CASCADE, related_name='competencia_tabla_ajedrez')
    puntos = models.IntegerField(default=1)
    partidas_jugadas = models.IntegerField(default=1)
    marcador= models.ForeignKey(MarcadorAjedrez, on_delete=models.CASCADE, related_name='marcador_tabla_ajedrez')

    def __str__(self):
        return f'Jugador {self.jugador.nombre} en la competencia {self.competencia}'

    class Meta:
        db_table = 'tabla_pocisiones_ajedrez'

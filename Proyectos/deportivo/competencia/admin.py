from django.contrib import admin

from competencia.models import *

# Register your models here.
admin.site.register(Persona)
admin.site.register(Jugador)
admin.site.register(Equipo)
admin.site.register(Competencia)
admin.site.register(CompetenciaFutbol)
admin.site.register(CompetenciaAjedrez)
admin.site.register(Grupo)
admin.site.register(Fichaje)
admin.site.register(Temporada)
admin.site.register(Encuentro)
admin.site.register(EncuentroAjedrez)
admin.site.register(EncuentroFutbol)
admin.site.register(TablaPocisionesAjedrez)
admin.site.register(TablaPocisionesFutbol)

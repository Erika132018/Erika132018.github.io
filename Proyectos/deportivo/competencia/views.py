import random
from datetime import datetime, timedelta, time
from random import shuffle, choice

import requests
from django.contrib import messages
from django.contrib.auth import logout
from django.contrib.auth.mixins import LoginRequiredMixin
from django.db import transaction
from django.db.models import Sum, F
from django.http import HttpResponseRedirect
from django.shortcuts import render, redirect, get_object_or_404
from django.urls import reverse_lazy

from django.views import View
from django.views.generic import TemplateView, RedirectView, CreateView, ListView, DeleteView, UpdateView

from competencia.models import Jugador, EncuentroAjedrez, TablaPocisionesAjedrez, MarcadorAjedrez, Competencia, \
    CompetenciaAjedrez
from deportivo.settings import URL_API, KEY_API
from django.core.paginator import Paginator, EmptyPage, PageNotAnInteger
from competencia.forms import EncuentroForm, JugadorForm, MarcadorAjedrezForm


class HomeView(TemplateView):
    template_name = "home/dashboard.html"

    def get_context_data(self, **kwargs):
        context = super().get_context_data(**kwargs)
        return context


class FutbolView(LoginRequiredMixin, TemplateView):
    template_name = "home/futbol.html"

    def get_context_data(self, **kwargs):
        context = super().get_context_data(**kwargs)
        context["title"] = 'FUTBOL'
        context["countries"] = get_countries()
        return context


def get_countries():
    response = requests.get(url=URL_API, params={'APIkey': KEY_API, 'action': 'get_countries'})
    if response.status_code == 200:
        return response.json()
    else:
        return None


class LeaguesView(LoginRequiredMixin, TemplateView):
    template_name = "ligas/list.html"

    def get_context_data(self, **kwargs):
        context = super().get_context_data(**kwargs)
        context["title"] = 'LIGAS'
        context["leagues"] = get_leagues(self.kwargs['country_id'])
        return context


def get_leagues(country_id):
    response = requests.get(url=URL_API, params={'APIkey': KEY_API, 'action': 'get_leagues', 'country_id': country_id})

    if response.status_code == 200:
        return response.json()
    else:
        return None


class EquipoView(LoginRequiredMixin, TemplateView):
    template_name = "equipo/list.html"

    def get_context_data(self, **kwargs):
        context = super().get_context_data(**kwargs)
        context["title"] = 'EQUIPOS'
        context["teams"] = get_teams(self.kwargs['league_id'])
        return context


def get_teams(league_id):
    response = requests.get(url=URL_API, params={'APIkey': KEY_API, 'action': 'get_teams', 'league_id': league_id})

    if response.status_code == 200:
        return response.json()
    else:
        return None


class JugadorView(LoginRequiredMixin, TemplateView):
    template_name = "jugador/list.html"

    def get_context_data(self, **kwargs):
        context = super().get_context_data(**kwargs)
        context["title"] = 'JUGADORES'
        context["team"] = get_jugador(self.kwargs['team_id'])
        return context


def get_jugador(team_id):
    response = requests.get(url=URL_API, params={'APIkey': KEY_API, 'action': 'get_teams', 'team_id': team_id})

    if response.status_code == 200:
        return response.json()
    else:
        return None


class GruposSorteoEquiposView(LoginRequiredMixin, TemplateView):
    template_name = 'grupos/list.html'

    def post(self, request, *args, **kwargs):
        num_grupo = request.POST.get('num_grupo')
        generar_grupos(self.request, self.kwargs['league_id'], num_grupo)
        return render(request, self.template_name,
                      {'encuentros': generar_grupos(request, self.kwargs['league_id'], num_grupo)})

    def get_context_data(self, **kwargs):
        context = super().get_context_data(**kwargs)
        context["title"] = 'ENCUENTROS'
        context["encuentros"] = generar_grupos(self.request, self.kwargs['league_id'],
                                               self.request.POST.get('num_grupo'))
        context["num_grupo"] = self.request.POST.get('num_grupo', '')
        return context


def generar_grupos(request, league_id, num_grupo):
    equipos_lista_json = get_teams(league_id)
    equipos = []
    for i in equipos_lista_json:
        equipos.append(i['team_name'])
    num_grupos = num_grupo
    if num_grupos is None:
        num_grupos = 4
    num_grupos = int(num_grupos)
    equipos_por_grupo = len(equipos) // num_grupos
    if equipos_por_grupo < 2:
        equipos_por_grupo = 4
    equipos_aleatorios = list(equipos)
    shuffle(equipos_aleatorios)

    grupos = [equipos_aleatorios[i:i + equipos_por_grupo] for i in range(0, len(equipos_aleatorios), equipos_por_grupo)]

    grupos_partidos = []
    for i in grupos:
        grupos_partidos.append({
            'grupo': i,
            'partidos': sortear_equipos_grupo(request, i, 2)
        })

    return {
        'grupos': grupos_partidos
    }


def sortear_equipos_grupo(request, equipos, num_grupos):
    equipos_por_grupo = len(equipos) // num_grupos
    if equipos_por_grupo < 1:
        equipos_por_grupo = num_grupos // len(equipos)
        num_grupos = len(equipos)

    equipos_aleatorios = list(equipos)
    shuffle(equipos_aleatorios)
    fecha_partido = datetime.now().replace(hour=14, minute=0, second=0, microsecond=0)

    grupos = [equipos_aleatorios[i:i + equipos_por_grupo] for i in range(0, len(equipos_aleatorios), equipos_por_grupo)]

    encuentros_creados = []
    for i in range(num_grupos):
        for j in range(i + 1, num_grupos):
            for equipo1 in grupos[i]:
                for equipo2 in grupos[j]:
                    lugar = choice(lugares)

                    hora_actual = fecha_partido.time()

                    # Validar si la hora actual está entre las 2 y las 9 de la noche
                    if time(14, 0) <= hora_actual <= time(21, 0):
                        # Crear el encuentro con la hora actual y lugar válido
                        encuentros_creados.append({
                            'equipo_local': equipo1,
                            'equipo_visitante': equipo2,
                            'fecha': fecha_partido,
                            'lugar': lugar,
                        })

                    # Incrementar la hora en 45 minutos
                    fecha_partido += timedelta(minutes=45)

    return encuentros_creados


lugares = ['CANCHA 1', 'CANCHA 2', 'CANCHA 3', 'CANCHA 4', 'CANCHA 5', 'CANCHA 6', 'CANCHA 7', 'CANCHA 8', 'CANCHA 9',
           'CANCHA 10']


class JugadoresAjedrezView(LoginRequiredMixin, TemplateView):
    template_name = "home/ajedrez.html"

    def get_context_data(self, **kwargs):
        context = super().get_context_data(**kwargs)
        context["title"] = 'JUGADORES AJEDREZ'
        context["jugadores"] = Jugador.objects.filter(tipo='Ajedrez')
        context["tabla_posiciones"] = TablaPocisionesAjedrez.objects.filter(jugador__tipo='Ajedrez').order_by('-puntos')
        return context


class JugadorCreate(CreateView):
    model = Jugador
    form_class = JugadorForm
    template_name = 'jugadorAjedrez/create.html'  # Ruta de la plantilla de creación de jugador
    success_url = reverse_lazy('ajedrez')  # URL a la que se redirige después de crear un jugador

    def form_valid(self, form):
        response = super().form_valid(form)
        messages.success(self.request, 'Jugador creado exitosamente.')
        return response


class JugadorDelete(DeleteView):
    model = Jugador
    template_name = 'jugadorAjedrez/delete.html'
    context_object_name = 'jugador'
    success_url = reverse_lazy('ajedrez')


class GenerarEncuentroView(LoginRequiredMixin, CreateView):
    template_name = "ajedrezcom/generar_encuentro.html"
    model = EncuentroAjedrez
    form_class = EncuentroForm
    success_url = reverse_lazy('lista_encuentros')

    def get_context_data(self, **kwargs):
        context = super().get_context_data(**kwargs)
        context['title'] = 'Generar encuentros Ajedrez'
        return context

    def form_valid(self, form):
        # Validar si los jugadores son iguales
        jugador1 = form.cleaned_data['jugador1']
        jugador2 = form.cleaned_data['jugador2']
        if jugador1 == jugador2:
            form.add_error('jugador2', 'El Jugador 2 no puede ser igual al Jugador 1.')
            return self.form_invalid(form)

        # Validar si ya existe un encuentro con esos jugadores
        if EncuentroAjedrez.objects.filter(jugador1=jugador1, jugador2=jugador2).exists():
            form.add_error(None, 'Ya existe un encuentro con estos jugadores.')
            return self.form_invalid(form)

        return super().form_valid(form)


def encuentro_detail(request, encuentro_id):
    encuentro = EncuentroAjedrez.objects.get(pk=encuentro_id)
    return render(request, 'ajedrezcom/encuentro_detail.html', {'encuentro': encuentro})


def lista_encuentros(request):
    encuentros = EncuentroAjedrez.objects.all()
    context = {'encuentros': encuentros}
    return render(request, 'ajedrezcom/lista_encuentros.html', context)


class EncuentroDelete(DeleteView):
    model = EncuentroAjedrez
    template_name = 'ajedrezcom/delete_encuentro.html'
    context_object_name = 'encuentro'
    success_url = reverse_lazy('lista_encuentros')


class EncuentroEdit(UpdateView):
    model = EncuentroAjedrez
    template_name = 'ajedrezcom/generar_encuentro.html'
    form_class = EncuentroForm
    success_url = reverse_lazy('lista_encuentros')


class RegistrarMarcadorView(TemplateView):
    template_name = 'ajedrezcom/registrar_marcador.html'
    form_class = MarcadorAjedrezForm

    def get(self, request, encuentro_id):
        encuentro = EncuentroAjedrez.objects.get(pk=encuentro_id)
        form = self.form_class()
        return render(request, self.template_name, {'encuentro': encuentro, 'form': form})

    def post(self, request, encuentro_id):
        encuentro = EncuentroAjedrez.objects.get(pk=encuentro_id)
        form = self.form_class(request.POST)

        if form.is_valid():
            with transaction.atomic():
                marcador = form.save(commit=False)
                marcador.encuentro = encuentro
                marcador.jugador1 = encuentro.jugador1
                marcador.jugador2 = encuentro.jugador2
                marcador.save()

                competencia = form.cleaned_data['competencia']
                puntos_jugador1 = marcador.puntos_jugador1
                puntos_jugador2 = marcador.puntos_jugador2

                tabla_jugador1, _ = TablaPocisionesAjedrez.objects.get_or_create(
                    jugador=marcador.jugador1, competencia=competencia
                )
                tabla_jugador1.puntos += puntos_jugador1
                tabla_jugador1.partidas_jugadas += F('partidas_jugadas')
                tabla_jugador1.save()

                tabla_jugador2, _ = TablaPocisionesAjedrez.objects.get_or_create(
                    jugador=marcador.jugador2, competencia=competencia
                )
                tabla_jugador2.puntos += puntos_jugador2
                tabla_jugador2.partidas_jugadas += F('partidas_jugadas')
                tabla_jugador2.save()

                return redirect('lista_encuentros')

        return render(request, self.template_name, {'encuentro': encuentro, 'form': form})

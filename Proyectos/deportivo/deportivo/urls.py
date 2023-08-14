"""deportivo URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/3.0/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
from django.contrib import admin
from django.urls import path, include

from competencia import views
from competencia.views import HomeView, EquipoView, JugadorView, LeaguesView, GruposSorteoEquiposView, \
    FutbolView, lista_encuentros, encuentro_detail, JugadoresAjedrezView, GenerarEncuentroView, RegistrarMarcadorView
from competencia.login import LoginView, LogoutView

urlpatterns = [
    path('accounts/', include("allauth.urls")),
    path("login", LoginView.as_view(), name="login"),
    path("logout", LogoutView.as_view(), name="logout"),
    path('admin/', admin.site.urls),
]

urlpatterns += [
    path('', HomeView.as_view(), name="home"),
    path('futbol/', FutbolView.as_view(), name="futbol"),
    path('ajedrez/', JugadoresAjedrezView.as_view(), name='ajedrez'),
    path('create/', views.JugadorCreate.as_view(), name='form_jugador'),
    path('delete/<int:pk>/', views.JugadorDelete.as_view(), name='delete_jugador'),
    path('ajedrez/lista_encuentros/', lista_encuentros, name='lista_encuentros'),
    path('ajedrez/generar_encuentro/', GenerarEncuentroView.as_view(), name='generar_encuentros'),
    path('ajedrez/encuentro_editar/<int:pk>/', views.EncuentroEdit.as_view(), name='encuentro_editar'),
    path('encuentro_detail/<int:encuentro_id>/', encuentro_detail, name='encuentro_detail'),
    path('delete_encuentro/<int:pk>/', views.EncuentroDelete.as_view(), name='delete_encuentro'),
    path('encuentros/<int:encuentro_id>/registrar_marcador/', RegistrarMarcadorView.as_view(),
         name='registrar_marcadorAjedrez'),
    # ...
    path('futbol/leagues/<int:country_id>', LeaguesView.as_view(), name="ligas"),
    path('futbol/equipos/<int:league_id>', EquipoView.as_view(), name="equipos"),
    path('futbol/jugadores/<int:team_id>', JugadorView.as_view(), name="jugadores"),
    path('futbol/encuentros/<int:league_id>', GruposSorteoEquiposView.as_view(), name="encuentros")

]

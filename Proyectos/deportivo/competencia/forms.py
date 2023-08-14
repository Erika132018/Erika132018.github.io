from django.forms import ModelForm
from competencia.models import EncuentroAjedrez, Jugador, MarcadorAjedrez, Competencia
from django import forms

from django import forms
from django.forms import ModelForm
from .models import Jugador


class JugadorForm(ModelForm):
    class Meta:
        model = Jugador
        fields = '__all__'

        widgets = {
            'nombre': forms.TextInput(
                attrs={
                    'class': 'form-control',
                    'placeholder': 'Ingrese un nombre',
                }
            ),
            'apellido': forms.TextInput(
                attrs={
                    'class': 'form-control',
                    'placeholder': 'Ingrese un apellido',
                }
            ),
            'fecha_nacimiento': forms.TextInput(
                attrs={
                    'type': 'date',
                    'class': 'form-control text-center',
                }
            ),
            'dni': forms.TextInput(
                attrs={
                    'class': 'form-control',
                    'placeholder': 'Ingrese un dni',
                }
            ),
            'celular': forms.TextInput(
                attrs={
                    'class': 'form-control',
                    'placeholder': 'Ingrese un celular',
                }
            ),
            'direccion': forms.TextInput(
                attrs={
                    'class': 'form-control',
                    'placeholder': 'Ingrese una dirección',
                }
            ),
            'tipo': forms.Select(
                attrs={
                    'class': 'form-control',
                }
            ),
            'numeroCamiseta': forms.TextInput(
                attrs={
                    'class': 'form-control',
                    'placeholder': 'Ingrese un número de camiseta',
                }
            )
        }


class EncuentroForm(ModelForm):
    def __init__(self, *args, **kwargs):
        super().__init__(*args, **kwargs)
        self.fields['jugador1'].queryset = Jugador.objects.filter(tipo='Ajedrez')
        self.fields['jugador2'].queryset = Jugador.objects.filter(tipo='Ajedrez')

        self.fields['jugador1'].widget.attrs = {
            'class': 'form-control',
        }
        self.fields['jugador2'].widget.attrs = {
            'class': 'form-control',
        }
        self.fields['tipo'].widget.attrs = {
            'class': 'form-control',
        }
        self.fields['estado'].widget.attrs = {
            'class': 'form-control',
        }
        self.fields['lugar'].widget.attrs = {
            'class': 'form-control',
            'placeholder': 'Ingrese un lugar',
        }

    class Meta:
        model = EncuentroAjedrez
        fields = '__all__'

        widgets = {
            'fecha': forms.TextInput(
                attrs={
                    'type': 'date',
                    'class': 'form-control text-center',
                }
            ),
            'hora': forms.TextInput(
                attrs={
                    'type': 'time',
                    'class': 'form-control text-center',
                }
            ),
        }

    def clean(self):
        cleaned_data = super().clean()
        jugador1 = cleaned_data.get("jugador1")
        jugador2 = cleaned_data.get("jugador2")

        if jugador1 == jugador2:
            raise forms.ValidationError("El Jugador 1 no puede ser igual al Jugador 2.")


class MarcadorAjedrezForm(forms.ModelForm):
    competencia = forms.ModelChoiceField(queryset=Competencia.objects.all(),
                                         widget=forms.Select(attrs={'class': 'form-control'}))

    def __init__(self, *args, **kwargs):
        super().__init__(*args, **kwargs)

        self.fields['puntos_jugador1'].widget.attrs = {
            'class': 'form-control',
        }
        self.fields['puntos_jugador2'].widget.attrs = {
            'class': 'form-control',
        }

    class Meta:
        model = MarcadorAjedrez
        fields = ['puntos_jugador1', 'puntos_jugador2']





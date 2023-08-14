# Generated by Django 3.0.7 on 2023-08-13 01:30

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    dependencies = [
        ('competencia', '0007_auto_20230811_2146'),
    ]

    operations = [
        migrations.AlterField(
            model_name='competencia',
            name='temporada',
            field=models.ForeignKey(null=True, on_delete=django.db.models.deletion.CASCADE, related_name='temporadas_competencia', to='competencia.Temporada'),
        ),
        migrations.AlterField(
            model_name='competenciaajedrez',
            name='jugadores',
            field=models.ManyToManyField(null=True, related_name='jugadores_competencia_ajedrez', to='competencia.Jugador'),
        ),
        migrations.AlterField(
            model_name='competenciaajedrez',
            name='numero_participantes',
            field=models.IntegerField(default=1, null=True),
        ),
    ]

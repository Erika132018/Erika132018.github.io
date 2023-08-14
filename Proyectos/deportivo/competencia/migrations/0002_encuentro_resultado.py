# Generated by Django 3.0.7 on 2023-08-09 21:52

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    dependencies = [
        ('competencia', '0001_initial'),
    ]

    operations = [
        migrations.AddField(
            model_name='encuentro',
            name='resultado',
            field=models.ForeignKey(null=True, on_delete=django.db.models.deletion.CASCADE, related_name='encuentros_ganados', to='competencia.Jugador'),
        ),
    ]

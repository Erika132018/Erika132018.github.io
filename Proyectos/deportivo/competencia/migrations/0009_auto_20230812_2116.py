# Generated by Django 3.0.7 on 2023-08-13 02:16

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    dependencies = [
        ('competencia', '0008_auto_20230812_2030'),
    ]

    operations = [
        migrations.RemoveField(
            model_name='competenciaajedrez',
            name='jugadores',
        ),
        migrations.RemoveField(
            model_name='competenciaajedrez',
            name='numero_participantes',
        ),
        migrations.AddField(
            model_name='competenciaajedrez',
            name='max_jugadores',
            field=models.PositiveIntegerField(default=10),
        ),
        migrations.AlterField(
            model_name='grupo',
            name='competencia',
            field=models.ForeignKey(null=True, on_delete=django.db.models.deletion.CASCADE, related_name='competencia_grupo', to='competencia.Competencia'),
        ),
        migrations.CreateModel(
            name='Inscripcion',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('competencia', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='competencia_inscritos', to='competencia.Competencia')),
                ('jugador', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, related_name='jugadores_inscritos', to='competencia.Jugador')),
            ],
        ),
    ]

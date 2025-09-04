from django.db import models

# Create your models here.
class Categoria():
    categoria_nome = models.CharField(max_length=100, unique=True)
    descricao = models.TextField(max_length=300, blank=True)
    categoria_imagens = models.ImageField(upload_to='fotos/categoria')
    slug = models.SlugField(max_length=250, blank=True)
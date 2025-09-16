from django.db import models
from django.urls import reverse

# Create your models here.
class Categoria(models.Model):
    categoria_name = models.CharField(max_length=50, unique=True)
    # "slug" é uma parte de uma URL que identifica uma página; em /loja/chocolates/, "chocolates" é o slug.
    slug = models.SlugField(max_length=100, unique=True)
    descricao = models.TextField(max_length=255, blank=True)
    categoria_imagem = models.ImageField(upload_to='photos/categories/', blank=True)

    # Este método especial define que, quando nos referirmos a um objeto Categoria, ele será mostrado pelo seu nome, o que é muito mais amigável, especialmente na área administrativa.
    def __str__(self):
        return self.categoria_name
    
    def get_url(self):
        return reverse('produtos_por_categoria', args=[self.slug])
from django.contrib import admin
from .models import Categoria

# Register your models here.
class CategoriaAdmin(admin.ModelAdmin):
    # quando eu digitar o nome da categoria (categoria_name), preencha o campo slug automaticamente
    prepopulated_fields = {'slug': ('categoria_name',)}
    # na lista de categorias, mostrar as colunas "nome da categoria" e "slug", em vez do genérico "Categoria object (1)"
    list_display = ('categoria_name', 'slug')

admin.site.register(Categoria, CategoriaAdmin)
from django.contrib import admin
from categoria.models import Categoria

# Register your models here.
class CategoriaAdmin(admin.ModelAdmin):                 # Clase para permitir uma apresentação de atribuição automática de dados para o slug
    prepopulated_fields = {
        'slug': ('categoria_nome', )
    }

    list_display = ('categoria_nome', 'slug')
admin_site.register(Categoria)
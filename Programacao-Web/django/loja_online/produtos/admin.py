from django.contrib import admin
from .models import Produto

# Register your models here.
class ProdutoAdmin(admin.ModelAdmin):
    list_display = ('produto_nome', 'preco', 'estoque', 'categoria', 'modificado_em', 'esta_disponivel')
    prepopulated_fields = {'slug': ('produto_nome',)}

admin.site.register(Produto, ProdutoAdmin)
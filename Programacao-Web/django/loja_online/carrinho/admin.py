from django.contrib import admin
from .models import Carrinho, CarItem

# Register your models here.
class CarrinhoAdmin(admin.ModelAdmin):
    list_display = ('car_id', 'date_added')

class CarItemAdmin(admin.ModelAdmin):
    list_display = ('produto', 'carrinho', 'quantidade', 'is_active')

admin.site.register(Carrinho, CarrinhoAdmin)
admin.site.register(CarItem, CarItemAdmin)
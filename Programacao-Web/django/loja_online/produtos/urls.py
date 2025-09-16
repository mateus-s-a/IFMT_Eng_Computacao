from django.urls import path
from . import views

urlpatterns = [
    # criando um endereço URL para direcionar a página principal da loja
    path('', views.visualizarLoja, name='loja'),
]

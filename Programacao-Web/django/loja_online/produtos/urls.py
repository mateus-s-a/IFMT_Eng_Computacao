from django.urls import path
from . import views

urlpatterns = [
    # criando um endereço URL para direcionar a página principal da loja
    path('', views.visualizarLoja, name='loja'),
    path('<slug:categoria_slug>/', views.visualizarLoja, name='produtos_por_categoria'),
]

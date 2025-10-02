from django.urls import path
from . import views

urlpatterns = [
    # criando um endereço URL para direcionar a página principal da loja
    path('', views.visualizarLoja, name='loja'),    # (ex: /loja)
    path('<slug:categoria_slug>/', views.visualizarLoja, name='produtos_por_categoria'),    # ex: (/loja/doces/)
    path('<slug:categoria_slug>/<slug:produto_slug>/', views.produto_detalhe, name='produto_detalhe'),    # ex: (/loja/doces/brigadeiro)
]

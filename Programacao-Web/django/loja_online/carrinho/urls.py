from django.urls import path
from . import views

urlpatterns = [
    path('', views.visualizarCarrinho, name='carrinho'),
    path('adicionar_carrinho/<int:produto_id>/', views.adicionar_carrinho, name='adicionar_carrinho'),
    path('diminuir_car/<int:produto_id>/', views.diminuir_car, name='diminuir_car'),
]

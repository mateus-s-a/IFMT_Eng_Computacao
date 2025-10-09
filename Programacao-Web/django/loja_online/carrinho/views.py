from django.shortcuts import render, redirect, get_object_or_404
from produtos.models import Produto
from .models import Carrinho, CarItem
from django.core.exceptions import ObjectDoesNotExist

# Create your views here.
def _get_cart_id(request):
    """Função privada para obter ou criar o id do carrinho na sessão."""
    cart_id = request.session.session_key

    if not cart_id:
        cart_id = request.session.create()
    return cart_id

def adicionar_carrinho(request, produto_id):
    """Adiciona um produto ao carrinho de compras."""
    produto = get_object_or_404(Produto, id=produto_id)         # Busca o produto para colocar no carrinho
    
    try:
        carrinho = Carrinho.objects.get(car_id=_get_cart_id(request))
    except Carrinho.DoesNotExist:
        carrinho = Carrinho.objects.create(
            car_id=_get_cart_id(request)
        )
    carrinho.save()

    try:
        car_item = CarItem.objects.get(produto=produto, carrinho=carrinho)
        car_item.quantidade += 1
        car_item.save()
    except CarItem.DoesNotExist:
        car_item = CarItem.objects.create(
            produto=produto,
            quantidade=1,
            carrinho=carrinho
        )
        car_item.save()
    
    return redirect('carrinho')

def diminuir_car(request, produto_id):
    """Diminui a quantidade de um produto no carrinho"""
    carrinho = Carrinho.objects.get(car_id=_get_cart_id(request))
    produto = get_object_or_404(Produto, id=produto_id)
    car_item = CarItem.objects.get(produto=produto, carrinho=carrinho)

    if car_item.quantidade > 1:
        car_item.quantidade -= 1
        car_item.save()
    else:
        car_item.delete()

    return redirect('carrinho')

def remover_car_item(request, produto_id):
    """Remove um item por completo do carrinho."""
    carrinho = Carrinho.objects.get(car_id=_get_cart_id(request))
    produto = get_object_or_404(Produto, id=produto_id)
    car_item = CarItem.objects.get(produto=produto, carrinho=carrinho)
    car_item.delete()

    return redirect('carrinho')

def visualizarCarrinho(request, total=0, quantidade=0, car_items=None):
    try:
        carrinho = Carrinho.objects.get(car_id=_get_cart_id(request))
        car_items = CarItem.objects.filter(carrinho=carrinho, is_active=True)

        for car_item in car_items:
            total += (car_item.produto.preco * car_item.quantidade)
            quantidade += car_item.quantidade
    except ObjectDoesNotExist:
        pass    # Ignora se o carrinho ainda não existir

    context = {
        'total': total,
        'quantidade': quantidade,
        'car_items': car_items,
    }
    return render(request, 'loja/carrinho.html', context)
from django.shortcuts import render, get_object_or_404
from .models import Produto
from categoria.models import Categoria
from carrinho.models import CarItem
from carrinho.views import _get_cart_id

# Create your views here.
def visualizarLoja(request, categoria_slug=None):
    categorias = None
    produtos = None

    if categoria_slug != None:
        categorias = get_object_or_404(Categoria, slug=categoria_slug)
        produtos = Produto.objects.filter(categoria=categorias, esta_disponivel=True)
        produtos_quant = produtos.count()
    else:
        produtos = (Produto).objects.all().filter(esta_disponivel=True)
        produtos_quant = produtos.count()       # adiciona contagem de produtos ao 'context'

    context = {
        'produtos': produtos,
        'produtos_quant': produtos_quant,
    }
    return render(request, 'loja/loja.html', context)


def produto_detalhe(request, categoria_slug, produto_slug):
    """
    View para exibir detalhes de um produto específico
    """
    try:
        produto_unico = Produto.objects.get(categoria__slug=categoria_slug, slug=produto_slug)
        # Verifica se o produto já está no carrinho
        no_carrinho = CarItem.objects.filter(carrinho__car_id=_get_cart_id(request), produto=produto_unico).exists()
    except Exception as e:
        raise e
    
    context = {
        'produto': produto_unico,
        'no_carrinho': no_carrinho,     # Envia o boolean ao template pelo 'context'
    }

    return render(request, 'loja/produto_detalhe.html', context)
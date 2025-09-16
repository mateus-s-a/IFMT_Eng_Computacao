from django.shortcuts import render, get_object_or_404
from .models import Produto
from categoria.models import Categoria

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
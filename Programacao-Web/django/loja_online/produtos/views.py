from django.shortcuts import render
from .models import Produto

# Create your views here.
def visualizarLoja(request):
    produtos = (Produto).objects.all().filter(esta_disponivel=True)
    produtos_quant = produtos.count()       # adiciona contagem de produtos ao 'context'

    context = {
        'produtos': produtos,
        'produtos_quant': produtos_quant,
    }
    return render(request, 'loja/loja.html', context)
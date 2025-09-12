# from django.http import HttpResponse
from django.shortcuts import render
from produtos.models import Produto

def visualizarHome(request):
    # return HttpResponse('Home Page')
    
    # Busca todos os objetos do tipo Produto que estão disponíveis
    produtos = Produto.objects.all().filter(esta_disponivel=True)

    # Cria o dicionário de contexto para enviar os produtos para o template
    context = {
        'produtos': produtos,
    }
    
    return render(request, 'home.html', context)
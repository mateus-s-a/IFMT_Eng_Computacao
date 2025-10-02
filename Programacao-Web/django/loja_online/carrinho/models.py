from django.db import models
from produtos.models import Produto

# Create your models here.
class Carrinho(models.Model):
    car_id = models.CharField(max_length=250, blank=True)
    date_added = models.DateField(auto_now_add=True)

    def __str__(self):
        return self.car_id

class CarItem(models.Model):
    # Garanta que esta linha está correta
    produto = models.ForeignKey(Produto, on_delete=models.CASCADE)
    carrinho = models.ForeignKey(Carrinho, on_delete=models.CASCADE)
    quantidade = models.IntegerField()
    is_active = models.BooleanField(default=True)

    def __str__(self):
        # Corrigindo aqui para retornar o nome, que é uma string
        return self.produto.produto_nome
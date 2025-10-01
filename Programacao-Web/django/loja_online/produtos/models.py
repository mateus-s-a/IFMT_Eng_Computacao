from django.db import models
from django.urls import reverse
from categoria.models import Categoria      # importação modelo Categoria

# Create your models here.
class Produto(models.Model):
    produto_nome = models.CharField(max_length=200, unique=True)
    slug = models.SlugField(max_length=200, unique=True)
    descricao = models.TextField(max_length=500, blank=True)
    preco = models.DecimalField(max_digits=10, decimal_places=2)
    imagens = models.ImageField(upload_to='photos/produtos/')
    estoque = models.IntegerField()
    esta_disponivel = models.BooleanField(default=True)
    
    
    # models.ForeignKey(Categoria, ...): Isso cria a relação entre o Produto e a Categoria.
    # Dizemos que cada produto "pertence" a uma categoria.
    # ForeignKey é a "chave estrangeira" que cria essa ligação no banco de dados.
    
    # on_delete=models.CASCADE: Isso define uma regra importante: se uma categoria for deletada,
    # todos os produtos que pertencem a ela também serão deletados.
    categoria = models.ForeignKey(Categoria, on_delete=models.CASCADE)
    
    
    criado_em = models.DateTimeField(auto_now_add=True)
    modificado_em = models.DateTimeField(auto_now=True)

    def __str__(self):
        return self.produto_nome
    
    def get_url(self):
        return reverse('produto_detalhe', args=[self.categoria.slug, self.slug])
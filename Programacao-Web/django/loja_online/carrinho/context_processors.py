from .models import Carrinho, CarItem
from .views import _get_cart_id
from django.core.exceptions import ObjectDoesNotExist

def contador(request):
    car_count = 0
    if 'admin' in request.path:
        return {}
    else:
        try:
            carrinho = Carrinho.objects.filter(car_id=_get_cart_id(request)).first()
            if carrinho:
                car_items = CarItem.objects.filter(carrinho=carrinho)
                for car_item in car_items:
                    car_count += car_item.quantidade
        except Carrinho.DoesNotExist:
            car_count = 0
    
    return dict(car_count=car_count)
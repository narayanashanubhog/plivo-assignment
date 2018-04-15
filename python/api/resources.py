from tastypie.resources import ModelResource
from api.models import Contact
from tastypie.authorization import Authorization
class ContactResource(ModelResource):
    class Meta:
        queryset = Contact.objects.all()
        resource_name = 'contact'
        authorization = Authorization()
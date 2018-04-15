from django.db import models

# Create your models here.
class Contact(models.Model):
    name = models.CharField(max_length=200)
    emailaddress=models.CharField(max_length=30)
    phoneNumber=models.IntegerField(max_length=15)
def __str__(self):
        return '%s %s %s' % (self.name, self.emailaddress,self.phoneNumber)
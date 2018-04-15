# plivo-assignment
Contact Book Api

Rest Api Endpoints :

- [ ] Contact getContactDetail(String emailAddress)
- [ ] String saveContactDetail(Contact contactdetail)
- [ ] List<Contact> getContactDetails(String emailAddress, String name)
- [ ] boolean deleteContact(Contact contactdetail)
- [ ] String updatetContact(String contactId, Contact contact)
- [ ] List<Contact> getContactDetailsByName(String name)



```Beans ```
{
   "firstName":"Test",
   "lastName":"DEmo",
   "middleName":"N",
   "gender":"male",
   "emailAddress":"demo@outlok.com",
   "phoneNumber":{
   	"primaryNumber":984,
   	"secondaryNumber":12348,
   	"landLine":11223
   },
   "address":[
   	{
   	"addressLine1":"sffs",
   	"addressLine2":"sfs",
   	"city":"fssa",
   	"state":"sf",
   	"country":"fsdf",
   	"zipcode":"sf"
   	},
   	{
   	"addressLine1":"asds",
   	"addressLine2":"ssa",
   	"city":"sfs",
   	"state":"sfsf",
   	"country":"sf",
   	"zipcode":"sfs"
   	}
   ]
}

```Tech Stack ```
* Spring Boot
* Couchbase


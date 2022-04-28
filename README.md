# demoCrudTEST

Como un usuario puede tener muchos roles y un rol puede estar en muchos usuarios, la relacion es de muchos a muchos. 
Para no usar el @ManyToMany y crear una relacion circular en la base de datos decidi crear una nueva tabla para manejar la relacion, la cual tendria 
una relacion de uno a muchos con cada una.

Adicional cree Un servicio, un repositorio y un controlador para cada una de estas entidades.

Se guarda un usuario
![image](https://user-images.githubusercontent.com/51338140/165652768-a82c3410-da03-4d15-b018-a0d429dc9ead.png)
Se actualiza un usuario
![image](https://user-images.githubusercontent.com/51338140/165653367-2d409451-7069-4bcb-8964-6345f95ac812.png)
![image](https://user-images.githubusercontent.com/51338140/165652801-d1513202-456f-41dc-b56e-2dd9b93fe44b.png)
![image](https://user-images.githubusercontent.com/51338140/165652877-901e0a68-2266-4746-8325-c0cc01291fa7.png)
![image](https://user-images.githubusercontent.com/51338140/165652932-388cae3e-a193-4e4b-a9ff-685f68b55b44.png)
![image](https://user-images.githubusercontent.com/51338140/165652946-5a0b1aa6-29e0-45be-b38d-4b3c33e7e832.png)

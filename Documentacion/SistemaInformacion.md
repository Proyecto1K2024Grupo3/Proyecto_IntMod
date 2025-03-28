# Sistema de información

- [Indice Principal](/README.md)

Una tienda de videojuegos vende merchandising, consolas y videojuegos. De estos productos se debe almacenar el precio, número de existencias y nombre. De los videojuegos se quiere saber la fecha de lanzamiento y de el merchandising el tipo y el tamaño. Hay que almacenar tambíen que consolas han sustituido a otras consolas.

De los clientes que compran en la tienda se requiere conocer el nombre, el teléfono de contacto y el codigo de cliente. De cada compra se debe registrar la fecha y si se ha usado alguna promoción. Un cliente puede comprar más de un productos y un producto puede ser comprado por varios clientes.

Los clientes pueden participar en partidas de videojuegos que se organizan en salas de la tienda. Cada partida se identifica por un numero correlativo y hay que registrar en que sala se juega. Una partida tiene que ser jugada por dos clientes. De cada partida debe almacenarse el ganador y la duracion de esta.

Los empleados se encargan de atender a los clientes y manejar el inventario de los productos. Del empleado interesa registrar el DNI, la fecha de nacimiento, el teléfono de contacto y el codigo de empleado. Un empleado puede atender a varios clientes y un cliente puede ser atendido por varios empleados.

Existe un inventario de productos el cual es llevado por empleados. Varios empleados se encargan de manejar el inventario de productos, y estos productos pueden ser manejados por más de un empleado.

Los productos los suministran diferentes proveedores, un producto solo puede ser suministrado por un proveedor y un proveedor puede suministrar diferentes productos, de cada proveedor se desea conocer el NIF, nombre y direccion.

La tienda colabora con influencers para promocionar sus productos, interesa registrar el nombre del influencer para identificarlo, su usuario en redes sociales y la tarifa por la colaboración con la tienda. Cada influencer puede promocionar varios productos y los producto pueden ser promocionados por varios influencers.

## Decisiones

En la tienda hay varias salas en las que se juegan partidas entre dos clientes. Queremos recoger estos datos para en caso de alguna incidencia poder identificar que dos clientes se encontraban en la sala. Y almacenamos el ganador de cada partida porque el que mas partidas gane al mes se lleva un premio.

Queremos controlar el inventario de la tienda, por lo tanto almacenamos que empleados han organizado cada producto. Hemos decidido hacerlo de esta manera porque cada empleado se encargará de la integridad de sus productos. Un empleado se encargá de el merchandising, otro de las consolas... etc.

Hemos decidido recoger la tarifa de cada promoción en el atributo porque es un precio que depende de la repercusion del colaborador. A Ibai no le pagariamos lo mismo que a Aitor Medrano.

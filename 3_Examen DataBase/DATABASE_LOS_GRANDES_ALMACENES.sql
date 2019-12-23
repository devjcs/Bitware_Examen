-------------------------DATABASE-----------------------------------------------------------------------------------------------------------
CREATE DATABASE IF NOT EXISTS `los_grandes_almacenes` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `los_grandes_almacenes`;

CREATE TABLE `cajeros` (
  `cajero` int(11) NOT NULL,
  `nomapels` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `cajeros` (`cajero`, `nomapels`) VALUES
(1, 'angel'),
(2, 'jose'),
(3, 'lupe'),
(4, 'maria'),
(5, 'dulce');

CREATE TABLE `maquinas_registradoras` (
  `maquina` int(11) NOT NULL,
  `piso` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `maquinas_registradoras` (`maquina`, `piso`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5);

CREATE TABLE `productos` (
  `producto` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `precio` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `productos` (`producto`, `nombre`, `precio`) VALUES
(1, 'laptop', '100'),
(2, 'motocicleta', '2'),
(3, 'automovil', '4'),
(4, 'audifonos', '700'),
(5, 'microfono', '2');

CREATE TABLE `venta` (
  `cajero` int(11) NOT NULL,
  `maquina` int(11) NOT NULL,
  `producto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `venta` (`cajero`, `maquina`, `producto`) VALUES
(1, 1, 3),
(1, 1, 2),
(1, 1, 1),
(5, 5, 5),
(5, 5, 4),
(4, 4, 1),
(3, 3, 4),
(3, 3, 4),
(2, 2, 5),
(4, 4, 3);

ALTER TABLE `cajeros`
  ADD PRIMARY KEY (`cajero`);

ALTER TABLE `maquinas_registradoras`
  ADD PRIMARY KEY (`maquina`);

ALTER TABLE `productos`
  ADD PRIMARY KEY (`producto`);

ALTER TABLE `venta`
  ADD KEY `fk_venta_cajero` (`cajero`),
  ADD KEY `fk_venta_maquina` (`maquina`),
  ADD KEY `fk_venta_producto` (`producto`);

ALTER TABLE `venta`
  ADD CONSTRAINT `fk_venta_cajero` FOREIGN KEY (`cajero`) REFERENCES `cajeros` (`cajero`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_venta_maquina` FOREIGN KEY (`maquina`) REFERENCES `maquinas_registradoras` (`maquina`) ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_venta_producto` FOREIGN KEY (`producto`) REFERENCES `productos` (`producto`) ON UPDATE CASCADE;
COMMIT;

-----------------------------------------------------------------------------------------------------------------------------------------

--------------QUERYS--1------------------------------------------------------------------------------------------------------------------

SELECT productos.nombre AS nombre, 
productos.producto AS id, 
COUNT(venta.producto)AS Numero_de_ventas 
FROM venta 
JOIN productos 
ON productos.producto=venta.producto 
GROUP BY venta.producto 
ORDER BY COUNT(venta.producto) DESC

--------------QUERYS--2------------------------------------------------------------------------------------------------------------------

SELECT cajeros.nomapels AS Cajero,
productos.nombre AS Producto,
productos.precio AS Precio,
maquinas_registradoras.piso AS Piso_de_Caja
FROM venta
JOIN cajeros ON cajeros.cajero=venta.cajero
JOIN productos ON productos.producto=venta.producto
JOIN maquinas_registradoras ON maquinas_registradoras.maquina=venta.maquina

--------------QUERYS--3------------------------------------------------------------------------------------------------------------------

SELECT maquinas_registradoras.piso AS Piso_de_venta,
COUNT(venta.maquina) AS Ventas_Totales_Por_Piso
FROM maquinas_registradoras
JOIN venta ON venta.maquina=maquinas_registradoras.maquina
GROUP BY  maquinas_registradoras.piso

--------------QUERYS--4------------------------------------------------------------------------------------------------------------------

SELECT cajeros.cajero AS ID_Cajero,
cajeros.nomapels AS Nombre_Cajero,
SUM(productos.precio) AS Total_Vendido
FROM venta
JOIN cajeros ON cajeros.cajero=venta.cajero
JOIN productos ON productos.producto=venta.producto
GROUP BY cajeros.nomapels

--------------QUERYS--5------------------------------------------------------------------------------------------------------------------

SELECT cajeros.cajero AS ID_Cajero,
cajeros.nomapels AS Nombre_Cajero,
SUM(productos.precio) AS Total_Vendido
FROM venta
JOIN cajeros ON cajeros.cajero=venta.cajero
JOIN productos ON productos.producto=venta.producto
GROUP BY cajeros.nomapels


--------------QUERYS--6------------------------------------------------------------------------------------------------------------------

SELECT cajeros.cajero AS ID_Cajero,
cajeros.nomapels AS Nombre_Cajero,
SUM(productos.precio) AS Total_Vendido
FROM venta
JOIN cajeros ON cajeros.cajero=venta.cajero
JOIN productos ON productos.producto=venta.producto
GROUP BY cajeros.nomapels
HAVING SUM(productos.precio)<2500
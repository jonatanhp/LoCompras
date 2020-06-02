INSERT INTO Cliente (Nombes, Masdatos) VALUES ('Inversiones KP','Juliaca xd');
INSERT INTO Cliente (Nombes, Masdatos) VALUES ('San Juan','Puno xd');

SELECT 
p.id, p.nombres
,sum(DISTINCT pm.adelanto_do) as total_adelanto_do
,sum(DISTINCT pm.adelanto_so) as total_adelanto_so
,sum(DISTINCT c.saldo_do_porpagar) + sum(DISTINCT pm.porpagar_do) as total_porpagar_do
,sum(DISTINCT c.saldo_so_porpagar) + sum(DISTINCT pm.porpagar_so) as total_porpagar_so

,sum(DISTINCT pm.adelanto_do) - sum(DISTINCT c.saldo_do_porpagar) - sum(DISTINCT pm.porpagar_do) as saldo_do
,sum(DISTINCT pm.adelanto_so) - sum(DISTINCT c.saldo_so_porpagar) - sum(DISTINCT pm.porpagar_so) as saldo_so

FROM compra as c  
	inner join proveedor as p on p.id = c.prove_id
	inner join prove_mov as pm on pm.prove_id = p.id
--WHERE p.id =3
GROUP BY p.id, p.nombres


SELECT 
	strftime('%Y-%m-%d', fecha)  as fecha 
	
	FROM caja_aper_cierre
	WHERE strftime('%Y-%m-%d', fecha) = "2020-06-01"
	
select fecha from compra 
where strftime('%d/%m/%Y', fecha) between "31/05/2020" and "31/05/2020";

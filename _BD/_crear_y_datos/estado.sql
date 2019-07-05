use eurekabank;

alter table Empleado 
add emplestado boolean default 1 after emplclave;

alter table Cliente 
add clieestado boolean default 1 after clieemail;
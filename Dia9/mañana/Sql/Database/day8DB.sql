create database dia8;
use dia8;
drop database dia8;

delimiter $$
Create Trigger removefromStock  before insert on BillProd 
for each row
begin
update Products p SET ammount = ammount-1 where NEW.idProd = idProduct;
end; $$
delimiter ;

create table Clients(
idClient int primary key auto_increment,
firstname varchar(20) not null,
lastname varchar(20) not null,
dni varchar(20) not null,
Address varchar(20) not null,
birth Date not null

);
create table Vendor(
idVendor int primary key auto_increment,
firstname varchar(20) not null,
lastname varchar(20) not null,
dni varchar(20) not null,
Address varchar(20) not null,
birth Date not null,
salary double not null


);

create table Products(
idProduct int primary key auto_increment,
price double not null,
ammount int not null,
minStock int not null
);

create table Billings(
idBilling int primary key auto_increment,
datesql Datetime DEFAULT CURRENT_TIMESTAMP,
idClient int,
idVendor int,
Foreign key (idClient) references Clients(idClient) ON DELETE CASCADE,
Foreign key (idVendor) references Vendor(idVendor) ON DELETE CASCADE
);
create table BillProd(
idBP int primary key auto_increment,
idBilling int ,
idProd int ,
foreign key (idBilling) references Billings(idBilling)
);

insert into Products(idProduct, price,ammount,minStock) values (1,1,1,1);
insert into Clients(firstname,lastname,dni,Address,birth) values ("a", "a", "a", "a", 10/10/10);
insert into Vendor(firstname,lastname,dni,Address,birth, salary) values ("a", "a", "a", "a", 10/10/10, 12020);
insert into Billings (idClient, idVendor) values (1,1);
insert into BillProd(idBilling, idProd) values (1, 1);

select* from Clients;
select * from personInfo;
select * from Products;
select * from Vendor;
select * from Billings b where DATE(datesql) = '2022-4-16';


select firstname, lastname, dni, salary, idBilling from Vendor v inner join Billings b on b.idVendor = v.idVendor where v.idVendor = 1;

/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2020-06-11 09:10:06                          */
/*==============================================================*/

drop database if exists dp;

create database dp;

use dp;

drop table if exists Discount;

drop table if exists Goods;

drop table if exists GoodsList;

drop table if exists Orders;

drop table if exists User;

/*==============================================================*/
/* Table: Discount                                              */
/*==============================================================*/
create table Discount
(
   discountId           int not null auto_increment,
   discount             int,
   primary key (discountId)
);

/*==============================================================*/
/* Table: Goods                                                 */
/*==============================================================*/
create table Goods
(
   goodsId              int not null auto_increment,
   oriPrice             int,
   discountId           int,
   weight               int,
   inventory            int,
   primary key (goodsId)
);

/*==============================================================*/
/* Table: GoodsList                                             */
/*==============================================================*/
create table GoodsList
(
   goodsListId          int not null auto_increment,
   goodsId              int,
   goodsAmount          int,
   finalPrice           int,
   primary key (goodsListId)
);

/*==============================================================*/
/* Table: "Order"                                               */
/*==============================================================*/
create table Orders
(
   orderId              int not null auto_increment,
   orderPrice           int,
   num                  int,
   weight               int,
   goodsListId          int,
   primary key (orderId)
);

/*==============================================================*/
/* Table: User                                                  */
/*==============================================================*/
create table User
(
   userId               int not null auto_increment,
   userName             varchar(20),
   password             varchar(20),
   primary key (userId)
);

alter table Goods add constraint FK_Reference_1 foreign key (discountId)
      references Discount (discountId) on delete restrict on update restrict;

alter table GoodsList add constraint FK_Reference_2 foreign key (goodsId)
      references Goods (goodsId) on delete restrict on update restrict;

alter table Orders add constraint FK_Reference_3 foreign key (goodsListId)
      references GoodsList (goodsListId) on delete restrict on update restrict;


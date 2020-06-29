/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2020-06-11 09:10:06                          */
/*==============================================================*/
drop database if exists dp;

create database dp;

use dp;

drop table if exists Goods;

drop table if exists GoodsList;

drop table if exists Orders;

drop table if exists User;


/*==============================================================*/
/* Table: Goods                                                 */
/*==============================================================*/
create table Goods
(
    goodsId   int not null auto_increment,
    oriPrice  int,
    discount  int,
    weight    int,
    inventory int,
    goodsName varchar(20) unique,
    primary key (goodsId)
);

/*==============================================================*/
/* Table: GoodsList                                             */
/*==============================================================*/
# 订单商品列表
create table GoodsList
(
    goodsListId int not null auto_increment,
    orderId     int,
    goodsId     int,
    goodsAmount int,
    finalPrice  int,
    primary key (goodsListId)
);

/*==============================================================*/
/* Table: "Order"                                               */
/*==============================================================*/
# 订单表
create table Orders
(
    orderId    int not null auto_increment,
    orderPrice int,
    num        int,
    weight     int,
    status     char(1),
    primary key (orderId)
);

/*==============================================================*/
/* Table: User                                                  */
/*==============================================================*/
create table User
(
    userId   int not null auto_increment,
    userName varchar(20) unique,
    password varchar(20),
    primary key (userId)
);

alter table GoodsList
    add constraint FK_Reference_2 foreign key (goodsId)
        references Goods (goodsId) on delete restrict on update restrict;

alter table GoodsList
    add constraint FK_Reference_4 foreign key (orderId)
        references Orders (orderId) on delete restrict on update restrict;

insert into User (userName, password)
VALUES ('root', '123456');
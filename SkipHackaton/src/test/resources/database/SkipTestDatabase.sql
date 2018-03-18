USE MASTER
GO


CREATE DATABASE SKIPDB
GO

USE [SKIPDB]
GO

CREATE TABLE [dbo].[CUSTOMER](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[email] [varchar](255) NOT NULL,
	[name] [varchar](255) NOT NULL,
	[address] [varchar](255) NOT NULL,
	[creation] [datetime] NOT NULL,
	[password] [varchar](255) NOT NULL

) ON [PRIMARY]
GO

CREATE TABLE [dbo].[CUISINE](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](255) NOT NULL

) ON [PRIMARY]
GO

	
CREATE TABLE [dbo].[STORE](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](255) NOT NULL,
	[address] [varchar](255) NOT NULL,
	[cousineId] [int] NOT NULL

) ON [PRIMARY]
GO

CREATE TABLE [dbo].[PRODUCT](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [varchar](255) NOT NULL,
	[description] [varchar](255) NOT NULL,
	[storeId] [int] NOT NULL,
	[price]  decimal(13,2)  not null CONSTRAINT dfProduct_Price DEFAULT 0.00
	

) ON [PRIMARY]
GO

CREATE TABLE [dbo].[ORDER](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[date] [datetime] NOT NULL,
	[customerId] [int] NOT NULL,
	[deliveryAddress] [varchar](255) NOT NULL,
	[contact] [varchar](255) NOT NULL,
	[storeId] [int] NOT NULL,
	[total]  decimal(13,2)  not null CONSTRAINT dfOrder_total DEFAULT 0.00,
	[lastUpdate] [datetime] NOT NULL,
	[status] [varchar](255) NOT NULL
) ON [PRIMARY]
GO

CREATE TABLE [dbo].[ORDER_ITEMS](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[orderId] [int] NOT NULL,
	[productId] [int] NOT NULL,
	[quantity] [int] NOT NULL,
	[price]  decimal(13,2)  not null CONSTRAINT dfOrder_total DEFAULT 0.00,
	[total]  decimal(13,2)  not null CONSTRAINT dfOrder_total DEFAULT 0.00

) ON [PRIMARY]
GO
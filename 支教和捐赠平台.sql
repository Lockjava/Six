

create  database SptEducation
GO
USE  SptEducation
GO
create table admin(
AdminId varchar(15) not null primary key,
AdminName varchar(15) not null,
AdminPwd varchar(15) not null
)

GO
insert into admin values( 'A001','admin','123456')
GO
select * from admin
GO



create table users(
UserId varchar(50) not null primary key,
UserName varchar(30) not null,
UserPwd varchar(30),
UserRealName varchar(30),
UserGender varchar(5),
UserCard varchar(50),
UserTel varchar(30),
UserEmail varchar(30),
UserCity varchar(30),
UserOccupation varchar(50),
UserBirtnday  date,
)
GO

select * from users 
GO
SELECT * FROM users 
GO

create table useridentity(
UserId varchar(50) primary key,
UserStatue1 int,
UserStatue2 int
)
GO

select * from useridentity
GO


create table userapply(
UserId varchar(30) primary key,
UserCardPath varchar(50),
UserStatus varchar(10),--审核中，已通过，已驳回
)
GO


select * from userapply
GO





create table goodsdemand(
DemandTime datetime,
UserId varchar(30),
DemandTitle varchar(50),
DemandSide varchar(50),
DemandCity varchar(30),
DemandAddress varchar(80),
DemandPerson varchar(30),
DemandTel varchar(30),
DemandGoods varchar(30),
DemandValidity date,
DemandContent varchar(1000),
DemandPicture varchar(50),
DemandVideo varchar(50),
DemandStatus varchar(10),
primary key(UserId,DemandTime)

)
GO

select * from goodsdemand
GO


create table spedu(
SpeTime datetime,
UserId varchar(30),
SpeTitle varchar(50),
SpeSchool varchar(50),
SpeCity varchar(30),
SpeAddress varchar(80),
SpePerson varchar(30),
SpeTel varchar(30),
SpeQuantity varchar(30),
SpeStartTime date,
SpeEndTime date,
SpeContent varchar(1000),
SpePicture varchar(50),
SpeVideo varchar(50),
DemandStatus varchar(10),
primary key(SpeTime,UserId)
)
GO
select * from spedu
GO


create table journal(
JourTime datetime,
UserId varchar(30),
SpeTitle varchar(50),
JourContent varchar(1000),
JourAbout varchar(1000),
primary key(JourTime,UserId)
)
GO
select * from journal
GO

create table speapply(--支教申请
UserId varchar(30)primary key ,--申请人Id 
SAIdcardPhoto varchar(50),--身份证照片路径
SAPersonDescribe varchar(200),--个人简述
SAEducationBackground varchar(30),--个人教育背景
SASupportLevel varchar(20),--亲属支持情况，A支持，B不支持，C不知情
SATime date,--支教持续时间
SAPutonghua varchar(20),--A标准，B一般，C不标准

)GO
select * from speapply
GO

create table demandapply(--需求者申请
UserId varchar(30) primary key,--申请人Id
DAIdcardPhoto varchar(50),--身份证照片路径
DAPersonDescribe varchar(200),--个人简述
)GO
select * from demandapply
GO



create table message(--消息表，存储系统和用户以及用户与用户之间的私信
MTime datetime,--发送时间
MOutId varchar(20),--发送方Id
MInId varchar(20),--接收方Id
MContent varchar(200),--消息内容
primary key(MTime,MOutId,MInId),
) GO
select * from message
GO

create table spesignup(--支教报名表
SSTime datetime,--报名时间
UserId varchar(20),--报名人ID
SpeTime datetime,
SpeId varchar(30),
SpeTitle varchar(50),--报名的帖子
primary key(SSTime,UserId,SpeTime,SpeId),
)GO
select * from spesignup
GO

create table demandsignup(
DSTime datetime,--报名时间
UserId varchar(20),--报名人ID
DemandTime datetime,
DemandId varchar(30),
DemandTitle varchar(50),--报名的帖子
primary key(DSTime,UserId,DemandTime,DemandId),
)
GO
select * from demandsignup

GO
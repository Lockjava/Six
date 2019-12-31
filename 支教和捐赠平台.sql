

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
UserStatus varchar(10),--����У���ͨ�����Ѳ���
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

create table speapply(--֧������
UserId varchar(30)primary key ,--������Id 
SAIdcardPhoto varchar(50),--���֤��Ƭ·��
SAPersonDescribe varchar(200),--���˼���
SAEducationBackground varchar(30),--���˽�������
SASupportLevel varchar(20),--����֧�������A֧�֣�B��֧�֣�C��֪��
SATime date,--֧�̳���ʱ��
SAPutonghua varchar(20),--A��׼��Bһ�㣬C����׼

)GO
select * from speapply
GO

create table demandapply(--����������
UserId varchar(30) primary key,--������Id
DAIdcardPhoto varchar(50),--���֤��Ƭ·��
DAPersonDescribe varchar(200),--���˼���
)GO
select * from demandapply
GO



create table message(--��Ϣ���洢ϵͳ���û��Լ��û����û�֮���˽��
MTime datetime,--����ʱ��
MOutId varchar(20),--���ͷ�Id
MInId varchar(20),--���շ�Id
MContent varchar(200),--��Ϣ����
primary key(MTime,MOutId,MInId),
) GO
select * from message
GO

create table spesignup(--֧�̱�����
SSTime datetime,--����ʱ��
UserId varchar(20),--������ID
SpeTime datetime,
SpeId varchar(30),
SpeTitle varchar(50),--����������
primary key(SSTime,UserId,SpeTime,SpeId),
)GO
select * from spesignup
GO

create table demandsignup(
DSTime datetime,--����ʱ��
UserId varchar(20),--������ID
DemandTime datetime,
DemandId varchar(30),
DemandTitle varchar(50),--����������
primary key(DSTime,UserId,DemandTime,DemandId),
)
GO
select * from demandsignup

GO